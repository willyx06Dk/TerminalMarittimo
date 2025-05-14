package progetto_terminal_marittimo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
public class personaleDao {
    
    public String inserisci(String nome, String password, String ruolo) {
        List<personaleTerminal> l = this.trovaAddetto(nome, password);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO personale_terminale (username, password, ruolo) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, password);
                stmt.setString(3, ruolo);
                stmt.executeUpdate();
                return "ok";
            } catch (SQLException e) {
                e.printStackTrace();
                return "errore";
            }
        } else {
            return "errore, utente già presente";
        }
    }

    public List<personaleTerminal> trovaAddetto(String n, String p) {
        List<personaleTerminal> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM personale_terminale WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, p);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                personaleTerminal u = new personaleTerminal(rs.getInt("ID"),rs.getString("username"),rs.getString("password"),rs.getString("ruolo"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public personaleTerminal login(String n, String p) {
        List<personaleTerminal> l = this.trovaAddetto(n, p);
        if (!l.isEmpty() && l.size()==1) {
            int id=l.get(0).getID();
            String ruolo=l.get(0).getRuolo();
            return new personaleTerminal(id, n, p, ruolo);
        } else {
            return new personaleTerminal(-1, "", "", "");
        }
    }

    public String ottieniNome(int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM personale WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("username");
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}

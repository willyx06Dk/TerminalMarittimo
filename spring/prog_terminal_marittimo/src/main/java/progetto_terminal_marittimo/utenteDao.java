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
public class utenteDao {
    
    public String inserisci(String nome, String cognome, String username, String password, String email, String codice_identificativo_carta) {
        List<utente> l = this.trovaUtente(nome, password);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO cliente (nome, cognome, username, password, email, codice_identificativo_carta) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, cognome);
                stmt.setString(3, username);
                stmt.setString(4, password);
                stmt.setString(5, email);
                stmt.setString(6, codice_identificativo_carta);
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

    public List<utente> trovaUtente(String n, String p) {
        List<utente> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, p);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                utente u = new utente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("password")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public utente login(String n, String p) {
        List<utente> l = this.trovaUtente(n, p);
        
        if (!l.isEmpty() && l.size()==1) {
            int id=l.get(0).getID();
            return new utente(id, n, p);
        } else {
            return null;
        }
    }

    public String ottieniNome(int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("nome");
            }
            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
}

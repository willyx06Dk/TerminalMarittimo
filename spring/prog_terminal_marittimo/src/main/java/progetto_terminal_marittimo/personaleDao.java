package progetto_terminal_marittimo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class personaleDao {
    
    public String inserisci(String nome, String password, String ruolo) {
        List<personaleTerminal> l = this.trovaAddetto(nome, password);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO personale_terminal (nome, password, ruolo) VALUES (?, ?, ?)";
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
            String sql = "SELECT * FROM personale_terminal WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, p);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                personaleTerminal u = new personaleTerminal(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("password"),
                    rs.getString("ruolo")
                );
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
            return null;
        }
    }
}

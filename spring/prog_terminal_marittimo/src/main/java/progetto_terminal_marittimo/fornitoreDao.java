package progetto_terminal_marittimo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fornitoreDao {
    
    public String inserisci(String nome, String username, String password, String email) {
        List<fornitore> l = this.trovaFornitore(nome, password);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO fornitore (nome, email, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setString(4, email);
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

    public List<fornitore> trovaFornitore(String n, String p) {
        List<fornitore> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM fornitore WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, p);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                fornitore u = new fornitore(
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

    public fornitore login(String n, String p) {
        List<fornitore> l = this.trovaFornitore(n, p);
        
        if (!l.isEmpty() && l.size()==1) {
            int id=l.get(0).getID();
            return new fornitore(id, n, p);
        } else {
            return null;
        }
    }
}
    


package progetto_terminal_marittimo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import progetto_terminal_marittimo.GestoreDb;
import progetto_terminal_marittimo.modal.fornitore;

@CrossOrigin(origins = "*")
@Repository
public class fornitoreDao {
    
    public String inserisci(String nome, String username, String password, String email) {
        List<fornitore> l = this.trovaFornitore(nome, password);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO fornitore (nome, email, username, password) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setString(3, username);
                stmt.setString(4, password);
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
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornitore u = new fornitore(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("password"),
                    rs.getString("nome")
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
            return new fornitore(id, n, p, l.get(0).getNome());
        } else {
            return new fornitore(-1, "", "", "");
        }
    }

    public List<fornitore> getFornitori() {
        List<fornitore> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM fornitore";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                fornitore u = new fornitore(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("password"),
                    rs.getString("nome")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
    


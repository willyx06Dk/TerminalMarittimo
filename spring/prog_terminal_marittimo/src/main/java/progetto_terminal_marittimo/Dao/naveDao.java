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
import progetto_terminal_marittimo.modal.nave;

@CrossOrigin(origins = "*")
@Repository
public class naveDao {

    public String inserisci(String nome) {
        List<nave> l = this.trovaNave(nome);

        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO nave (nome) VALUES (?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
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

    public List<nave> trovaNave(String n) {
        List<nave> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM nave WHERE nome=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nave nav = new nave(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(nav);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<nave> ottieninavi() {
        List<nave> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM nave";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nave p = new nave(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

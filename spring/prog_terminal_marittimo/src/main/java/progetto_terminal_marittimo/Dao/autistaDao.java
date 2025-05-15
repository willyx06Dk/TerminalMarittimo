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
import progetto_terminal_marittimo.modal.autista;

@CrossOrigin(origins = "*")
@Repository
public class autistaDao {

    public List<autista> ottieniAutisti() {
        List<autista> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM autista";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                autista p = new autista(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("email")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

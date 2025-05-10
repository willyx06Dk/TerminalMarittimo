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
public class viaggiRegistratiDao {
    
    public String inserisci(int id_nave, int id_viaggio) {
        List<viaggio> l = this.trovaViaggio(id_viaggio);
        List<nave> n = this.trovaNave(id_nave);
        
        if (!l.isEmpty() && !n.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO viaggi_effetuati (id_nave, id_viaggio) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id_nave);
                stmt.setInt(2, id_viaggio);
                stmt.executeUpdate();
                return "ok";
            } catch (SQLException e) {
                e.printStackTrace();
                return "errore";
            }
        } else {
            return "errore, elementi non trovati";
        }
    }

    public List<viaggio> trovaViaggio(int id) {
        List<viaggio> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM viaggio WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                viaggio u = new viaggio(
                    rs.getInt("id"),
                    rs.getDate("data_partenza"),
                    rs.getDate("data_arrivo"),
                    rs.getInt("porto_partenza"),
                    rs.getInt("porto_arrivo"),
                    rs.getString("direttrice"),
                    rs.getInt("id_addetto")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<nave> trovaNave(int id) {
        List<nave> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM nave WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                nave u = new nave(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<viaggiRegistrati> getViaggi() {
        List<viaggiRegistrati> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM viaggi_effetuati JOIN viaggio ON viaggi_effetuati.id_viaggio=viaggio.ID JOIN nave ON viaggi_effetuati.id_nave=nave.ID";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                viaggiRegistrati u = new viaggiRegistrati(
                    rs.getDate("data_partenza"),
                    rs.getDate("data_arrivo"),
                    rs.getInt("porto_partenza"),
                    rs.getInt("porto_arrivo"),
                    rs.getString("direttrice"),
                    rs.getInt("id_addetto"),
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

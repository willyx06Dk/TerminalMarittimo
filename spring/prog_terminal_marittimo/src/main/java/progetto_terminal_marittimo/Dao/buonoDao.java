package progetto_terminal_marittimo.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import progetto_terminal_marittimo.GestoreDb;
import progetto_terminal_marittimo.modal.buono;

@CrossOrigin(origins = "*")
@Repository
public class buonoDao {

    public String inserisci(int quantita, String data, int id_emittente, int id_cliente, int id_merce) {
    try {
        java.sql.Date d = java.sql.Date.valueOf(data);
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "INSERT INTO buono (quantita_merce, data_rilascio, id_emittente, id_cliente, id_merce) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, quantita);
            stmt.setDate(2, d);
            stmt.setInt(3, id_emittente);
            stmt.setInt(4, id_cliente);
            stmt.setInt(5, id_merce);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }

    } catch (IllegalArgumentException e) {
        e.printStackTrace();
        return "errore formato data";
    }
}



    public List<buono> ottieniBuoni(int id) {
        List<buono> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM buono WHERE id_cliente=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                buono b = new buono(
                    rs.getInt("id"),
                    rs.getInt("quantita_merce"),
                    rs.getDate("data_rilascio"),
                    rs.getInt("id_emittente"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_merce")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String eliminaBuono(int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "DELETE FROM buono WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}

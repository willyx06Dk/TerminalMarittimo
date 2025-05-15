package progetto_terminal_marittimo.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import progetto_terminal_marittimo.GestoreDb;

@CrossOrigin(origins = "*")
@Repository
public class registroDao {
    
    public String inserisci(String data_ritiro, int peso_ritirato, int id_autista, String id_camion, int id_cliente) {
        Date d = java.sql.Date.valueOf(data_ritiro);
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "INSERT INTO registro (data_ritiro, peso_ritirato, id_autista, id_camion,id_cliente) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, d);
            stmt.setInt(2, peso_ritirato);
            stmt.setInt(3, id_autista);
            stmt.setString(4, id_camion);
            stmt.setInt(5, id_cliente);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }
}



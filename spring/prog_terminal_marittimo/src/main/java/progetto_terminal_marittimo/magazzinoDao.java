package progetto_terminal_marittimo;

import java.sql.Connection;
import java.sql.Date;
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
public class magazzinoDao {
    
    public String inserisci(int q, int m, int a, Date d) {
        List<magazzino> l = this.trovaMagazzino(q, m, a, d);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO magazzino (quantita_merce, id_merce, id_addetto, data_ultima_modifica) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, q);
                stmt.setInt(2, m);
                stmt.setInt(3, a);
                stmt.setDate(4, d);
                stmt.executeUpdate();
                return "ok";
            } catch (SQLException e) {
                e.printStackTrace();
                return "errore";
            }
        } else {
            int id=l.get(0).getID();
            int quant=q+l.get(0).getQuantita();
            return modificaQ(quant, id);
        }
    }

    public List<magazzino> trovaMagazzino(int q, int m, int a, Date d) {
        List<magazzino> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM magazzino WHERE quantita_merce=? AND id_merce=? AND id_addetto=? AND data_ultima_modifica=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, q);
            stmt.setInt(2, m);
            stmt.setInt(3, a);
            stmt.setDate(4, d);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                magazzino mag = new magazzino(
                    rs.getInt("ID"),
                    rs.getInt("quantita_merce"),
                    rs.getInt("id_merce"),
                    rs.getInt("id_addetto"),
                    rs.getDate("data_ultima_modifica")
                );
                lista.add(mag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String modificaQ(int q, int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "UPDATE magazzino SET quantita_merce=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, q);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            return "errore";
        }
    }

    public int trovaIDmagazzino(int q, int m, int a, Date d) {
        List<magazzino> l = this.trovaMagazzino(q, m, a, d);
        
        if (l.isEmpty()) {
            return -1;
        } else {
            return l.get(0).getID();
        }
    }

}
    


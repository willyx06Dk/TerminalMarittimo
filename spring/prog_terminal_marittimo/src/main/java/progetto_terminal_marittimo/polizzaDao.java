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
public class polizzaDao {
    
    public String inserisci(int q, int v, int m, int f) {
        List<polizza> l = this.trovaPolizza(q, v, m, f);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO polizza (quantita_merce, id_viaggio, id_merce, id_fornitore) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, q);
                stmt.setInt(2, v);
                stmt.setInt(3, m);
                stmt.setInt(4, f);
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

    public List<polizza> trovaPolizza(int q, int v, int m, int f) {
        List<polizza> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM polizza WHERE quantita_merce=? AND id_viaggio=? AND id_merce=? AND id_fornitore=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, q);
            stmt.setInt(2, v);
            stmt.setInt(3, m);
            stmt.setInt(4, f);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                polizza pol = new polizza(
                    rs.getInt("id"),
                    rs.getInt("quantita_merce"),
                    rs.getInt("id_viaggio"),
                    rs.getInt("id_merce"),
                    rs.getInt("id_fornitore")
                );
                lista.add(pol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<polizza> ottieniPolizzaFornitore(int idFornitore) {
        List<polizza> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM polizza WHERE id_fornitore=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idFornitore);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                polizza pol = new polizza(
                    rs.getInt("id"),
                    rs.getInt("quantita_merce"),
                    rs.getInt("id_viaggio"),
                    rs.getInt("id_merce"),
                    rs.getInt("id_fornitore")
                );
                lista.add(pol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
    


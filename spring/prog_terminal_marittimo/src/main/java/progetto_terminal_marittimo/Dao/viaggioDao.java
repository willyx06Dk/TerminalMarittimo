package progetto_terminal_marittimo.Dao;

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

import progetto_terminal_marittimo.GestoreDb;
import progetto_terminal_marittimo.modal.viaggio;

@CrossOrigin(origins = "*")
@Repository
public class viaggioDao {
    
    public String inserisci(Date dp, Date da, int pp, int pa, String d, int add) {
        List<viaggio> l = this.trovaViaggio(dp, da, pp, pa, d, add);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO viaggio (data_partenza, data_arrivo, porto_partenza, porto_arrivo, direttrice, id_addetto) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDate(1, dp);
                stmt.setDate(2, da);
                stmt.setInt(3, pp);
                stmt.setInt(4, pa);
                stmt.setString(5, d);
                stmt.setInt(6, add);
                stmt.executeUpdate();
                return "ok";
            } catch (SQLException e) {
                e.printStackTrace();
                return "errore";
            }
        } else {
            return "errore, viaggio già presente";
        }
    }

    public List<viaggio> trovaViaggio(Date dp, Date da, int pp, int pa, String d, int add) {
        List<viaggio> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM viaggio WHERE data_partenza=? AND data_arrivo=? AND porto_partenza=? AND porto_arrivo=? AND direttrice=? AND id_addetto=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, dp);
            stmt.setDate(2, da);
            stmt.setInt(3, pp);
            stmt.setInt(4, pa);
            stmt.setString(5, d);
            stmt.setInt(6, add);
            ResultSet rs = stmt.executeQuery();
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

    public int getIdViaggio(Date dp, Date da, int pp, int pa, String d, int add) {
        List<viaggio> l = this.trovaViaggio(dp, da, pp, pa, d, add);
        
        if (!l.isEmpty() && l.size() == 1) {
            int id = l.get(0).getID();
            return id;
        } else {
            return -1;
        }
    }
    
    public List<viaggio> getViaggi() {
        List<viaggio> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM viaggio";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
}
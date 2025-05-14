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
public class richiestaDao {
    
    public String inserisci(int id_c, int id_m, int q) {
        String controllo=this.controllaScorte(id_m, q);

        if(controllo.equals("errore")){
            return "errore";
        }
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "INSERT INTO richiesta (id_cliente, id_merce, quantita_merce) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_c);
            stmt.setInt(2, id_m);
            stmt.setInt(3, q);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore";
        }
    }

    public List<richiesta> ottieniRichieste() {
        List<richiesta> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM richiesta";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                richiesta r = new richiesta(
                    rs.getInt("ID"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_merce"),
                    rs.getInt("quantita_merce")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String controllaScorte(int id_m, int q) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM magazzino WHERE id_merce=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_m);
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);
            magazzino mag=new magazzino(-1, -1, -1, -1, null);
            while (rs.next()) {
                mag = new magazzino(
                    rs.getInt("ID"),
                    rs.getInt("quantita_merce"),
                    rs.getInt("id_merce"),
                    rs.getInt("id_addetto"),
                    rs.getDate("data_ultima_modifica")
                );
            }
            if(mag.getQuantita()<q){
                return "errore";
            }
            return "ok";
        } catch (SQLException e) {
            return "errore";
        }
    }

    public String eliminaRichiesta(int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "DELETE FROM richiesta WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            return "errore";
        }
    }

}
    


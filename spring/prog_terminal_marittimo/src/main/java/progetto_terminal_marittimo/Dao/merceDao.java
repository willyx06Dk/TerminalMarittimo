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
import progetto_terminal_marittimo.modal.merce;

@CrossOrigin(origins = "*")
@Repository
public class merceDao {
    
    public String inserisci(String nome, String categoria) {
        List<merce> l = this.trovaMerce(nome, categoria);
        
        if (l.isEmpty()) {
            try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
                String sql = "INSERT INTO merce (nome, categoria) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, categoria);
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

    public List<merce> trovaMerce(String n, String cat) {
        List<merce> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM merce WHERE nome=? AND categoria=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, cat);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                merce m = new merce(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("categoria")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<merce> ottienimerci() {
        List<merce> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM merce";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                merce p = new merce(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("categoria")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public String ottieniNomeMerce(int id) {
        try (Connection conn = DriverManager.getConnection(GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM merce WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getString("nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
    


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
import progetto_terminal_marittimo.modal.porto;

@CrossOrigin(origins = "*")
@Repository
public class portoDao {

    public String inserisci(String nome, String naz) {
        if (nome == null || nome.trim().isEmpty() ||
            naz  == null || naz.trim().isEmpty()) {
            return "errore: campi vuoti";
        }
        List<porto> l = trovaPorto(nome, naz);
        if (!l.isEmpty()) {
            return "errore: porto già presente";
        }

        try (Connection conn = DriverManager.getConnection(
                    GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "INSERT INTO porto (nome, nazionalita) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome.trim());
            stmt.setString(2, naz.trim());
            stmt.executeUpdate();
            return "ok";
        } catch (SQLException e) {
            e.printStackTrace();
            return "errore: SQLException";
        }
    }

    public List<porto> trovaPorto(String n, String naz) {
        List<porto> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                    GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM porto WHERE nome = ? AND nazionalita = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, naz);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new porto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nazionalita")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<porto> ottieniporti() {
        List<porto> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                    GestoreDb.URL, GestoreDb.USER, GestoreDb.PASSWORD)) {
            String sql = "SELECT * FROM porto";
            PreparedStatement stmt = conn.prepareStatement(sql);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new porto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("nazionalita")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

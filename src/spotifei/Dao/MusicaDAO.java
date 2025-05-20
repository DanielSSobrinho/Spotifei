/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Dao;

import java.sql.*;
import java.util.*;
import spotifei.Model.Musica;
import spotifei.Util.Conexao;

/**
 *
 * @author daniel.sobrinho
 */
public class MusicaDAO {
    public List<Musica> buscarMusicas(String termo) {
        List<Musica> lista = new ArrayList<>();

        String sql = """
            SELECT m.id, m.titulo, m.genero, a.nome AS artista
            FROM musica m
            JOIN artista a ON m.id_artista = a.id
            WHERE m.titulo ILIKE ? OR m.genero ILIKE ? OR a.nome ILIKE ?
            """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String like = "%" + termo + "%";
            stmt.setString(1, like);
            stmt.setString(2, like);
            stmt.setString(3, like);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Musica musica = new Musica(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("artista"), // aqui vem o nome do artista do JOIN
                    rs.getString("genero")
                    );
                lista.add(musica);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}

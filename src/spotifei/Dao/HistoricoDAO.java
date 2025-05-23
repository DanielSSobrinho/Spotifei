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
public class HistoricoDAO {

    public void registrarBusca(int idUsuario, int idMusica) {
        String sql = "INSERT INTO historico_busca (id_usuario, id_musica) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Musica> buscarHistorico(int idUsuario) {
        List<Musica> lista = new ArrayList<>();
        String sql = """
            SELECT m.id, m.titulo, m.genero, a.nome AS artista
            FROM historico_busca h
            JOIN musica m ON h.id_musica = m.id
            JOIN artista a ON m.id_artista = a.id
            WHERE h.id_usuario = ?
            ORDER BY h.data_busca DESC
            LIMIT 10
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Musica(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("artista"),
                    rs.getString("genero")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

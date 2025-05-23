/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Dao;
        
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import spotifei.Model.Playlist;
import spotifei.Util.Conexao;
import java.util.List;
import java.util.ArrayList;
import spotifei.Model.Musica;

/**
 *
 * @author daniel.sobrinho
 */
public class PlaylistDAO {
    public void criarPlaylist(String nome, int idUsuario) {
        String sql = "INSERT INTO playlist (nome, id_usuario) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Playlist> listarPlaylistsDoUsuario(int idUsuario) {
        List<Playlist> lista = new ArrayList<>();
        String sql = "SELECT id, nome FROM playlist WHERE id_usuario = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Playlist(rs.getInt("id"), rs.getString("nome")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void excluirPlaylist(int idPlaylist) {
        String sql = "DELETE FROM playlist WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPlaylist);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Musica> listarMusicasDaPlaylist(int idPlaylist) {
        List<Musica> lista = new ArrayList<>();
        String sql = """
            SELECT m.id, m.titulo, m.genero, a.nome AS artista
            FROM playlist_musica pm
            JOIN musica m ON pm.id_musica = m.id
            JOIN artista a ON m.id_artista = a.id
            WHERE pm.id_playlist = ?
        """;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPlaylist);
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

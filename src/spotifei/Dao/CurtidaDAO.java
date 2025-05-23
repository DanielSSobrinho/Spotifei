/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import spotifei.Util.Conexao;

/**
 *
 * @author daniel.sobrinho
 */
public class CurtidaDAO {
    public void curtirMusica(int idUsuario, int idMusica) {
        String sql = "INSERT INTO curtidas (id_usuario, id_musica) VALUES (?, ?) ON CONFLICT DO NOTHING";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

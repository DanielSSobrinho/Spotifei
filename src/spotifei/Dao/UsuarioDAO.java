/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import spotifei.Model.Usuario;

/**
 *
 * @author daniel.sobrinho
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
//    public void inserir(Usuario usuario) throws SQLException{
//        String sql = "insert into usuario (nome, usuario, senha) values ('"
//                      + usuario.getNome()    + "', '"
//                      + usuario.getUsuario() + "', '"
//                      + usuario.getSenha()   + "')";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.execute();
//        conn.close();
//    }
    
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, usuario, senha)"
                + "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
        }
    }
    
    
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "update usuario set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
    
    public void remover(Usuario usuario) throws SQLException{
        String sql = "delete from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
    
}


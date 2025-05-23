/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Controller;

import spotifei.Dao.UsuarioDAO;
import spotifei.Util.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import spotifei.Model.Usuario;
import spotifei.View.LoginView;
import spotifei.View.MenuView;

/**
 *
 * @author daniel.sobrinho
 */
public class ControllerLogin {
    private LoginView view;
    
    public ControllerLogin(LoginView view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Usuario usuario = new Usuario(null, 
                                view.getTxt_usuario_login().getText(),
                                view.getTxt_senha_login().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
             
                MenuView menu = new MenuView();
                menu.setIdUsuario(res.getInt("id"));
                menu.setVisible(true);

            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}

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
                //Usuario usuario2 = new Usuario(res.getString("nome"), 
                                         //res.getString("usuario"), 
                                         //res.getString("senha"));
                //AltExcView aec = new AltExcView(usuario2);
                //aec.setVisible(true);
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

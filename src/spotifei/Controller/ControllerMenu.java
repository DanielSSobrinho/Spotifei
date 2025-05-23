/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import spotifei.Dao.MusicaDAO;
import spotifei.Model.Musica;
import spotifei.View.MenuView;
import javax.swing.JOptionPane;
import spotifei.Dao.CurtidaDAO;
import spotifei.Dao.DescurtidaDAO;
/**
 *
 * @author daniel.sobrinho
 */
public class ControllerMenu {
    private MenuView view;

    public ControllerMenu(MenuView view) {
        this.view = view;
    }

    public void buscarMusicas() {
        String termo = view.getCampoBusca();
        MusicaDAO dao = new MusicaDAO();
        List<Musica> lista = dao.buscarMusicas(termo);

        DefaultTableModel tabela = (DefaultTableModel) view.getTabelaResultados().getModel();
        tabela.setRowCount(0); // limpa

        for (Musica m : lista) {
            tabela.addRow(new Object[]{
                m.getId(),
                m.getTitulo(),
                m.getArtista(),
                m.getGenero()
            });
        }
    }
    
    public void curtirMusica(int idUsuario) {
        int idMusica = view.getIdMusicaSelecionada();
        if (idMusica == -1) {
            JOptionPane.showMessageDialog(view, "Selecione uma música para curtir.");
            return;
        }

        CurtidaDAO dao = new CurtidaDAO();
        dao.curtirMusica(idUsuario, idMusica);

        JOptionPane.showMessageDialog(view, "Música curtida com sucesso!");
    }
    
    public void descurtirMusica(int idUsuario) {
        int idMusica = view.getIdMusicaSelecionada();
        if (idMusica == -1) {
            JOptionPane.showMessageDialog(view, "Selecione uma música para descurtir.");
            return;
        }

        DescurtidaDAO dao = new DescurtidaDAO();
        dao.descurtirMusica(idUsuario, idMusica);

        JOptionPane.showMessageDialog(view, "Música descurtida com sucesso!");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Model;

/**
 *
 * @author daniel.sobrinho
 */
public class Playlist {
    private int id;
    private String nome;

    public Playlist(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
    
}

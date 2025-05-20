/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spotifei.Model;

/**
 *
 * @author daniel.sobrinho
 */
public class Musica {
    private int id;
    private String titulo;
    private String artista;
    private String genero;

    public Musica(int id, String titulo, String artista, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getGenero() { return genero; }
}

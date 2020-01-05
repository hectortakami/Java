
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class CD {
    
    private String titulo;
    private String artista;
    private int pistas;

    public CD(String titulo, String artista, int pistas) {
        this.titulo = titulo;
        this.artista = artista;
        this.pistas = pistas;
    }
    
    public boolean equals(Object item){
        CD other = (CD)item;
        if ((other.artista).equals(this.artista)){
            return true;
        }
        return false;
    }
    
    public int compareTo(CD cd){
        return this.compareTo(cd);
    }

    @Override
    public String toString() {
        return "Titulo:" + titulo + ". Artista:" + artista + ". No.Pistas:" + pistas;
    }
    
    
   
    
    
}

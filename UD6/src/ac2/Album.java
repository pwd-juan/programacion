package ac2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        canciones = new ArrayList<>();
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getArtista() {
        return this.artista;
    }

    public boolean addSong(String tituloCancion, double duracionCancion) {
        boolean esAnadido = false;
        if (findSong(tituloCancion) == null) {
            canciones.add(new Cancion(tituloCancion, duracionCancion));
            esAnadido = true;
        }
        return esAnadido;
    }

    public boolean addToPlayList (int numPistaAlbum, LinkedList<Cancion> playList) {
        boolean esAnadido = false;

        if (numPistaAlbum < 0 || numPistaAlbum > canciones.size()) return false;

        if (!playList.contains(canciones.get(numPistaAlbum))){
            playList.add(canciones.get(numPistaAlbum));
            esAnadido = true;
        }
        return esAnadido;
    }

    public boolean addToPlayList (String tituloCancion, LinkedList<Cancion> playList) {
        boolean esAnadido = false;

        if (
                findSong(tituloCancion) != null &&
                !playList.contains(findSong(tituloCancion))
        ) {
            playList.add(findSong(tituloCancion));
            esAnadido = true;
        }

        return esAnadido;
    }

    private Cancion findSong(String tituloCancion) {
        for (Cancion cancion : this.canciones) {
            if(cancion.getTitulo().equals(tituloCancion)) return cancion;
        }
        return null;
    }
}

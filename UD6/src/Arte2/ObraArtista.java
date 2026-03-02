package Arte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObraArtista {
    private Map<Obra, Artista> relacion;
    private ArrayList<Artista> artistas;

    public ObraArtista() {
        relacion = new HashMap<>();
        artistas = new ArrayList<>();
    }

    public Map<Obra, Artista> getRelacion() {
        return relacion;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void anyadirArtista(Artista artista) {
        this.artistas.add(artista);
    }

    public void anyadirRelacion(Obra obra, Artista artista) {
        this.relacion.put(obra, artista);
    }

    public void anyadirRelacion(Obra obra, int numArtista) {
        anyadirRelacion(obra, this.artistas.get(numArtista));
    }

    public void generarEstructuraBasica() {
        Artista leonardo = new Artista("Leonardo da Vinci", "Italiano");
        Artista picasso = new Artista("Pablo Picasso", "Español");
        Artista auguste = new Artista("Auguste Rodin", "Francés");

        relacion.put(
                new Obra("Salvator Mundi", "Óleo sobre madera", "450M", 1500),
                leonardo
        );
        relacion.put(
                new Obra("La Gioconda", "Óleo sobre madera", "870M", 1503),
                leonardo
        );

        relacion.put(
                new Obra("El pensador", "Escultura", "11M", 1904),
                auguste
        );

        relacion.put(
                new Obra("El sueño", "Óleo sobre lienzo", "155M", 1932),
                picasso
        );
        relacion.put(
                new Obra("El Guernica", "Óleo sobre lienzo", "2000M", 1937),
                picasso
        );

        artistas.add(leonardo);
        artistas.add(picasso);
        artistas.add(auguste);
    }

    public ArrayList<Obra> getObrasArtista(Artista a) {
        ArrayList<Obra> obras = new ArrayList<>();

        for (Obra o : relacion.keySet()) {
            if (relacion.get(o) == a) obras.add(o);
        }

        return obras;
    }

    public ArrayList<Obra> getObrasArtista(int numA) {
        return getObrasArtista(artistas.get(numA));
    }

    public ArrayList<Obra> getObrasMasBaratas() {
        ArrayList<Obra> obras = new ArrayList<>();
        int precio = precioMasAltoBajo(false);

        for (Obra o : relacion.keySet()) {
            if (o.getPrecio() == precio) obras.add(o);
        }

        return obras;
    }

    public ArrayList<Obra> getObrasMasModernar() {
        ArrayList<Obra> obras = new ArrayList<>();
        int anyo = anyoMayorMenor(true);

        for (Obra o : relacion.keySet()) {
            if (o.getAnyoCreacion() == anyo) obras.add(o);
        }

        return obras;
    }

    private int precioMasAltoBajo(boolean orden) {
        int precio = (orden) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        if (orden) {
            for (Obra o : relacion.keySet()) {
                if (precio < o.getPrecio()) precio = o.getPrecio();
            }
        } else {
            for (Obra o : relacion.keySet()) {
                if (precio > o.getPrecio()) precio = o.getPrecio();
            }
        }

        return precio;
    }

    private int anyoMayorMenor(boolean orden) {
        int anyo = (orden) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        if (orden) {
            for (Obra o : relacion.keySet()) {
                if (anyo < o.getAnyoCreacion()) anyo = o.getAnyoCreacion();
            }
        } else {
            for (Obra o : relacion.keySet()) {
                if (anyo > o.getAnyoCreacion()) anyo = o.getAnyoCreacion();
            }
        }

        return anyo;
    }
}

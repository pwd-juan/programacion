package Arte2;

import java.util.HashMap;
import java.util.Map;

public class ObraArtista {
    private Map<Obra, Artista> relacion;

    public ObraArtista() {
        relacion = new HashMap<>();
    }

    public Map<Obra, Artista> getRelacion() {
        return relacion;
    }

    public void setRelacion(Map<Obra, Artista> relacion) {
        this.relacion = relacion;
    }

    public void generarEstructuraBasica() {
        Artista leonardo = new Artista("Leonardo da Vinci", "Italiano");
        Artista picasso = new Artista("Pablo Picasso", "Español");
        Artista auguste = new Artista("Auguste Rodin", "Francés");

        relacion.put(
                new Obra("Salvator Mundi", "Óleo sobre madera", "450M", "1500"),
                leonardo
        );
        relacion.put(
                new Obra("La Gioconda", "Óleo sobre madera", "870M", "1503"),
                leonardo
        );

        relacion.put(
                new Obra("El pensador", "Escultura", "11M", "1904"),
                auguste
        );

        relacion.put(
                new Obra("El sueño", "Óleo sobre lienzo", "155M", "1932"),
                picasso
        );
        relacion.put(
                new Obra("El Guernica", "Óleo sobre lienzo", "2000M", "1937"),
                picasso
        );
    }
}

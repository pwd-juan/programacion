public class Prueba3 {
    public static void main(String[] args) {
        Pelicula peli = new Pelicula("Titulo", 2.40, 8, 3.99);
        System.out.println(peli.getTitulo());
        System.out.println(peli.getMinutos());
        System.out.println(peli.getValoracion());

        Video ob1 = new Video("VHS", 90, 3.99);
        Pelicula ob2 = new Pelicula("ET", 120, 10, 3.99);
        System.out.println(ob1.toString());
        System.out.println(ob2.toString());
    }
}

class Video {
    String titulo;
    double minutos;
    double precio;

    public Video(String titulo, double minutos, double precio) {
        this.titulo = titulo;
        this.minutos = minutos;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return "Video{" +
                "titulo='" + titulo + '\'' +
                ", minutos='" + minutos + '\'' +
                '}';
    }
}

class Pelicula extends Video{
    int valoracion;

    public int getValoracion() {
        return valoracion;
    }

    public Pelicula (String titulo, double minutos, int valoracion, double precio) {
        super(titulo, minutos, precio);
        this.valoracion = valoracion;
    }
}

class VideoMusical extends Video {
    private String artista;
    private String categoria;

    public VideoMusical(String titulo, double minutos, String artista, String categoria, double precio) {
        super(titulo, minutos, precio);
        this.artista = artista;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "VideoMusical{" +
                "artista='" + artista + '\'' +
                ", categoria='" + categoria + '\'' +
                ", titulo='" + titulo + '\'' +
                ", minutos=" + minutos +
                '}';
    }
}

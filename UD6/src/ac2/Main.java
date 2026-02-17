package ac2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // c.) Crea una clase Main. Crea el siguiente código con datos reales:

        // xi.) En el main crea un ArrayList de álbumes y agrega al menos dos álbumes
        //      diferentes de diferentes artistas.
        Album ameri = crearAlbumAmeri();
        Album nochesDarshy = creearAlbumnNochesDarshy();

        ArrayList<Album> misAlbumes = new ArrayList<>();
        misAlbumes.add(ameri);
        misAlbumes.add(nochesDarshy);

        // xii.) Posteriormente crea una lista de reproducción (LinkedList) y añade canciones a
        //       la lista usando los dos métodos que tenemos, es decir, con el nombre y con el
        //       número de pista.
        LinkedList<Cancion> playList = new LinkedList<>();
        for (int i = 0; i < misAlbumes.get(0).getCanciones().size(); i ++) {
            misAlbumes.get(0).addToPlayList(
                    misAlbumes.get(0).getCanciones().get(i).getTitulo(),
                    playList
            );
        }

        for (int i = 0; i < misAlbumes.get(1).getCanciones().size(); i ++) {
            misAlbumes.get(1).addToPlayList(i, playList);
        }

        impAlbum(ameri);
        impAlbum(nochesDarshy);
        play(playList);
    }

    // xiii.) Crea un método que imprima una lista de reproducción. Utiliza iteradores.
    public static void imprimirPlayList(LinkedList<Cancion> playList) {
        ListIterator<Cancion> it = playList.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // xv.) Crea un método que contenga un menú con las opciones:
    public static void impMenu(){
        System.out.println("0 - Salir de la lista de reproducción.");
        System.out.println("1 - Reproducir siguiente canción en la lista.");
        System.out.println("2 - Reproducir la canción previa de la lista.");
        System.out.println("3 - Repetir la canción actual.");
        System.out.println("4 - Imprimir la lista de canciones en la playlist.");
        System.out.println("5 - Volver a imprimir el menú.");
        System.out.println("6 - Eliminar canción en reproducción.");
    }

    // xiv.) Crea un método estático llamado play que irá reproduciendo las canciones de
    // nuestra playlist. El método primero leerá lo que introduce el usuario y con un
    // iterador irá moviéndose por la lista de canciones de la playlist. Mostrará un menú
    // con las opciones, y realizará las respectivas acciones con un bucle while y un
    // switch. Pon mensajes cuando se alcance el inicio e intentemos volver atrás. Lo
    // mismo para cuando lleguemos al final de la playlist e intentemos reproducir la
    // siguiente canción. Muestra la canción que se está reproduciendo.
    public static void play(LinkedList<Cancion> playList) {
        ListIterator<Cancion> it = playList.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        Cancion cancionActual = it.next();
        boolean pasoHaciaDelante = true;
        String usu;

        while (tiempoEjecucion) {
            if (cancionActual != null){
                System.out.println("Actualmente reproduciendo: " + cancionActual);
            } else {
                System.out.println("Te has quedado sin canciones.");
            }

            impMenu();
            System.out.print("Selecciona una opción: ");
            usu = sc.nextLine();

            switch (usu) {
                case "0" -> tiempoEjecucion = false;
                case "1" -> {
                    if (!pasoHaciaDelante) {
                        if (it.hasNext()) it.next();
                        pasoHaciaDelante = true;
                    }

                    if (it.hasNext()) {
                        cancionActual = it.next();
                    } else {
                        System.out.print("\n\n");
                        System.out.println("No hay más adelante.");
                    }
                }
                case "2" -> {
                    if (pasoHaciaDelante) {
                        if (it.hasPrevious()) it.previous();
                        pasoHaciaDelante = false;
                    }

                    if (it.hasPrevious()){
                        cancionActual = it.previous();
                    } else {
                        System.out.print("\n\n");
                        System.out.println("No hay más atrás.");
                    }
                }
                case "3" -> System.out.println("\nActualmente reproduciendo: " + cancionActual + "\n");
                case "4" -> imprimirPlayList(playList);
                case "5" -> System.out.print("\n");
                case "6" -> {
                    if (!playList.isEmpty()) it.remove();

                    if (playList.isEmpty()) {
                        cancionActual = null;
                    } else if (it.hasNext()) {
                        cancionActual = it.next();
                    } else {
                        cancionActual = it.previous();
                    }
                }
                default -> System.out.println("\nIntroduce una opción valida.");
            }

            System.out.print("\n\n");
        }

        sc.close();
    }

    private static Album crearAlbumAmeri() {
        Album ameri = new Album("Ameri", "Duki");

        ameri.addSong("Leitmotiv", 1.25);
        ameri.addSong("Nueva Era", 3.37);
        ameri.addSong("Brindis", 3.00);
        ameri.addSong("Buscarte Lejos", 3.14);
        ameri.addSong("Hardaway", 3.36);
        ameri.addSong("Cine 🚬", 2.22);
        ameri.addSong("Vida de Rock", 3.01);
        ameri.addSong("No drama", 2.54);
        ameri.addSong("Barro", 3.21);
        ameri.addSong("Un Día Más", 2.45);
        ameri.addSong("Trato De Estar Bien", 3.33);
        ameri.addSong("Constelación", 3.20);
        ameri.addSong("Ameri", 3.19);

        return ameri;
    }

    private static Album creearAlbumnNochesDarshy() {
        Album nochesDarshy = new Album("noches en darshy", "7lossy");

        nochesDarshy.addSong("todo lo que me honra", 2.11);
        nochesDarshy.addSong("akatsuki", 2.24);
        nochesDarshy.addSong("la matanza del cordero", 1.28);
        nochesDarshy.addSong("WAKEUP!", 1.11);

        return nochesDarshy;
    }

    private static void impAlbum(Album album) {
        ArrayList<Cancion> cancionesAlbum = album.getCanciones();

        System.out.println(">---<");
        System.out.printf("Album: %s | Artista %s\n", album.getNombre(), album.getArtista());
        for (Cancion c : cancionesAlbum) {
            System.out.println(c);
        }
        System.out.println(">---<");
        System.out.print("\n");
    }
}

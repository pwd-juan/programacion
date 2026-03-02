package JuegoRol;

import java.util.ArrayList;

public class Jugadores {
    ArrayList<Personaje> personajes;

    public Jugadores() {
        this.personajes = new ArrayList<>();
    }

    public Personaje getPersonajePorNombre(String n) {
        Personaje pEncontrar = null;

        for (Personaje p : personajes) {
            if (p.getNombre().equals(n)) pEncontrar = p;
        }

        return pEncontrar;
    }

    public ArrayList<String> getNombrePersonajes() {
        ArrayList<String> nombres = new ArrayList<>();

        for (Personaje p : personajes) {
            nombres.add(p.getNombre());
        }

        return nombres;
    }

    public void genValores(Personaje pB) {
        for (Personaje p : personajes) {
            if (p.equals(pB)) {
                for (Herramienta h : p.getMochila()) {
                    h.setValor();
                }
            }
        }
    }

    public void desGenValores(Personaje pB) {
        for (Personaje p : personajes) {
            if (p.equals(pB)) {
                for (Herramienta h : p.getMochila()) {
                    h.limpiarValor();
                }
            }
        }
    }

    public void crearPersonajesBasicos() {
        personajes.add(new Personaje("Sergio", Personaje.Tipo.INVENTOR, 90));
        personajes.add(new Personaje("Mara", Personaje.Tipo.GUERRERA, 80));
        personajes.add(new Personaje("Miquel", Personaje.Tipo.RASTREADOR, 85));
        personajes.add(new Personaje("Claudia", Personaje.Tipo.MAGA, 110));
        personajes.add(new Personaje("Carlos", Personaje.Tipo.SABIO, 95));
        personajes.add(new Personaje("Alexia", Personaje.Tipo.EXPLORADORA, 100));

        personajes.get(0).anyadirHerramienta("Fórmula");
        personajes.get(0).anyadirHerramienta("Microscopio");
        personajes.get(0).anyadirHerramienta("Microorganismo");
        personajes.get(0).anyadirHerramienta("Autómata");

        personajes.get(1).anyadirHerramienta("Escudo");
        personajes.get(1).anyadirHerramienta("Ballesta");
        personajes.get(1).anyadirHerramienta("Hacha");
        personajes.get(1).anyadirHerramienta("Unicornio");

        personajes.get(2).anyadirHerramienta("Lupa");
        personajes.get(2).anyadirHerramienta("Escoba");
        personajes.get(2).anyadirHerramienta("Dragón");
        personajes.get(2).anyadirHerramienta("Brújula");

        personajes.get(3).anyadirHerramienta("Varita");
        personajes.get(3).anyadirHerramienta("Hechizo");
        personajes.get(3).anyadirHerramienta("Libro");
        personajes.get(3).anyadirHerramienta("Gata");

        personajes.get(4).anyadirHerramienta("Varita");
        personajes.get(4).anyadirHerramienta("Conjuro");
        personajes.get(4).anyadirHerramienta("Sombrero");
        personajes.get(4).anyadirHerramienta("Búho");

        personajes.get(5).anyadirHerramienta("Látigo");
        personajes.get(5).anyadirHerramienta("Semillas");
        personajes.get(5).anyadirHerramienta("Hacha");
        personajes.get(5).anyadirHerramienta("Yegua");
    }

    public void eliminarHerramienta(Personaje pB, Herramienta h) {
        for (Personaje p : personajes) {
            if (p.equals(pB)) {
                p.eliminarHerramienta(h);
            }
        }
    }

    public void aumentarVida(Personaje pB) {
        for (Personaje p : personajes) {
            if (p.equals(pB)) {
                p.aumentarVida(10);
            }
        }
    }

    public void printPersonajes(){
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }
}

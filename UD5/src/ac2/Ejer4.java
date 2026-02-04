package ac2;

public class Ejer4 {
    static void main() {
        AulaMal aula1 = new AulaMal(5, 10, 10);

        aula1.cantMesas = 2;
    }
}

class AulaMal {
    int cantOrdenadores;
    int cantMesas;
    int cantSillas;

    public AulaMal(int cantOrdenadores, int cantMesas, int cantSillas) {
        this.cantOrdenadores = cantOrdenadores;

        this.cantMesas = (cantMesas < cantOrdenadores) ? -1 : cantMesas;
        this.cantSillas = (cantSillas < cantMesas) ? -1 : cantSillas;
    }

    public int getCantOrdenadores() {
        return cantOrdenadores;
    }

    public void setCantOrdenadores(int cantOrdenadores) {
        this.cantOrdenadores = cantOrdenadores;
    }

    public int getCantMesas() {
        return cantMesas;
    }

    public void setCantMesas(int cantMesas) {
        this.cantMesas = cantMesas;
        if (cantMesas < cantOrdenadores) this.cantMesas = -1;
    }

    public int getCantSillas() {
        return cantSillas;
    }

    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
        if (cantSillas < cantMesas) this.cantSillas = -1;
    }
}

class Aula {
    private int cantOrdenadores;
    private int cantMesas;
    private int cantSillas;

    public Aula (int cantOrdenadores, int cantMesas, int cantSillas) {
        this.cantOrdenadores = cantOrdenadores;

        this.cantMesas = (cantMesas < cantOrdenadores) ? -1 : cantMesas;
        this.cantSillas = (cantSillas < cantMesas) ? -1 : cantSillas;
    }

    public int getCantOrdenadores() {
        return cantOrdenadores;
    }

    public void setCantOrdenadores(int cantOrdenadores) {
        this.cantOrdenadores = cantOrdenadores;
    }

    public int getCantMesas() {
        return cantMesas;
    }

    public void setCantMesas(int cantMesas) {
        this.cantMesas = cantMesas;
        if (cantMesas < cantOrdenadores) this.cantMesas = -1;
    }

    public int getCantSillas() {
        return cantSillas;
    }

    public void setCantSillas(int cantSillas) {
        this.cantSillas = cantSillas;
        if (cantSillas < cantMesas) this.cantSillas = -1;
    }
}

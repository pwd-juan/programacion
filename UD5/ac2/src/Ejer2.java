public class Ejer2 {
}

class HumanoEntreComillas {
    private Corazon cor;
    private Pulmon pulDer;
    private Pulmon pulIzq;

    public HumanoEntreComillas(Corazon cor, Pulmon pulDer, Pulmon pulIzq) {
        this.cor = cor;
        this.pulDer = pulDer;
        this.pulIzq = pulIzq;
    }

    public Corazon getCor() {
        return cor;
    }

    public Pulmon getPulDer() {
        return pulDer;
    }

    public Pulmon getPulIzq() {
        return pulIzq;
    }
}

class Corazon {
    private String uriculaDerecha;
    private String uriculaIzquierda;
    private String bentriculoDerecho;
    private String bentriculoIzquierdo;

    public Corazon(String uriculaDerecha, String uriculaIzquierda, String bentriculoDerecho, String bentriculoIzquierdo) {
        this.uriculaDerecha = uriculaDerecha;
        this.uriculaIzquierda = uriculaIzquierda;
        this.bentriculoDerecho = bentriculoDerecho;
        this.bentriculoIzquierdo = bentriculoIzquierdo;
    }

    public String getUriculaDerecha() {
        return uriculaDerecha;
    }

    public String getUriculaIzquierda() {
        return uriculaIzquierda;
    }

    public String getBentriculoDerecho() {
        return bentriculoDerecho;
    }

    public String getBentriculoIzquierdo() {
        return bentriculoIzquierdo;
    }
}

class Pulmon {
    private int cantArveolos;

    public Pulmon(int cantArveolos) {
        this.cantArveolos = cantArveolos;
    }

    public int getCantArveolos() {
        return cantArveolos;
    }
}

/*Si le cambio el nombre a la clase, tengo que cambiar la clase al archivo.*/
public class Ejer3 {
    static void main() {
        Tonel tonelA = new Tonel("000-1", 100);
        tonelA.anadirEliminarNivel(-50);
        Tonel tonelB = new Tonel("000-2", 100);
        Impresora impresora = new Impresora(true);

        int pagsImpresas;

        pagsImpresas = impresora.imprimir(900);

        System.out.printf("Sin tonel: %d\n", pagsImpresas);
        System.out.printf("Sin tonel: %d\n", impresora.getNumPagImpresas());
        System.out.printf("Sin tonel: %d\n", impresora.getNivelTinta());

        System.out.print("\n");

        impresora.anadirTonel(tonelA);
        pagsImpresas = impresora.imprimir(30);
        System.out.printf("Con tonel A: %d\n", pagsImpresas);
        System.out.printf("Con tonel A: %d\n", impresora.getNumPagImpresas());
        System.out.printf("Con tonel A: %d\n", impresora.getNivelTinta());

        System.out.print("\n");

        impresora.anadirTonel(tonelB);
        pagsImpresas = impresora.imprimir(20);
        System.out.printf("Con tonel B: %d\n", pagsImpresas);
        System.out.printf("Con tonel B: %d\n", impresora.getNumPagImpresas());
        System.out.printf("Con tonel B: %d\n", impresora.getNivelTinta());

        System.out.print("\n");

        impresora.anadirTonel(tonelA);
        pagsImpresas = impresora.imprimir(55);
        System.out.printf("Con tonel A 2º: %d\n", pagsImpresas);
        System.out.printf("Con tonel A 2º: %d\n", impresora.getNumPagImpresas());
        System.out.printf("Con tonel A 2º: %d\n", impresora.getNivelTinta());
    }
}

class Impresora {
    private Tonel tonel;
    private int numPagImpresas;
    private final boolean tieneDobleCara;

    public Impresora(boolean tieneDobleCara) {
        this.numPagImpresas = 0;
        this.tieneDobleCara = tieneDobleCara;
    }

    public Impresora(Tonel tonel, boolean tieneDobleCara) {
        this.tonel = tonel;
        this.numPagImpresas = 0;
        this.tieneDobleCara = tieneDobleCara;
    }

    public void anadirTonel(Tonel tonel) {
        this.tonel = tonel;
    }

    public void quitarTonel(Tonel tonel) {
        this.tonel = null;
    }

    public int imprimir(int nPags) {
        if (this.tonel == null) return -1;

        int cantTinta = (int) (nPags * 0.05);
        int suficienteTinta;

        if (this.tieneDobleCara) nPags = nPags / 2;

        suficienteTinta = this.tonel.anadirEliminarNivel(-cantTinta);
        if (suficienteTinta == -1) nPags = -1;

        if (nPags != -1) this.numPagImpresas = this.numPagImpresas + nPags;

        return nPags;
    }

    public int getNumPagImpresas() {
        return this.numPagImpresas;
    }

    public int getNivelTinta() {
        return (this.tonel != null) ? this.tonel.getNivelAct() : -1;
    }
}

class Tonel {
    private final String serie;
    private final int nivelMax;
    private int nivelAct;

    public Tonel(String serie, int nivelMax) {
        this.serie = serie;
        this.nivelMax = nivelMax;
        this.nivelAct = 100;
    }

    public int anadirEliminarNivel(int porAnadido) {
        int nivel;

        if (this.nivelAct + porAnadido > nivelMax) {
            nivel = -1;
        } else if (this.nivelAct + porAnadido < 0) {
            nivel = -1;
        } else {
            this.nivelAct = this.nivelAct + porAnadido;
            nivel = this.nivelAct;
        }

        return nivel;
    }

    public String getSerie() {
        return serie;
    }

    public int getNivelMax() {
        return nivelMax;
    }

    public int getNivelAct() {
        return nivelAct;
    }
}

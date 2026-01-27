/*Si le cambio el nombre a la clase, tengo que cambiar la clase al archivo.*/
public class Ejer3 {

}

class Impresora {
    private int nivelToner;
    private int numPagImpresas;
    private boolean tieneDobleCara;

    public Impresora(int nivelToner, boolean tieneDobleCara) {
        this.numPagImpresas = 0;
        this.nivelToner = nivelToner;
        this.tieneDobleCara = tieneDobleCara;
    }

    public int anadirNivel(int nivelAnadido){
        int nivel;

        if (this.nivelToner + nivelAnadido >= 100) {
            nivel = -1;
        } else if (this.nivelToner + nivelAnadido <= 0) {
            nivel = -1;
        } else {
            this.nivelToner = this.nivelToner + nivelAnadido;
            nivel = this.nivelToner;
        }

        return nivel;
    }

    public int imprimir(int nPags) {
        if (this.tieneDobleCara) nPags = nPags / 2;
        this.numPagImpresas = this.numPagImpresas + nPags;
        return nPags;
    }

    public int getNumPagImpresas() {
        return this.numPagImpresas;
    }
}

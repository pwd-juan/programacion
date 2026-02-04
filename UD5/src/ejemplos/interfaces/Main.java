public class Main {
    static void main(String[] args) {
        TelefonoMovil x = new TelefonoMovil(123);

        System.out.println(x.getTasa());
    }
}

class TelefonoMovil implements Impuesto {
    private int minuero;
    private boolean estaSonando;
    private double TASA_DE_IMPUESTO = 2; // se sobrescribe

    public TelefonoMovil(int x) {
        minuero = x;
    }

    public double getTasa() {return TASA_DE_IMPUESTO;}

    @Override
    public double calcularImpuestoAnual() {
        return TASA_DE_IMPUESTO * 12;
    }

    @Override
    public void imprimirImpuesto() {
        System.out.println("El impuesto anual del teléfono es " + calcularImpuestoAnual());
    }
}

interface Impuesto {
    // constantes
    double TASA_DE_IMPUESTO = 0.06;

    // métodos abstractos
    double calcularImpuestoAnual();

    void imprimirImpuesto();
}
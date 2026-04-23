package Ac1.Tarea3;

public class Pintura {
    private double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double cantPintura(Forma f) {
        return f.area() / this.cobertura;
    }
}

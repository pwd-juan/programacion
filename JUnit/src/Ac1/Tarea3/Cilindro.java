package Ac1.Tarea3;

public class Cilindro extends Forma {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        super("Cilindro");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }
}

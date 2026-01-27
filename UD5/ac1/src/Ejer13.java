public class Ejer13 {
    public static void main(String[] args) {
        Circulo circuloMal = new Circulo(-1);
        Cilindro cilindroMal = new Cilindro(1, -2);
        Cilindro cilindroMal2 = new Cilindro(-1, 2);

        System.out.println("1º Pruebas.:");
        System.out.println(circuloMal.getRadio());
        System.out.println(cilindroMal.getRadio() + " " + cilindroMal.getAltura());
        System.out.println(cilindroMal2.getRadio() + " " + cilindroMal2.getAltura());
        System.out.print("\n");

        Circulo circulo = new Circulo(20);

        System.out.println("Pruebas Circulo:");
        System.out.println(circulo.getRadio());
        System.out.println(circulo.getArea());
        System.out.print("\n");

        Cilindro cilindro = new Cilindro(10, 30);

        System.out.println("Pruebas Cilindro:");
        System.out.println(cilindro.getRadio());
        System.out.println(cilindro.getAltura());
        System.out.println(cilindro.getArea());
        System.out.println(cilindro.getVolumen());
    }
}

class Circulo {
    protected double radio;

    public Circulo(double radio) {
        this.radio = 0;
        if (radio > 0) this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double getArea() {
        return radio * radio * Math.PI;
    }
}

class Cilindro extends Circulo {
    protected double altura;

    public Cilindro(double radio, double altura) {
        if (radio < 0 || altura < 0) {
            altura = 0;
        }
        super(radio);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public double getVolumen() {
        return altura * radio * radio * Math.PI;
    }

    @Override
    public double getArea() {
        return 2 * radio * Math.PI * (radio + altura);
    }
}

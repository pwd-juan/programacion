package ac3;

public class Ejer4 {
    static void main() {
        Pintura p = new Pintura(250);

        Forma[] formas = new Forma[]{
                new Esfera(15),
                new Rectangulo(20, 35),
                new Cilindro(10, 30)
        };

        for (Forma f : formas) {
            /* Aquí por polimorfismo se escoge el área de la forma. */
            System.out.printf(
                    "Se necesita %.2f para pintar la forma %s, con area %.2f.\n",
                    p.cantPintura(f),
                    f.toString(),
                    f.area()
            );

            /* Aunque el array es de tipo forma, almacena objetos hijos de diferente tipo. */
            System.out.println(f.getClass());
        }
    }
}

class Forma {
    private String nombre;

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    public double area() {return 0;}

    @Override
    public String toString() {
        return this.nombre;
    }
}

class Esfera extends Forma {
    private double radio;

    public Esfera(double radio) {
        super("Esfera");
        this.radio = radio;
    }

    /* Se sobrescribe el método area heredado por la clase padre Forma */
    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}

class Rectangulo extends Forma {
    private double longitud;
    private double ancho;

    public Rectangulo(double longitud, double ancho) {
        super("Rectángulo");
        this.longitud = longitud;
        this.ancho = ancho;
    }

    /* Se sobrescribe el método area heredado por la clase padre Forma */
    @Override
    public double area() {
        return longitud*ancho;
    }
}

class Cilindro extends Forma {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        super("Cilindro");
        this.radio = radio;
        this.altura = altura;
    }

    /* Se sobrescribe el método area heredado por la clase padre Forma */
    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }
}

/* Por herencia no hace falta definir toString() para Rectangulo o Cilindro */

class Pintura {
    private double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double cantPintura(Forma f) {
        return f.area() / this.cobertura;
    }
}

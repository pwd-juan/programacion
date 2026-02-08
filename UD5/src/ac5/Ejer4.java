package ac5;

import java.util.Arrays;

public class Ejer4 {
    static void main() {
        // Ejer.: 4
        Rectangulo r = new Rectangulo(4, 5, 6);
        Triangulo t = new Triangulo(3, 10, 6);

        System.out.println("Area rectangulo " + r.getArea());
        System.out.println("Perimetro rectangulo " + r.getPerimeter());
        System.out.println(" --- ");
        System.out.println("Area triangulo " + t.getArea());
        System.out.println("Perimetro triangulo " + t.getPerimeter());

        System.out.println("\n --- \n");

        // Ejer.: 5
        Rectangulo rec = new Rectangulo(4, 2, 3);
        System.out.println("Área de rec: " + rec.getArea());
        System.out.println("Perimetro de rec: " + rec.getPerimeter());
        rec.redimensionar(2);
        System.out.println("Nuevo área de rec: " + rec.getArea());
        System.out.println("Nuevo perimetro de rec: " + rec.getPerimeter());

        System.out.println("\n --- \n");

        // Ejer.: 6
        Rectangulo[] arrayRec = new Rectangulo[]{
                new Rectangulo(4, 5, 10),
                new Rectangulo(4, 6, 3),
                new Rectangulo(4, 8, 3),
                new Rectangulo(4, 10, 11),
                new Rectangulo(4, 3, 3),
                new Rectangulo(4, 12, 12),
                new Rectangulo(4, 13, 11),
                new Rectangulo(4, 5, 6),
                new Rectangulo(4, 3, 3),
                new Rectangulo(4, 3, 3),
                new Rectangulo(4, 4, 3)
        };

        String msj;
        for (int i = 0; i < 2; i++) {
            msj = (i == 0) ?
                    "Primera iteración sin ordenar" :
                    "Segúnda iteración ya ordenada"
            ;
            System.out.println(msj);

            for (int j = 0; j < arrayRec.length; j++) {
                System.out.printf(
                        "El rectángulo en el indice %d tiene el area: %d \n",
                        j,
                        arrayRec[j].getArea()
                );
            }
            System.out.print('\n');

            Arrays.sort(arrayRec);
        }
    }
}

/*
* 4. Crea una clase abstracta Forma:
* a. – Atributos: numLados
* b. – Constructor: inicializar numLados
* c. – Método: getter para numLados
* d. – Métodos abstractos: getArea(), getPerimeter()
* Escribir una subclase Rectángulo
* e. – Atributos: ancho, alto
* Escribe una subclase Triángulo
* f. – Atributos: ancho, alto
* En otra clase, escriba un método main para definir un Rectángulo y un Triángulo.
*/

abstract class Forma {
    private int numLados;

    public Forma(int numLados) {
        this.numLados = numLados;
    }

    public int getNumLados() {
        return numLados;
    }

    public abstract int getArea();
    public abstract int getPerimeter();
}

class Rectangulo extends Forma implements Redimensionable, Comparable<Rectangulo> {
    int ancho;
    int largo;

    public Rectangulo(int numLados, int ancho, int largo) {
        super(numLados);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public int getArea() {
        return ancho * largo;
    }

    @Override
    public int getPerimeter() {
        return ancho * 2 + largo * 2;
    }

    @Override
    public void redimensionar(int x) {
        this.ancho = this.ancho + x;
        this.largo = this.largo + x;
    }

    @Override
    public int compareTo(Rectangulo o) {
        return this.getArea() - o.getArea();
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "ancho=" + ancho +
                ", largo=" + largo +
                '}';
    }
}

class Triangulo extends Forma {
    int ancho;
    int largo;

    public Triangulo(int numLados, int ancho, int largo) {
        super(numLados);
        this.ancho = ancho;
        this.largo = largo;
    }

    @Override
    public int getArea() {
        return ancho * largo / 2;
    }

    /**
     * Solo puede obtener un cálculo para un triángulo rectángulo.
     * Ya que pueden existir infinitos triángulos con la misma anchura y altura,
     * pero diferente perímetro.
     * @return El perímetro de un triángulo rectángulo.
     */
    @Override
    public int getPerimeter() {
        return (int) (ancho + largo + (Math.sqrt(Math.pow(ancho, 2) + Math.pow(largo, 2))));
    }
}


/*
* 5.- Crea una interfaz Redimensionable
*
* a.) Tiene un método redimensionar(int x) que cambia
* el tamaño de las dimensiones de una Forma por el factor x
*/
interface Redimensionable {
    void redimensionar(int x);
}

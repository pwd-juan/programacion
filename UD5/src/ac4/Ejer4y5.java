package ac4;

public class Ejer4y5 {
    /*
     * 5.- Implementa las clases del ejercicio anterior y añade un main para mostrar
     * los cálculos de impuestos e imprimir los objetos con ayuda del método toString,
     * para ello crea objetos de las clases Bienes, Comida, Juguete y Libro.
     */
    static void main() {
        Comida c = new Comida("Comida 1", 3.99, 500);
        System.out.println(c.toString());

        System.out.println("---");
        Juguete j = new Juguete("Juguete 1", 19.99, 3);
        System.out.println(j.toString());
        System.out.println(j.calImpuestos());

        System.out.println("---");
        Libro l = new Libro("Libro 1", 99.89, "Pedro Torres");
        System.out.println(l.toString());
        System.out.println(l.calImpuestos());

        System.out.println("\n");
        // b.) ¿Podrían algunos de los 4 objetos del main mantenerse en un array?
        Bienes[] b = new Bienes[]{
            new Comida("Comida 2", 4.99, 700),
            new Juguete("Juguete 2", 10.99, 50),
            new Libro("Libro 2", 5.89, "Roque Más")
        };

        // c.) ¿Cuál sería el tipo del array? Modifica tu main y crea un array con
        // objetos de ese tipo solo.
        System.out.println(b.getClass()); // tipo Bienes.
        System.out.println("---");

        // d.) Al imprimir el array de forma:
        System.out.println(b[0]);
        System.out.println(b[0].getClass());
        System.out.println(b[1]);
        System.out.println(b[1].getClass());
        System.out.println("---");
        // ¿Obtendremos el mismo resultado en las
        // sentencias anteriores? ¿Se llama al mismo método?
        // Se llama al método toString que se definen en las clases.
        // Y son del tipo que se especifica al añadirlas

        // e.) Vuelve a cambiar el código, ¿hay algunos objetos que podrían haber sido
        // declarados usando Imponible? Modifica y pega el código.
        Imponible j2 = new Juguete("Juguete 1", 19.99, 3);
        Imponible l2 = new Libro("Libro 1", 99.89, "Pedro Torres");

        // f.) Si intentamos imprimir esos objetos con “objeto1.toString()”, funcionará?
        // ¿A qué método estaremos llamando?
        System.out.println(j2.toString());
        System.out.println(j2.getClass());
        System.out.println("---");
        // Se está usando el toString de la clase que del tipo que es,
        // aunque se usará Imponible el objeto j2 es del tipo Juguete

        // g.) Añade el método getAutor() en la clase Libro e intenta imprimir el
        // autor del libro en el main que tenemos con objeto1.getAutor(). ¿Obtienes
        // algún error? ¿Por qué? ¿Es correcto el error? ¿Cómo podemos corregirlo?
        System.out.println(l2.getClass());
        //System.out.println(l2.getAutor()); // variable l2 of type Imponible
        System.out.println(l2.calImpuestos());
        // Solo recoge los métodos que descienden de Imponible, a pesar de decir que es
        // del tipo Libro.

        // Solución.
        Libro l3 = (Libro) l2;
        System.out.println(l3.getAutor());
    }
}

/*
* 4.- Decide qué tipo de implementación (Clase padre, hija o interfaz) sería la correcta para
* cada uno de los siguientes conceptos de una aplicación sabiendo que:
*/
// a.) Bienes, es una clase con dos atributos: descripción y precio(double).
class Bienes {
    private String descripcion;
    protected double precio;

    public Bienes(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }
}

// b.) Comida: con un atributo calorías double y el método toString.
// Los objetos de comida no están sujetos a impuestos.
class Comida extends Bienes {
    private double calorias;

    public Comida(String descripcion, double precio, double calorias) {
        super(descripcion, precio);
        calorias = calorias;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "Calorias=" + calorias +
                '}';
    }
}

// c.) Juguete: con un atributo edad mínima, método toString.
// Los objetos de juguete están sujetos a impuestos.
class Juguete extends Bienes implements Imponible {
    private int edadMinima;

    public Juguete(String descripcion, double precio, int edadMinima) {
        super(descripcion, precio);
        this.edadMinima = edadMinima;
    }

    @Override
    public double calImpuestos() {
        return tasaImpuestos * super.precio;
    }

    @Override
    public String toString() {
        return "Juguete{" +
                "edadMinima=" + edadMinima +
                '}';
    }
}

// d.) Libro: con un atributo autor, método toString.
// Los objetos de libros están sujetos a impuestos.
class Libro extends Bienes implements Imponible {
    private String autor;

    public Libro(String descripcion, double precio, String autor) {
        super(descripcion, precio);
        this.autor = autor;
    }

    // Ejer 5, g.)
    public String getAutor() {
        return this.autor;
    }

    @Override
    public double calImpuestos() {
        return tasaImpuestos * super.precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                '}';
    }
}

// e.) Imponible: hay muchas cosas que están sujetas a impuestos que no son bienes,
// como los servicios o el entretenimiento. Además, no todos los bienes están sujetos
// a impuestos. Así que queremos tener el concepto imponible como un concepto separado,
// no como parte del concepto de Bienes. Imponible tiene una tasa de impuestos del 6
// por ciento (double), y tiene un método de cálculo de impuestos.
interface Imponible {
    double tasaImpuestos = 0.06;

    double calImpuestos();
}

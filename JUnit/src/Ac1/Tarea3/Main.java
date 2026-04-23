package Ac1.Tarea3;

public class Main {
    public static void main(String[] args) {
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

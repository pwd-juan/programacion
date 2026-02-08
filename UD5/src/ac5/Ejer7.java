package ac5;

import java.util.Arrays;

/*
* 7.- Crea una clase Estudiante con atributos nombre, edad y altura. Queremos ordenar por
* edad y por altura a los estudiantes. Utilizando Comparable y el método compareTo debemos
* comparar los estudiantes y ordenarlos por altura primero (de mayor a menor) y si la
* altura coincide por edad. Por pantalla debe mostrarse la lista de estudiantes sin ordenar,
* y ordenado.
*/

public class Ejer7 {
    static void main() {
        Estudiante[] arrayEstudiante = new Estudiante[]{
                new Estudiante("Patri", 12, 1.70),
                new Estudiante("Manuel", 43, 1.73),
                new Estudiante("Javier", 72, 1.89),
                new Estudiante("Alicia", 52, 1.68),
                new Estudiante("Alberto", 35, 1.89)
        };

        Arrays.sort(arrayEstudiante);

        for (Estudiante e : arrayEstudiante) {
            System.out.println(e);
        }

        System.out.print("\n");

        Estudiante[] arrayEstudiante2 = new Estudiante[]{
                new Estudiante("Carlos", 25, 1.80),
                new Estudiante("Lucía", 19, 1.65),
                new Estudiante("Bruno", 32, 1.80),
                new Estudiante("Marta", 21, 1.75),
                new Estudiante("Diego", 25, 1.80),
                new Estudiante("Elena", 40, 1.92),
                new Estudiante("Sergio", 45, 1.65),
                new Estudiante("Valeria", 30, 1.75)
        };

        Arrays.sort(arrayEstudiante2);

        for (Estudiante e : arrayEstudiante2) {
            System.out.println(e);
        }
    }
}

class Estudiante implements Comparable<Estudiante>{
    private String nombre;
    private int edad;
    private double altura;

    public Estudiante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

    @Override
    public int compareTo(Estudiante o) {
        int r;

        if (this.altura > o.getAltura()) {
            r = -1;
        } else if (this.altura == o.getAltura()) {
            r = o.getEdad() - this.edad;
        } else {
            r = 1;
        }
        return r;
    }
}

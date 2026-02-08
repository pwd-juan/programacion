package ac5;

/*
* 1.- Diseña una clase abstracta con un constructor que imprime
* "Este es un constructor de clase abstracta", un método abstracto llamado
* abstract_method y un método no abstracto que imprime "Este es un método
* normal de clase abstracta". Una clase 'SubClase' hereda la clase
* abstracta y tiene el método llamado abstract_method que imprime "Este es un
* método abstracto implementado en una clase no abstracta". Ahora crea un objeto
* de SubClase y llame al método abstracto y al método no abstracto. (Analizar el
* resultado).
*/

public abstract class Ejer1 {
    static void main() {
        SubClase s = new SubClase();
        s.abstract_method();
        s.no_abstract_method();
    }
}

abstract class AbstractClass {
    public AbstractClass() {
        System.out.println("Este es un constructor de clase abstracta");
    }

    public abstract void abstract_method();

    public void no_abstract_method() {
        System.out.println("Este es un método normal de clase abstracta");
    }
}

class SubClase extends AbstractClass {
    public SubClase (){
        super();
    }

    @Override
    public void abstract_method() {
        System.out.println("Este es un método abstracto implementado en una clase no abstracta");
    }
}

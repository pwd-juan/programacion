package ac1;

public class Prueba10 {
    public static void main(String[] args) {

    }
}

class A {
    protected int aA;
    protected int aB;
    private int aC;

    public A(int aA, int aB) {
        this.aA = aA;
        this.aB = aB;
    }

    protected int getaA() {
        return aA;
    }

    protected int getaB() {
        return aB;
    }

    protected int getaC() {
        return aC;
    }
}

class B extends A {

    public B(int aA, int aB) {
        super(aA, aB);
    }

    @Override
    protected int getaB() {
        return 0;
    }
}

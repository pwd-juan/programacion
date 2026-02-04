package ac4;

public class PruebaEjer1 {
    static void main() {
        X x = new X();

        // System.out.println(x.const1); // Error por ambigüedad.
        System.out.println(x.getConst1());
        System.out.println(x.getConst2());
    }
}

interface Ejem1 {
    int const1 = 1;

    int a();
}

interface Ejem2 {
    int const1 = 2;

    int a();
}

class X implements Ejem1, Ejem2 {
    public int getConst1() {return Ejem1.const1;}
    public int getConst2() {return Ejem2.const1;}

    @Override
    public int a() {
        return 0;
    }
}
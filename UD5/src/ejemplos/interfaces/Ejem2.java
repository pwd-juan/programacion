public class Ejem2 {
    //*********Clase padre****
    public class Cubo {
        String nombre;
        public Cubo(String nombre) {
            this.nombre = nombre;
        }
    }
    //********Interfaces**************
    public interface Inicinerable {
        void incinerar();
    }
    //******************************
    public interface Explotable {
        void explotar();
    }

    //******Clases hijas************
    public class Cesped extends Cubo{
        public Cesped(String nombre) {
            super(nombre);
        }
    }
    //******************************
    class Dinamita extends Cubo implements Explotable{
        public Dinamita(String nombre) {
            super(nombre);
        }

        @Override
        public void explotar() {
            System.out.println("Boooo!!!");
        }
    }
    //********************************
    public class Madera extends Cubo implements Inicinerable{
        public Madera(String nombre) {
            super(nombre);
        }

        @Override
        public void incinerar() {
            System.out.println("fuegooooo!!!");
        }
    }
    //********************************
    public class Butano extends Cubo implements Inicinerable,Explotable{
        public Butano(String nombre) {
            super(nombre);
        }

        @Override
        public void explotar() {
            System.out.println("Bataboooo!!!");
        }

        @Override
        public void incinerar() {
            System.out.println("Fuegoonnnn!!!");
        }
    }
    //********************
    class Nave implements Explotable{
        String nombre;
        @Override
        public void explotar() {
            System.out.println("Exxxxxploooosiooooon!!!!");
        }
    }

    //********************
    void main(String[] args) {
        //podemos crear una dinamita y explotarla
        Dinamita dim1=new Dinamita("DinamitaCat1");
        dim1.explotar();
        //podemos crear madera y quemarla
        Madera mad1=new Madera("Pino");
        mad1.incinerar();
        //podemos crear butano y explotarlo y quemarlo
        Butano but1=new Butano("But10Litros");
        but1.incinerar();
        but1.explotar();
        //pero no podemos crear cesped que se queme o explote
        Cesped cesp1=new Cesped("artificial");

        Nave n = new Nave();
        n.nombre = "apollo 13";
        n.explotar();

        System.out.println(" - - - ");

        Explotable explotable=new Dinamita("DinamitaCat1");
        System.out.println(explotable.getClass());

        System.out.println(" - - - ");

        //creamos array de explotables
        Explotable[] miGranExplosion=new Explotable[3];
        //creamos explotables de diferente tipo
        miGranExplosion[0]=new Dinamita("DinamitaCat1");
        miGranExplosion[1]=new Butano("But10Litros");
        miGranExplosion[2]=new Nave();
        //llamamos a la gran explosion
        granExplosion(miGranExplosion);
    }

    public static void granExplosion(Explotable[] explotables){
        for (Explotable explotable:explotables) {
            //cada tipo de objeto genera su propia explosión
            explotable.explotar();
        }
    }
}

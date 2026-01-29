public class PruebaEjer1 {
    static void main() {
        /* a.) ¿Qué imprimiría el siguiente código? */
        Tarjeta card = new Vacaciones("Amy");
        card.saludar();

        card = new SanValentin("Bob", 3);
        card.saludar();

        card = new Aniversario("Cindy", 17);
        card.saludar();

        /* b.) Si tenemos las siguientes declaraciones, */
        Tarjeta c;
        Aniversario b;
        SanValentin v;
        Vacaciones h;

        c = new SanValentin("Debby", 8);
        // b = new SanValentin("Elroy", 3);
        v = new SanValentin("Fiona", 3);
        // h = new Aniversario ("Greg", 35);
    }
}

class Tarjeta {
    protected String destinatario;
    public void saludar() {}
}

class Vacaciones extends Tarjeta {
    public Vacaciones( String r ) {
        destinatario = r;
    }
    public void saludar() {
        System.out.println("Querido " + destinatario + ",");
        System.out.println("Saludos veraniegos!\n");
    }
}

class Aniversario extends Tarjeta {
    private int edad;
    public Aniversario ( String r, int edad) {
        this.destinatario = r;
        this.edad = edad;
    }
    public void saludar() {
        System.out.println("Querido " + destinatario + ",");
        System.out.println("Feliz " + edad + " Aniversario\n");
    }
}

class SanValentin extends Tarjeta {
    private int besos;
    public SanValentin ( String r, int k ) {
        destinatario = r;
        besos = k;
    }
    public void saludar() {
        System.out.println("Querido " + destinatario + ",");
        System.out.println("Con amor y besos,");
        for ( int j=0; j < besos; j++ )
            System.out.print("X");
        System.out.println("\n");
    }
}

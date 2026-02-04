package ac3;

public class Ejer3 {
    static void main() {
        Coche a = new CocheElectrico("Coche A");

        System.out.println(a.isMotor());

        Coche b = (Coche) a;
        System.out.println(b.isMotor());

        System.out.println("---");

        Camion camion = new Camion("Camnion 1", 3, false);
        System.out.println(camion.getEsCompuesto());
        System.out.println(camion.getRuedas());

        Coche c = (Coche) camion;
        System.out.println(c.getRuedas());
    }
}

class Coche {
    private String modelo;
    private boolean motor;
    private int ruedas;
    private int cilindros;

    public Coche(String modelo, int cilindros) {
        ruedas = 4;
        motor = true;
        this.modelo = modelo;
        this.cilindros = cilindros;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isMotor() {
        return motor;
    }

    public int getRuedas() {
        return ruedas;
    }

    public int getCilindros() {
        return cilindros;
    }

    public void arrancar() {
        System.out.printf("El %s arranca\n", modelo);
    }

    public void acelerar() {
        System.out.printf("El %s acelera.\n", modelo);
    }

    public void frenar() {
        System.out.printf("El %s frena.\n", modelo);
    }

    protected void setMotor(boolean motor) {
        this.motor = motor;
    }
}

class CocheElectrico extends Coche {
    public CocheElectrico(String modelo) {
        super(modelo, 0);
        super.setMotor(false);
    }
}

class Camion extends Coche {
    private boolean esCompuesto;

    public Camion(String modelo, int cilindros, boolean esCompuesto) {
        super(modelo, cilindros);
        this.esCompuesto = esCompuesto;
    }

    public boolean getEsCompuesto() {return esCompuesto;}

    public void acelerar() {
        System.out.printf("El %s acelera. Ten cuidado", super.getModelo());
    }
}

class Trailer extends Coche {
    private int cantAlmacenes;

    public Trailer(String modelo, int cilindros, int cantAlmacenes) {
        super(modelo, cilindros);
        this.cantAlmacenes = cantAlmacenes;
    }

    public void arrancar() {
        System.out.printf("Al %s le cuesta el arranque\n", super.getModelo());
    }
}

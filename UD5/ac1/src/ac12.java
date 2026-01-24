public class ac12 {
    public static void main(String[] args) {
        CocheElectrico tesla = new CocheElectrico("Tesla", 350, 4);
        CocheCombustion toyota = new CocheCombustion("Toyota", 350, 4, 6);

        tesla.getNombre();
        tesla.getVelocidadMax();
        tesla.getVelocidadAct();
        tesla.mover();
        tesla.acelerarDesacelerar(200);
        tesla.getVelocidadAct();
        tesla.acelerarDesacelerar(2000);
        tesla.getVelocidadAct();
        tesla.acelerarDesacelerar(20);
        tesla.getVelocidadAct();

        System.out.print("\n");

        toyota.getNombre();
        toyota.getVelocidadMax();
        toyota.getVelocidadAct();
        toyota.mover();
        toyota.acelerarDesacelerar(200);
        toyota.getVelocidadAct();
        toyota.acelerarDesacelerar(2000);
        toyota.getVelocidadAct();
        toyota.acelerarDesacelerar(20);
        toyota.getVelocidadAct();
    }
}

class Vehiculo {
    protected String nombre;
    protected int velocidadMax;
    protected int velocidadAct;

    public Vehiculo(String nombre, int velocidad) {
        this.nombre = nombre;
        this.velocidadMax = velocidad;
    }

    public String getNombre() {
        System.out.println(nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidadMax() {
        System.out.println(velocidadMax);
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public int getVelocidadAct() {
        System.out.println(velocidadAct);
        return velocidadAct;
    }

    public void setVelocidadAct(int velocidadAct) {
        this.velocidadAct = velocidadAct;
    }

    public void acelerarDesacelerar(int kmh) {
        if (velocidadMax > 0 && kmh >= 0) {
            velocidadAct = kmh;
            textoVelocidad();
        } else if (velocidadAct > 0) {
            System.out.println("Velocidad no valida.");
        } else {
            System.out.println("El coche no puede usarse.");
        }
    }

    public void mover() {
        System.out.println("El Vehiculo se mueve.");
    }

    protected void textoVelocidad() {
        if (velocidadAct > velocidadMax + 30) {
            velocidadAct = 0;
            System.out.println("Se ha roto el Vehiculo.");
            System.out.println("Ahora no se puede acelerar.");
            velocidadMax = 0;
        } else if (velocidadAct > velocidadMax) {
            System.out.println("Se ha cambiado de velocidad.");
            System.out.println("El Vehiculo esta muy al límite.");
        } else {
            System.out.println("Se ha cambiado de velocidad.");
        }
    }
}

class Coche extends Vehiculo {
    protected int numRuedas;

    public Coche(String nombre, int velocidad, int numRuedas) {
        super(nombre, velocidad);
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        System.out.println(numRuedas);
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
}

class CocheCombustion extends Coche {
    protected int cantMarchas;
    protected int marchaActual;

    public CocheCombustion(String nombre, int velocidad, int numRuedas, int cantMarchas) {
        super(nombre, velocidad, numRuedas);
        this.cantMarchas = cantMarchas;
    }

    public int getCantMarchas() {
        System.out.println(cantMarchas);
        return cantMarchas;
    }

    public void setCantMarchas(int cantMarchas) {
        this.cantMarchas = cantMarchas;
    }

    public int getMarchaActual() {
        System.out.println(marchaActual);
        return marchaActual;
    }

    public void setMarchaActual(int marchaActual) {
        this.marchaActual = marchaActual;
    }

    @Override
    public void mover() {
        System.out.println("El coche se mueve y hace mucho ruido.");
    }

    @Override
    public void textoVelocidad() {
        if (velocidadAct > velocidadMax + 30) {
            velocidadAct = 0;
            System.out.println("Se ha roto el coche.");
            System.out.println("Ahora no se puede acelerar ni hacer más ruido.");
            velocidadMax = 0;
        } else if (velocidadAct > velocidadMax) {
            System.out.println("Se ha cambiado de velocidad.");
            System.out.println("El coche esta muy al límite.");
            System.out.println("Y los oídos del copiloto también.");
        } else {
            System.out.println("Se ha cambiado de velocidad.");
        }
    }

    public void cambiarMarchas(int x) {
        if (x <= cantMarchas && x >= 0) {
            marchaActual = x;
            if (x != 0) {
                System.out.println("Se ha cambiado a: " + x);
            } else {
                System.out.println("Se ha cambiado a punto muerto.");
            }
        }
    }
}

class CocheElectrico extends Coche {
    CocheElectrico(String nombre, int velocidad, int numRuedas) {
        super(nombre, velocidad, numRuedas);
    }

    @Override
    public void mover() {
        System.out.println("La lavadora se mueve.");
    }

    @Override
    public void textoVelocidad() {
        if (velocidadAct > velocidadMax + 30) {
            velocidadAct = 0;
            System.out.println("Se ha roto la lavadora.");
            System.out.println("Ahora no se puede acelerar.");
            velocidadMax = 0;
        } else if (velocidadAct > velocidadMax) {
            System.out.println("Se ha cambiado de velocidad.");
            System.out.println("La lavadora esta muy al límite.");
        } else {
            System.out.println("Se ha cambiado de velocidad.");
        }
    }
}

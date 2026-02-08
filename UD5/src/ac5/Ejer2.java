package ac5;

public class Ejer2 {
    static void main() {
        HourlyEmployee trabajadorPorHoras = new HourlyEmployee(
                "Pancracio",
                "Ayudante de Marketing",
                20.50,
                999
        );

        System.out.println(trabajadorPorHoras.getNombre());
        System.out.println(trabajadorPorHoras.getCargo());
        System.out.println("Tasa de pago " + trabajadorPorHoras.getTasaPago());
        System.out.println("Horas trabajadas " + trabajadorPorHoras.getHorasTrabajadas());
        System.out.println("Hay que pagarle " + trabajadorPorHoras.calculateWeeklyPay());

        System.out.print("\n");

        trabajadorPorHoras.setHorasTrabajadas(
                trabajadorPorHoras.getHorasTrabajadas() + 5
        );
        System.out.println("Horas trabajadas " + trabajadorPorHoras.getHorasTrabajadas());
        System.out.println("Hay que pagarle " + trabajadorPorHoras.calculateWeeklyPay());

        System.out.println(" --- ");

        SalaryEmployee trabajadorAsalariado = new SalaryEmployee(
                "Pepe Pichuela",
                "Encargado Superior en Administración de vegetales",
                324.98
        );

        System.out.println(trabajadorAsalariado.getNombre());
        System.out.println(trabajadorAsalariado.getCargo());
        System.out.println("Salario semanal " + trabajadorAsalariado.getSalarioSemanal());
        System.out.println("Hay que pagarle " + trabajadorAsalariado.calculateWeeklyPay());
    }
}

/*
* 2.- Diseña una jerarquía de clases que empiece en la clase Employee que incluya
* subclases para HourlyEmployee y SalaryEmployee. Los atributos compartidos por estas
* clases incluyen el nombre y el cargo del empleado, además de los métodos getter y setter
* necesarios para esos atributos. Los empleados asalariados necesitan un atributo para el
* salario semanal y los métodos correspondientes para acceder y cambiar esta variable. Los
* empleados por hora deben tener una tasa de pago y una variable de horas trabajadas. Debería
* haber un método abstracto llamado "calculateWeeklyPay()", definido de forma abstracta en la
* superclase e implementado en las subclases. La paga del trabajador asalariado es solo el
* salario semanal. El pago de un empleado por hora es simplemente la tarifa de pago por horas
* trabajadas.
*/

abstract class Employee {
    private String nombre;
    private String cargo;

    public Employee(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public abstract double calculateWeeklyPay();
}

class HourlyEmployee extends Employee {
    private double tasaPago;
    private double horasTrabajadas;

    public HourlyEmployee(String nombre, String cargo, double tasaPago, double horasTrabajadas){
        super(nombre, cargo);
        this.tasaPago = tasaPago;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTasaPago() {
        return tasaPago;
    }

    public void setTasaPago(double tasaPago) {
        this.tasaPago = tasaPago;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calculateWeeklyPay() {
        return this.tasaPago * this.horasTrabajadas;
    }
}

class SalaryEmployee extends Employee {
    private double salarioSemanal;

    public SalaryEmployee(String nombre, String cargo, double salarioSemanal){
        super(nombre, cargo);
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal;
    }

    @Override
    public double calculateWeeklyPay() {
        return this.salarioSemanal;
    }
}

package Ac2;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String nombre, String numero) {
        return new Contacto(nombre, numero);
    }

    @Override
    public boolean equals(Object c){
        Contacto cN = (Contacto) c;
        return (name.equals(cN.getName()) || phoneNumber.equals(cN.getPhoneNumber()));
    }
}

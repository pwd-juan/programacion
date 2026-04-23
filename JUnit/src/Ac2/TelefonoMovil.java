package Ac2;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto c) {
        boolean existe = false;
        if (!myContacts.contains(c) && !c.getPhoneNumber().equals(myNumber)) {
            myContacts.add(c);
            existe = true;
        }
        return existe;
    }

    public boolean updateContact(Contacto cA, Contacto cN) {
        boolean esRepetido = false;
        boolean e = false;
        boolean existeContacto = true;

        if (!myContacts.contains(cA)) {return false;}

        for (Contacto c : myContacts) {
            if (!c.getName().equals(cA.getName())) {
                existeContacto = false;
            }

            if (c.equals(cA)) continue;

            if (
                c.getPhoneNumber().equals(cN.getPhoneNumber()) ||
                c.getName().equals(cN.getName())
            ) {
                esRepetido = true;
            }
        }

         if (existeContacto && !esRepetido && myContacts.contains(cA) && !cN.getPhoneNumber().equals(myNumber)) {
            myContacts.set(myContacts.indexOf(cA), cN);
            e = true;
        }
        return e;
    }

    public boolean removeContact(Contacto c) {
        return myContacts.remove(c);
    }

    private int findContact(Contacto c) {
        return myContacts.indexOf(c);
    }

    private int findContact(String nombre) {
        int existe = -1;

        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(nombre)) existe = i;
        }

        return existe;
    }

    public Contacto queryContact(String nombre) {
        return (findContact(nombre) == -1) ? null : myContacts.get(findContact(nombre));
    }

    public void printContacts() {
        System.out.print("\n");
        System.out.println("Lista de contactos:");

        if (myContacts.isEmpty()) System.out.println("No existe ningún contacto todavía.");

        for (int i = 0; i < myContacts.size(); i++) {
            System.out.printf(
                    "%d. %s -> %S\n",
                    i+1,
                    myContacts.get(i).getName(),
                    myContacts.get(i).getPhoneNumber()
            );
        }

        System.out.print("\n");
    }
}

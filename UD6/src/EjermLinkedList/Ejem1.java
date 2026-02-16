package EjermLinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ejem1 {
    public static void main(String[] args) {
        LinkedList<String> lugares = new LinkedList<String>();
        lugares.add("Roma");
        lugares.add("París");
        lugares.add("Amsterdam");
        lugares.add("Toronto");
        lugares.add("Miami");
        String primero = lugares.getFirst();
        String ultimo = lugares.getLast();

        System.out.println(primero);
        System.out.println(ultimo);

        printList(lugares);
        addInOrder(lugares, "asd");
        addInOrder(lugares, "RRRRRRRRRRR");
        printList(lugares);
    }

    public static void printList(LinkedList<String> lugares) {
        Iterator<String> it = lugares.iterator();
        while (it.hasNext()) {
            System.out.println("Nodo: " + it.next());
        }
        System.out.println("-----");
    }

    private static boolean addInOrder(LinkedList<String> lugares, String newItem) {
        ListIterator<String> it = lugares.listIterator();
        while (it.hasNext()) {
            int comparacion = it.next().compareTo(newItem);
            if (comparacion == 0) {
                //no queremos añadir porque no queremos tener duplicados
                System.out.println("el lugar " + newItem + " ya está incluido");
                return false;
            } else if (comparacion > 0) { //newItem es más pequeño
                it.previous();
                it.add(newItem);
                return true;
            }
        }
        it.add(newItem);
        return true;
    }
}

package ac3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public Main() {
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);

        ubicaciones.get(2).addExit("N", 5);

        ubicaciones.get(3).addExit("O", 1);

        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);

        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);

        for (int k : ubicaciones.keySet()) {
            ubicaciones.get(k).addExit("Q", 0);
        }
    }

    public static void main(String[] args) {
        Map<Integer, Ubicacion> ubicaciones = new Main().ubicaciones;

        Scanner sc = new Scanner(System.in);
        boolean tiempoEjecucion = true;
        int idPosAct = 1;
        int idPosAnt = 0;
        String usu;

        while (tiempoEjecucion) {
            if (idPosAnt == idPosAct)
                System.out.println("Has introducido una opción no valida.");
            System.out.println(ubicaciones.get(idPosAct).getDescripcion());

            System.out.print("Tus salidas válidas son: ");
            for (String dir : ubicaciones.get(idPosAct).getExits().keySet()) {
                if(!dir.equals("Q")) System.out.print(dir + ", ");
            }
            System.out.print("Q. \n");

            System.out.print("A donde vas: ");
            usu = sc.nextLine();
            usu = usu.toUpperCase();

            idPosAnt = idPosAct;
            for (String dir : ubicaciones.get(idPosAct).getExits().keySet()) {
                if(usu.equals(dir)){
                    idPosAct = ubicaciones.get(idPosAct).getExits().get(usu);
                }
            }

            System.out.print("\n");
            if (idPosAct == 0) {
                System.out.println(ubicaciones.get(idPosAct).getDescripcion());
                tiempoEjecucion = false;
            }
        }
    }
}

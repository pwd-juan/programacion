package ac4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    private static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        // i.) Crea un objeto CuerpoCeleste de tipo Planeta con Mercurio y periodo orbital 88.
        // Añade ese objeto al sistemaSolar y mételo también dentro del conjunto de
        // planetas.
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88);
        sistemaSolar.put("Mercurio", mercurio);
        planetas.add(mercurio);

        // ii.) Haz lo mismo para el planeta Venus-225,
        CuerpoCeleste venus = new Planeta("Venus", 225);
        sistemaSolar.put("Venus", venus);
        planetas.add(venus);

        // La Tierra-365,
        CuerpoCeleste LaTierra = new Planeta("Tierra", 365);
        sistemaSolar.put("Tierra", LaTierra);
        planetas.add(LaTierra);

        // Marte-687,
        CuerpoCeleste marte = new Planeta("Marte", 687);
        sistemaSolar.put("Marte", marte);
        planetas.add(marte);

        // Jupiter-4332,
        CuerpoCeleste jupiter = new Planeta("Jupiter", 4332);
        sistemaSolar.put("Jupiter", jupiter);
        planetas.add(jupiter);

        // Saturno-10759,
        CuerpoCeleste saturno = new Planeta("Saturno", 10759);
        sistemaSolar.put("Saturno", saturno);
        planetas.add(saturno);

        // Urano-30660,
        CuerpoCeleste urano = new Planeta("Urano", 30660);
        sistemaSolar.put("Urano", urano);
        planetas.add(urano);

        // Neptuno-165,
        CuerpoCeleste neptuno = new Planeta("Neptuno", 165);
        sistemaSolar.put("Neptuno", neptuno);
        planetas.add(neptuno);

        // Pluton-248.
        CuerpoCeleste pluton = new Planeta("Pluton", 248);
        sistemaSolar.put("Pluton", pluton);
        planetas.add(pluton);


        // iii.) Crea un objeto CuerpoCeleste de tipo Luna y periodo orbital 27, agrégalo al
        // sistemaSolar y añade al objeto LaTierra que creamos en el apartado anterior
        // este satélite.
        CuerpoCeleste Luna = new Luna("Luna", 27);
        sistemaSolar.put("Luna", Luna);
        LaTierra.addSatelite(Luna);

        // iv.) Crea otras dos lunas más (Deimos-1,3 y Phobos-0,3) añádelas al sistema solar y
        // agrégalas también en el planeta Marte como satélites.
        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put("Deimos", deimos);
        sistemaSolar.put("Phobos", phobos);
        marte.addSatelite(deimos);
        marte.addSatelite(phobos);

        // v.) Crea otras cuatro lunas más (Io-1,8 Europa-3,5, Ganymede-7,1 Callisto-16.7)
        // añádelas al sistema solar y agrégalas también en el planeta Júpiter como
        // satélites.
        CuerpoCeleste lo = new Luna("lo", 1.8);
        CuerpoCeleste europa = new Luna("Europa", 3.5);
        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        CuerpoCeleste callisto = new Luna("Callisto", 16.7);
        sistemaSolar.put("lo", lo);
        sistemaSolar.put("Europa", europa);
        sistemaSolar.put("Ganymede", ganymede);
        sistemaSolar.put("Callisto", callisto);
        jupiter.addSatelite(lo);
        jupiter.addSatelite(europa);
        jupiter.addSatelite(ganymede);
        jupiter.addSatelite(callisto);

        // vi.) Con un for-each imprime el nombre de todos los planetas que hemos
        // almacenado en el conjunto (Set).
        for (CuerpoCeleste x : sistemaSolar.values()){
            if (x.getTipoCuerpo() == CuerpoCeleste.TipoCuerpoCeleste.PLANETA)
                System.out.println(x.getNombre());
        }

        System.out.println("---");

        // vii.) Obtén del mapa del sistema solar el planeta Marte e imprime todas sus lunas.
        for (CuerpoCeleste x : sistemaSolar.get("Marte").getSatelites()){
            if (x.getTipoCuerpo() == CuerpoCeleste.TipoCuerpoCeleste.LUNA)
                System.out.println(x.getNombre());
        }

        System.out.println("---");

        // viii.) Vamos a obtener la unión de todas las lunas, para eso nos creamos un
        // Set<CuerpoCeleste> lunas de tipo HashSet. Y con un for-each recorremos todos
        // los planetas y hacemos la unión de los satélites para cada uno de los planetas.
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste x : planetas){
            lunas.addAll(x.getSatelites());
        }

        // ix.) Imprime el set de lunas del apartado anterior, debería haber 7 lunas.
        System.out.println("En total hay: " + lunas.size());
        for (CuerpoCeleste luna : lunas){
            System.out.println(luna);
        }

        System.out.println("---");

        // x.) Crea un planeta Plutón-884. Imprime de nuevo los planetas utilizando el método
        // sobreescrito toString. ¿Se ha agregado este planeta al conjunto? ¿Por qué?

        // Sí se ha agregado al set. Porque cuando va a meter el segundo pluton cálcula su
        // hash en base al hashCode, y al tener un número arbitrarío siempre es diferente.

        CuerpoCeleste pluton884 = new Planeta("Pluton", 884);
        sistemaSolar.put("Pluton-884", pluton884);
        planetas.add(pluton884);

        System.out.println("Map SistemaSolar: ");
        for (CuerpoCeleste x : sistemaSolar.values()) {
            System.out.println(x);
        }

        System.out.println("Set Planetas: ");
        for (CuerpoCeleste x : planetas){
            System.out.println(x);
        }

        System.out.println("---");

        // xi.) ¿Y si lo creamos como un planeta enano en vez de un planeta?
        sistemaSolar.remove("Pluton-884");
        pluton884 = new PlanetaEnano("Pluton", 884);
        sistemaSolar.put("Pluton-884", pluton884);
        planetas.add(pluton884);

        System.out.println("Map SistemaSolar: ");
        for (CuerpoCeleste x : sistemaSolar.values()) {
            System.out.println(x);
        }

        System.out.println("Set Planetas: ");
        for (CuerpoCeleste x : planetas){
            System.out.println(x);
        }

        System.out.println("---");

        // xii.) Utiliza la diferencia y la intersección de Set utilizando el código.
        // Añade lo que necesites de código y explica también qué tenemos en los
        // conjuntos y cuál es el resultado esperado al aplicar las operaciones.
        Set<CuerpoCeleste> planetas2 = new HashSet<>(planetas);
        planetas2.remove(mercurio);
        planetas2.remove(venus);

        System.out.println(planetas);
        System.out.println(planetas2);

        Set<CuerpoCeleste> intersecion = new HashSet<>(planetas);
        intersecion.retainAll(planetas2);
        System.out.println(intersecion);

        Set<CuerpoCeleste> diferencia = new HashSet<>(planetas);
        diferencia.retainAll(planetas2);
        System.out.println(diferencia);
    }
}

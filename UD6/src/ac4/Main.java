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
        CuerpoCeleste tierra = new Planeta("Tierra", 365);
        sistemaSolar.put("Tierra", tierra);
        planetas.add(tierra);

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

        // vii.) Obtén del mapa del sistema solar el planeta Marte e imprime todas sus lunas.
        sistemaSolar.get("Marte").getSatelites()
    }
}

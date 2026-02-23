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
        
    }
}

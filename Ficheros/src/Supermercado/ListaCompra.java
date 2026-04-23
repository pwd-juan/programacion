package Supermercado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ListaCompra {
    private final Map<String, Double> productos;
    private final Set<Producto> lista;

    public ListaCompra() {
        this.lista = new HashSet<>();
        this.productos = genProductos();
    }

    public boolean existeProducto(String producto) {
        return productos.containsKey(producto);
    }

    public boolean anadirProductoLista(String producto, int cantidad) {
        boolean posAnadir = false;
        Producto p = new Producto(producto, cantidad);

        if (existeProducto(producto) && !lista.contains(p)) {
            posAnadir = lista.add(p);
        } else if (existeProducto(producto) && lista.contains(p)) {
            Iterator<Producto> i = lista.iterator();
            Producto actual;

            while (i.hasNext()) {
                actual = i.next();
                if (actual.equals(p)) {
                    actual.incrementarCantidad(p.getCantidad());
                    posAnadir = true;
                }
            }
        }
        return posAnadir;
    }

    public String generarTicket(int d) {
        StringBuilder ticket = generarTicketCabezal();
        String producto;
        double total = 0;
        double precio;
        double subTotal;
        int cantidad;

        for (Producto p : lista) {
            producto = p.getNombre();
            precio = productos.get(producto);
            cantidad = p.getCantidad();
            subTotal = precio * cantidad;
            total += subTotal;

            ticket.append(String.format(
                    "%-10s %-8.2f %-10d %-10.2f %n",
                    producto,
                    precio,
                    cantidad,
                    subTotal
            ));
        }

        if (d > 0) {
            ticket.append("--------------------------------------------------" + "\n");
            ticket.append(String.format(
                    "%-30s %-10.2f %n",
                    "Descuento",
                    total*d/100
            ));
        }

        ticket.append(generarTicketFinal(total - (total*d/100)));

        return ticket.toString();
    }

    public String toStringProductos() {
        StringBuilder s = new StringBuilder();
        for (String k : productos.keySet()) {
            s.append(k);
            s.append("\n");
        }

        return s.toString();
    }

    private Map<String, Double> genProductos() {
        Map<String, Double> productos = new HashMap<>();

        try {
            Scanner file = new Scanner(new File("src/Supermercado/productos"));
            String[] pr;

            while (file.hasNextLine()) {
                pr = file.nextLine().split(";");

                if (pr.length != 2) continue;

                if (pr[1].lastIndexOf(",") == pr[1].indexOf(",")) {
                    pr[1] = pr[1].replace(",", ".");
                }

                try {
                    productos.put(pr[0].trim(), Double.parseDouble(pr[1]));
                } catch (NumberFormatException e) {
                    System.err.println("Error en los precios.");
                    System.err.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el fichero con los productos.");
        }

        return productos;
    }

    private StringBuilder generarTicketCabezal() {
        // https://codegym.cc/groups/posts/string-format

        StringBuilder t = new StringBuilder();
        t.append(String.format(
                "%-10s %-8s %-10s %-10s %n",
                "Producto",
                "Precio",
                "Cantidad",
                "Subtotal"
        ));

        t.append("--------------------------------------------------" + "\n");

        return t;
    }

    private StringBuilder generarTicketFinal(double total) {
        StringBuilder t = new StringBuilder();
        t.append("--------------------------------------------------" + "\n");

        t.append(String.format(
                "%-30s %-10.2f %n",
                "Total",
                total
        ));

        return t;
    }
}

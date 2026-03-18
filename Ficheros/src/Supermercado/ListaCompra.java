package Supermercado;

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
        productos.put("avena", 2.21);
        productos.put("garbanzos", 2.39);
        productos.put("tomate", 1.59);
        productos.put("jengibre", 3.13);
        productos.put("quinoa", 4.50);
        productos.put("guisantes", 1.60);
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

import java.util.ArrayList;

class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;

    public Producto(String nombre, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= cantidadStock) {
            cantidadStock -= cantidad;
        } else {
            System.out.println("Error: Stock insuficiente para la venta.");
        }
    }

    public double calcularValorVenta(int cantidad) {
        return precio * cantidad;
    }
}

class TiendaVirtual {
    private ArrayList<Producto> inventario;
    private double totalVentas;

    public TiendaVirtual() {
        this.inventario = new ArrayList<>();
        this.totalVentas = 0.0;
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public void mostrarInventario() {
        System.out.println("Inventario Actual:");
        for (Producto producto : inventario) {
            System.out.println("Nombre: " + producto.getNombre() +
                    ", Precio: Q" + producto.getPrecio() +
                    ", Stock: " + producto.getCantidadStock());
        }
    }

    public void realizarVenta(String nombreProducto, int cantidad) {
        for (Producto producto : inventario) {
            if (producto.getNombre().equals(nombreProducto)) {
                double valorVenta = producto.calcularValorVenta(cantidad);
                System.out.println("Venta realizada: " + cantidad + " unidades de " + producto.getNombre() +
                        " por Q" + valorVenta);
                producto.reducirStock(cantidad);
                totalVentas += valorVenta;
                return;
            }
        }
        System.out.println("Error: Producto no encontrado en el inventario.");
    }

    public double getTotalVentas() {
        return totalVentas;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear productos
        Producto producto1 = new Producto("Microondas", 20.0, 50);
        Producto producto2 = new Producto("Refrigerador", 60.0, 30);

        // Crear tienda virtual
        TiendaVirtual tienda = new TiendaVirtual();

        // Agregar productos al inventario
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);

        // Mostrar inventario
        tienda.mostrarInventario();

        // Realizar ventas
        tienda.realizarVenta("Microondas", 3);
        tienda.realizarVenta("Refrigerador", 2);

        // Mostrar inventario actualizado y total de ventas
        tienda.mostrarInventario();
        System.out.println("Total de Ventas: Q" + tienda.getTotalVentas());
    }
}

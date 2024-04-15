package models;

public class Comprador {
    private CarritoCompra carritoCompra;

    public Comprador(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }

    public void agregarProductoCarrito(Producto producto) {
        carritoCompra.agregarProducto(producto);
    }

    public void mostrarEstadoCarrito() {
        System.out.println("Estado del carrito de compra:");
        for (Producto producto : carritoCompra.getProductos()) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    public double obtenerTotalPagar() {
        return carritoCompra.calcularTotal();
    }

    public String obtenerReferenciaPago() {
        return carritoCompra.getReferenciaPago();
    }
}

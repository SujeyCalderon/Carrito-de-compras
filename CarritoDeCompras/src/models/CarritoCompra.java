package models;

import java.util.ArrayList;

public class CarritoCompra {
    private ArrayList<Producto> productos;
    private boolean validado;
    private String referenciaPago;

    public CarritoCompra() {
        this.productos = new ArrayList<>();
        this.validado = false;
        this.referenciaPago = null;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void validar() {
        this.validado = true;
        generarReferenciaPago();
    }

    private void generarReferenciaPago() {
        this.referenciaPago = "calmart333";
    }

    public boolean isValidado() {
        return validado;
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }
}

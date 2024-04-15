package models;

public class Administrador {
    private String usua = "Sujey";
    private String contrase = "caldemar123";

    public void validarCarritoCompra(CarritoCompra carrito) {
        carrito.validar();
    }

    public String getUsua() {
        return usua;
    }

    public void setUsua(String usua) {
        this.usua = usua;
    }

    public String getContrase() {
        return contrase;
    }

    public void setContrase(String contrase) {
        this.contrase = contrase;
    }

    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        return nombreUsuario.equals("Sujey") && contraseña.equals("caldemar123");
    }
}











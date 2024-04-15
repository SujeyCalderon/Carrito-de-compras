import java.util.Scanner;
import models.Administrador;
import models.CarritoCompra;
import models.Comprador;
import models.Inventario;
import models.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        boolean salir = false;
        do {
            System.out.println("¿Qué tipo de usuario es?");
            System.out.println("1. Administrador");
            System.out.println("2. Comprador");
            System.out.println("3. Salir del programa");
            System.out.println("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    boolean credencialesCorrectas = false;

                    do {
                        System.out.println("Ingrese nombre de usuario: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese contraseña: ");
                        String contraseña = scanner.nextLine();

                        Administrador admin = new Administrador();
                        if (admin.validarUsuario(nombre, contraseña)) {
                            credencialesCorrectas = true;
                            System.out.println("Inicio de sesión como administrador exitoso.");

                            System.out.println("Ingresa el nombre del producto que deseas añadir: ");
                            String nombreProducto = scanner.nextLine();
                            System.out.println("Ingresa el precio del producto que deseas añadir: ");
                            double precio = scanner.nextDouble();
                            scanner.nextLine();
                            inventario.agregarProducto(new Producto(nombreProducto, precio));
                            System.out.println("Producto agregado al inventario correctamente.");

                            break;
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
                        }
                    } while (!credencialesCorrectas);

                    if (!credencialesCorrectas) {
                        System.out.println("Número máximo de intentos alcanzado.");
                    }
                    break;
                case 2:
                    if (inventario.getProductos().isEmpty()) {
                        System.out.println("No hay productos disponibles en el inventario. La compra no se puede completar.");
                        break;
                    }

                    System.out.println("Productos disponibles:");
                    for (Producto producto : inventario.getProductos()) {
                        System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
                    }

                    CarritoCompra carritoCompra = new CarritoCompra();
                    Comprador comprador = new Comprador(carritoCompra);

                    String respuesta;
                    do {
                        System.out.println("\n¿Desea agregar un producto al carrito? (si/no)");
                        respuesta = scanner.nextLine();

                        if (respuesta.equalsIgnoreCase("si")) {
                            System.out.println("Ingrese el producto que desea agregar al carrito:");
                            String nombreProducto = scanner.nextLine();
                            Producto productoElegido = inventario.buscarProducto(nombreProducto);
                            if (productoElegido != null) {
                                comprador.agregarProductoCarrito(productoElegido);
                                System.out.println("Producto agregado al carrito:" + productoElegido.getNombre());
                            } else {
                                System.out.println("No contamos con ese producto");
                            }
                        }
                    } while (!respuesta.equalsIgnoreCase("no"));

                    comprador.mostrarEstadoCarrito();
                    System.out.println("Total a pagar: $" + comprador.obtenerTotalPagar());

                    Administrador administrador = new Administrador();
                    administrador.validarCarritoCompra(carritoCompra);

                    System.out.println("Conozca su referencia de pago para completar su compra:");
                    System.out.println(carritoCompra.getReferenciaPago());

                    break;

                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);

        scanner.close();
    }
}

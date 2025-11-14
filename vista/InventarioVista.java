package vista;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.Producto;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Inventario ---");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Buscar un producto por ID"); 
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar un producto por ID");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");

        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    
    public Producto pedirDatosUsuario() {
        System.out.println("\n--- Agregar Nuevo Producto ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("ID (Identificador Único): ");
        String id = scanner.nextLine();

        
        int cantidad = -1;
        while (cantidad < 0) {
            try {
                System.out.print("Cantidad (entero): ");
                cantidad = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Error: La cantidad debe ser un número entero.");
                scanner.nextLine();
            }
        }

        double precio = -1.0;
        while (precio < 0.0) {
             try {
                System.out.print("Precio Unitario (decimal): ");
                precio = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: El precio debe ser un número decimal.");
                scanner.nextLine();
            }
        }
        
        return new Producto(nombre, id, cantidad, precio); // ¡Pasando ID!
    }
    
    /**
     * Solicita al usuario que ingrese un ID.
     * @return 
     */
    public String pedirId() { 
        System.out.print("\nIngrese el ID del producto a buscar/eliminar: "); // ¡Cambiado a ID!
        return scanner.nextLine();
    }
    
    /**
     * Muestra la información de un producto.
     */
    public void mostrarProducto(Producto producto) {
        if (producto == null) {
            mostrarMensaje("Producto no encontrado.");
        } else {
            System.out.println("\n--- Producto Encontrado ---");
            System.out.println(producto.toString());
        }
    }

    
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            mostrarMensaje("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de Todos los Productos ---");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}
package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;

public class ControladorInventario {
    
    private BaseDeDatos modelo;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos modelo, InventarioVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * Contiene el bucle principal de la aplicación.
     */
    public void iniciar() {
        boolean salir = false;
        
        vista.mostrarMensaje("¡Bienvenido al Sistema de Gestión de Inventario!");

        while (!salir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Agregar
                    Producto nuevoProducto = vista.pedirDatosUsuario();
                    if (modelo.agregarProducto(nuevoProducto)) {
                        vista.mostrarMensaje("Producto agregado correctamente.");
                    } else {
                        vista.mostrarMensaje("Error al agregar el producto.");
                    }
                    break;
                case 2: // Buscar
                    String idBuscar = vista.pedirId(); // ¡Cambiado a pedirId!
                    Producto productoEncontrado = modelo.buscarProductoId(idBuscar); 
                    vista.mostrarProducto(productoEncontrado); 
                    break;
                case 3: // Mostrar todos
                    vista.mostrarProductos(modelo.buscarTodos());
                    break;
                case 4: // Eliminar
                    String idEliminar = vista.pedirId(); // ¡Cambiado a pedirId!
                    if (modelo.eliminarProducto(idEliminar)) { // ¡Cambiado a eliminarProducto(id)!
                        vista.mostrarMensaje("Producto con ID " + idEliminar + " eliminado correctamente."); 
                    } else {
                        vista.mostrarMensaje("Error: Producto con ID " + idEliminar + " no encontrado o no se pudo eliminar."); // ¡Cambiado a ID!
                    }
                    break;
                case 5: // Salir
                    salir = true;
                    vista.mostrarMensaje("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
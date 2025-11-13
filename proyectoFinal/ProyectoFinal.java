package proyectoFinal;
import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

// Clase principal que contiene el método main
public class ProyectoFinal {
    
    public static void main(String[] args) {
        // 1. Crear la instancia del Modelo
        BaseDeDatos modelo = new BaseDeDatos();

        // 2. Crear la instancia de la Vista
        InventarioVista vista = new InventarioVista();

        // 3. Crear la instancia del Controlador, inyectándole el Modelo y la Vista
        ControladorInventario controlador = new ControladorInventario(modelo, vista);

        // 4. Llamar al método iniciar() del controlador
        controlador.iniciar();
    }
}
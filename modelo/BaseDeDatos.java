package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
        // Opcional: Agregar algunos datos de prueba (usando ID)
        this.productos.add(new Producto("Laptop Pro", "P001", 10, 1200.50));
        this.productos.add(new Producto("Mouse Inalámbrico", "M002", 50, 25.99));
    }

    
    
    /**
    
     * @param producto 
     * @return true si se a
    public boolean agregarProducto(Producto producto) {
        if (producto == null) return false;
        // Se asume que el ID no se repite para este ejercicio simple.
        return productos.add(producto);
    }

    /**
     * Busca un Producto por su ID (ignorando mayúsculas/minúsculas).
     * @param id El ID a buscar.
     * @return El objeto Producto si lo encuentra, o 'null' si no.
     */
    public Producto buscarProductoId(String id) { // ¡Cambiado a buscarProductoId!
        if (id == null || id.isEmpty()) return null;
        
        
        return productos.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id)) 
                .findFirst()
                .orElse(null); 
    }

    /**
     
     * @return Una lista de Producto.
     */
    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos); 
    }

    /**
     * Busca un producto por ID y lo elimina de la lista.
     * @param id El ID del producto a eliminar.
     * @return 'true' si lo encuentra y elimina, 'false' si no lo encuentra.
     */
    public boolean eliminarProducto(String id) { // ¡Cambiado a usar ID!
        Producto productoAEliminar = buscarProductoId(id); // ¡Usando buscarProductoId!
        if (productoAEliminar != null) {
            return productos.remove(productoAEliminar);
        }
        return false;
    }
}
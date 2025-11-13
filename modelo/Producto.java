package modelo;

public class Producto {
    // Atributos privados
    private String nombre;
    private String id; // ¡Cambiado de SKU a ID!
    private int cantidad;
    private double precio;

    // Constructor para inicializar todos los atributos
    public Producto(String nombre, String id, int cantidad, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() { // ¡Cambiado de getSku a getId!
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) { // ¡Cambiado de setSku a setId!
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Sobrescribir toString() para formatear la salida
    @Override
    public String toString() {
        return String.format("ID: %-10s | Nombre: %-20s | Cantidad: %-5d | Precio Unitario: $%.2f", 
                             id, nombre, cantidad, precio); // ¡Usando ID en la salida!
    }
}
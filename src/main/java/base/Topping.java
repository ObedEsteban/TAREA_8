package base;

public class Topping {
    private String nombre;
    private double precio;

    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Topping{" + "nombre='" + nombre + '\'' + ", precio=" + precio + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

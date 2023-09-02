package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import base.TamañoPizza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private double precioBase;
    private List<Topping> toppings = new ArrayList<>();
    private TamañoPizza tamaño;

    public Pizza(String name, double precioBase, TamañoPizza tamaño, Topping... toppings) {
        this.name = name;
        this.precioBase = precioBase;
        this.tamaño = tamaño;
        Collections.addAll(this.toppings, toppings);
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }

    public TamañoPizza getTamaño() {
        return tamaño;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioTotal() {
        double factorPrecio = 1.0;

        switch (tamaño) {
            case PEQUEÑA:
                factorPrecio = 1.0; // Precio base (sin cambios)
                break;
            case MEDIANA:
                factorPrecio = 1.2; // 20% más
                break;
            case GRANDE:
                factorPrecio = 1.35; // 35% más
                break;
        }


        double precioToppings = 0.0;
        for (Topping topping : toppings) {
            precioToppings += topping.getPrecio();
        }

        return (precioBase + precioToppings) * factorPrecio;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", precioBase=" + precioBase + ", toppings=" + toppings + '}';
    }

    public void prepare() {
        System.out.println("Preparando..... " + name);
        System.out.println("Añadiendo topping:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La pizza está lista!");
    }
}


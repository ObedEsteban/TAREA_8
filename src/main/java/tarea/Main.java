package tarea;

import java.util.Scanner;
import base.TamañoPizza;
import base.Topping;
import especialidades.PizzaItaliana;
import base.Pizza;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Topping pepperoni = new Topping("Pepperoni", 2.0);
        Topping champiñones = new Topping("Champiñones", 1.5);
        Topping aceitunas = new Topping("Aceitunas", 1.0);


        System.out.println("Elija la clase de pizza (BASE o ITALIANA): ");
        String claseInput = scanner.nextLine();


        System.out.println("Elija el tamaño de la pizza (PEQUEÑA, MEDIANA o GRANDE): ");
        String tamañoInput = scanner.nextLine();
        TamañoPizza tamaño = TamañoPizza.valueOf(tamañoInput.toUpperCase());

        Pizza pizza;


        if (claseInput.equalsIgnoreCase("ITALIANA")) {
            System.out.println("Elija la salsa de la pizza (Tomate,BBQ, etc.): ");
            String salsaInput = scanner.nextLine();


            pizza = new PizzaItaliana("Pizza Italiana", 10.0, salsaInput, tamaño, pepperoni, champiñones,
                    new Topping("Queso Extra", 1.5),
                    new Topping("Pimientos Rojos", 1.0),
                    new Topping("Bacon", 2.5));
        } else {

            pizza = new Pizza("Pizza Base", 8.0, tamaño,
                    new Topping("Queso", 1.0),
                    new Topping("Tomate", 0.5),
                    new Topping("Cebolla", 0.8));
        }


        double precioTotal = pizza.getPrecioTotal();


        System.out.println("Nombre de la pizza: " + pizza.getName());
        System.out.println("Tamaño de la pizza: " + pizza.getTamaño());

        if (pizza instanceof PizzaItaliana) {
            System.out.println("Salsa de la pizza: " + ((PizzaItaliana)pizza).getSalsa());
        }

        System.out.println("Toppings de la pizza: ");
        for (Topping topping : pizza.getToppings()) {
            System.out.println("- " + topping.getNombre() + " - Precio: " + topping.getPrecio());
        }
        System.out.println("Precio base de la pizza: " + pizza.getPrecioBase());
        System.out.println("Precio total de la pizza: " + precioTotal);


        pizza.prepare();


        scanner.close();
    }
}


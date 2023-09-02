package especialidades;

import base.Pizza;
import base.Topping;
import base.TamañoPizza;
public class PizzaItaliana extends Pizza {
    private String salsa;

    public PizzaItaliana(String name, double price, String salsa, TamañoPizza tamaño, Topping... toppings) {
        super(name, price, tamaño, toppings);
        this.salsa = salsa;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}

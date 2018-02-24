/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Tomek
 */
public class DishSet {
    private SingleDish[] dishesInSet;
    private int discount;

    /**
     * @return the dishesInSet
     */
    public SingleDish[] getDishesInSet() {
        return dishesInSet;
    }

    /**
     * @param dishesInSet the dishesInSet to set
     */
    public void setDishesInSet(SingleDish[] dishesInSet) {
        this.dishesInSet = dishesInSet;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

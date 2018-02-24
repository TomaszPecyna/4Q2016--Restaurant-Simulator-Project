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
public class MealOrder {
    private int deliveryPrice;
    private String preparationTime;
    private int totalPrice;
    private Meal[] Dishes;
    private PointOnMap adress;
    private Client whoOrderedMe;
    public MealOrder(PointOnMap adress, Client client)
    {
        whoOrderedMe = client;
        this.adress = adress;
    }
    
    public void lookForSets(){}
    
    public void suggestDishToFillSet(){}
    
    /**
     * @return the deliveryPrice
     */
    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * @param deliveryPrice the deliveryPrice to set
     */
    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * @return the preparationTime
     */
    public String getPreparationTime() {
        return preparationTime;
    }

    /**
     * @param preparationTime the preparationTime to set
     */
    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the Dishes
     */
    public Meal[] getDishes() {
        return Dishes;
    }

    /**
     * @param Dishes the Dishes to set
     */
    public void setDishes(Meal[] Dishes) {
        this.Dishes = Dishes;
    }

    /**
     * @return the adress
     */
    public PointOnMap getAdress()
    {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(PointOnMap adress)
    {
        this.adress = adress;
    }

    /**
     * @return the whoOrderedMe
     */
    public Client getWhoOrderedMe()
    {
        return whoOrderedMe;
    }
    
}

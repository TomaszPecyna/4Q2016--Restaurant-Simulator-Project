/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.LinkedList;

/**
 *
 * @author Tomek
 */
public class RegularClient extends IndividualClient {
    private String loyaltyPoints;
    private String discount;
    private LinkedList<MealOrder> orderList;

    public RegularClient(LinkedList<MealOrder> orderList, LinkedList<PointOnMap> possibleAdresses)
    {
        super(orderList, possibleAdresses);
    }
    
    /**
     * @return the loyaltyPoints
     */
    public String getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @param loyaltyPoints the loyaltyPoints to set
     */
    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }
}

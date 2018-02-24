/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import GUI2.GuiMain;


/**
 *
 * @author Tomek
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Restaurant restaurant = new Restaurant();
        GuiMain gui = new GuiMain(restaurant.getMap(), restaurant.getDeliveryMans(),
                restaurant.getClients(), restaurant.getOrderList(), 
                restaurant.getPossibleAdresses());
        // TODO code application logic here
    }
    
}

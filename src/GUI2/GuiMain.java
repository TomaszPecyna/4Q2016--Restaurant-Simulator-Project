/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import restaurant.Client;
import restaurant.DeliveryMan;
import restaurant.Map;
import restaurant.MealOrder;
import restaurant.PointOnMap;

/**
 *
 * @author Tomek
 */
public class GuiMain
{ 
    public GuiMain(Map map, ArrayList<DeliveryMan> deliveryMans, 
            ArrayList<Client> clients, LinkedList<MealOrder> orderList, 
            LinkedList<PointOnMap> possibleAdresses)
    {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new GuiMainFrame(map, deliveryMans, clients, orderList, 
            possibleAdresses);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("Polski niesmak roku");
        });   
    }
}

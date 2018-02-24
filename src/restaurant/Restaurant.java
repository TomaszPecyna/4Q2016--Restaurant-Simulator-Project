/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.*;
/**
 *
 * @author Tomek
 */
public class Restaurant
{
    private LinkedList<MealOrder> orderList;
    PointOnMap restaurant;
    private Map map;
    private ArrayList<DeliveryMan> deliveryMans;
    private ArrayList<Client> clients;
    private LinkedList<PointOnMap> possibleAdresses;
    public Restaurant()
    {
        deliveryMans = new ArrayList<>();
        clients = new ArrayList<>();
        map = new Map(20, 21);
        restaurant = map.getRestaurant();
        orderList = new LinkedList<>();
        possibleAdresses = map.getDeliveryAdresses();
    }

    /**
     * @return the map
     */
    public Map getMap()
    {
        return map;
    }

    /**
     * @return the deliveryMans
     */
    public ArrayList<DeliveryMan> getDeliveryMans()
    {
        return deliveryMans;
    }

    /**
     * @return the clients
     */
    public ArrayList<Client> getClients()
    {
        return clients;
    }

    /**
     * @return the orderList
     */
    public LinkedList<MealOrder> getOrderList()
    {
        return orderList;
    }

    /**
     * @return the possibleAdresses
     */
    public LinkedList<PointOnMap> getPossibleAdresses()
    {
        return possibleAdresses;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Tomek
 */
public class Client implements Runnable
{
    private String phone;
    private String orderTime;
    private String email;
    private String ID;
    
    private final LinkedList<MealOrder> orderList;
    private final ArrayList<MealOrder> myOrders;
    private PointOnMap adress;
    private String funnyAdress;
    
    private final Thread thread;
    private volatile boolean shouldStop = false;
    
    public Client(LinkedList<MealOrder> orderList, LinkedList<PointOnMap> possibleAdresses)
    {
        this.orderList = orderList;
        myOrders = new ArrayList<MealOrder>();
        Random rnd = new Random();
        synchronized(possibleAdresses)
        {
            int n = rnd.nextInt(possibleAdresses.size());
            adress = possibleAdresses.get(n);
            possibleAdresses.remove(n);
        }
        
        thread = new Thread (this);
    }
    
    public int getNumberOfOrders()
    {
        return myOrders.size();
    }
    
    public boolean hasOrders()
    {
        return !myOrders.isEmpty();
    }
    
    public void start()
    {
        thread.start();
    }
    
    public void stop() 
    {   
        shouldStop = true;
    }
    
    public void pickUpOrder(MealOrder order)
    {
        myOrders.remove(order);
    }
    
    public void run()
    {
        Random random = new Random();
        int sleepTime = 0;
        while(!shouldStop)
        {
            MealOrder order = new MealOrder(getAdress(), this);
            synchronized(orderList)
            {
                myOrders.add(order);
                orderList.push(order);
                orderList.notifyAll();
            }
            sleepTime = random.nextInt(120) + 10;
            try
            {
                TimeUnit.SECONDS.sleep(sleepTime);
            } 
            catch (InterruptedException exception)
            {
                System.out.println("Must I be interrupted at every turn?! "
                        + "Enough of this!");
            }
        }
        for (MealOrder myOrder : myOrders)
        {
            orderList.remove(myOrder);
        }
        myOrders.clear();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public void order(){
    
    }
    
    public void generateRandomOrder(){}

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
     * @return the funnyAdress
     */
    public String getFunnyAdress()
    {
        return funnyAdress;
    }

    /**
     * @param funnyAdress the funnyAdress to set
     */
    public void setFunnyAdress(String funnyAdress)
    {
        this.funnyAdress = funnyAdress;
    }


    /**
     * @param mealOrder the mealOrder to set
     */
    
}

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
public class DeliveryMan implements Runnable {
    private String name;
    private String surname;
    private String PESEL;
    private String workTime;
    private String[] drivingLicenceCategory;
    private Vehicle currentlyUsedVehicle;
    private String clientsIDsToDelivery[];
    
    private PointOnMap currentPosition;
    private Map myOwnMap;
    private LinkedList<MealOrder> orderList;
    private LinkedList<MealOrder> ordersToExecute;
    
    private final Thread thread;
    private volatile boolean shouldStop = false;
    private volatile boolean shouldReturn = false;
    
        // and we got to the point that things went out of control xd
        //#cutting_corners_to_meet_arbitrary_deadlines
    private PointOnMap PointersArentActuallySoBad; 
    private PointOnMap currentPositionTest;
    private PointOnMap currentPositionHomeComeback;
    
    public DeliveryMan(PointOnMap startingPosition, Map myOwnMap,
            LinkedList<MealOrder> orderList, int carSpeed, int fuelCapacity,
            int vehicle, int capacity, String registrationNumber)
    {
        ordersToExecute = new LinkedList<>();
        this.orderList = orderList;
        currentPosition = new PointOnMap(startingPosition);
        currentPositionTest = new PointOnMap(startingPosition);
        if(vehicle == 0)
        {
            currentlyUsedVehicle = new Car();
        }
        else
        {
            currentlyUsedVehicle = new Scooter();
        }
        currentlyUsedVehicle.setSpeed(carSpeed);
        currentlyUsedVehicle.setFuelCapacity(fuelCapacity);
        currentlyUsedVehicle.refuel();
        currentlyUsedVehicle.setRegistrationNumber(registrationNumber);
        currentlyUsedVehicle.setLoadCapacity(capacity);
        this.myOwnMap = myOwnMap;
        
        thread = new Thread(this);
        currentPosition = myOwnMap.getRestaurant().getNeighbourList().get(0);
        currentPositionTest = myOwnMap.getRestaurant().getNeighbourList().get(0);
        currentPositionHomeComeback = myOwnMap.getRestaurant().getNeighbourList().get(0);
        PointersArentActuallySoBad = currentPosition;
      
    }
    
    public DeliveryMan()
    {
        thread = new Thread(this);
    }
    
    public void start()
    {
        thread.start();
    }
    
    public void stop() 
    {   
        shouldStop = true;
    }
    
    public void returnMe() 
    {   
        shouldReturn = true;
    }
    
    @Override
    public void run()
    {
        while(!shouldStop)
        {
            shouldReturn = false;
            while(!shouldReturn)
            {
                synchronized(orderList)
                {
                    try
                    {
                        while(orderList.isEmpty())
                        {
                            orderList.wait();
                        }
                    }
                    catch (InterruptedException exception)  
                    {
                        System.out.println("Must I be interrupted at every turn?! "
                                + "Enough of this!");
                    }
                    PointersArentActuallySoBad = currentPositionTest;
                    setOrdersToExecute();
                    PointersArentActuallySoBad = currentPosition;
                }
                if(!ordersToExecute.isEmpty())
                {
                    LinkedList<MealOrder> executedOrders = new LinkedList<>();
                    for (MealOrder order : ordersToExecute)
                    {
                        if (!shouldStop && !shouldReturn)
                        {                        
                            drive(order.getAdress().getNeighbourList().get(0), order);
                            executedOrders.add(order);
                        }
                    }
                    drive(myOwnMap.getRestaurant().getNeighbourList().get(0), ordersToExecute.get(0));
                    ordersToExecute.removeAll(executedOrders);
                    currentPositionTest = new PointOnMap(currentPosition);
                    currentlyUsedVehicle.refuel();
                }
            }
            synchronized(orderList)
            {
                for (MealOrder order : ordersToExecute)
                {
                    orderList.push(order);
                }
            }
            ordersToExecute.clear();
        }
    }
    
    private PointOnMap whereToGoNext(PointOnMap destination)
    {
        synchronized(orderList)
        {
            int destinationX = destination.getWidth();
            int destinationY = destination.getHeight();
            int currentX = PointersArentActuallySoBad.getWidth();
            int currentY = PointersArentActuallySoBad.getHeight();
            int whereToGoNextX;
            int whereToGoNextY;

            PointOnMap vertical = new VerticalRoad(0, 0);

            if(currentX == destinationX)
            {
                if(destinationY < currentY)
                {
                    whereToGoNextY = currentY - 1;
                }
                else
                {
                    whereToGoNextY = currentY + 1;
                }
                whereToGoNextX = currentX;
            }
            else if (PointersArentActuallySoBad.getClass() == vertical.getClass())
            {
                if(myOwnMap.getHeight() - currentY < (myOwnMap.getHeight() % 6) )
                {
                    whereToGoNextY = currentY - 1;
                }
                else if (Math.abs(currentY - destinationY) < 6 
                        && currentY / 6 == destinationY / 6)
                {
                    if(currentY % 6 + destinationY % 6  
                            < 12 - (currentY % 6 + destinationY % 6))
                    {
                        whereToGoNextY = currentY - 1;
                    }
                    else
                    {
                        whereToGoNextY = currentY + 1;
                    }
                }
                else
                {
                    if(destinationY < currentY)
                    {
                        whereToGoNextY = currentY - 1;
                    }
                    else
                    {
                        whereToGoNextY = currentY + 1;
                    }
                }
                whereToGoNextX = currentX;
            }
            else 
            {
                if(currentX < destinationX)
                {
                    whereToGoNextX = currentX + 1;
                }
                else
                {
                    whereToGoNextX = currentX - 1;
                }
                whereToGoNextY = currentY;
            }
            return new PointOnMap(whereToGoNextY, whereToGoNextX);
        }
    }
    
    private int howManyStepsToGo(PointOnMap destination)
    {
        synchronized(orderList)
        {
            int i = 0;
            PointOnMap tmp;
            while (!PointersArentActuallySoBad.equals(destination))
            {      
                tmp = whereToGoNext(destination);
                //here we assign "pointers..." to some point on a map, so the object
                //it was assigned to remains unchanged
                PointersArentActuallySoBad = myOwnMap.getPointOnMap(tmp.getHeight(), tmp.getWidth());
                i++;
                tmp = PointersArentActuallySoBad;
            }
            return i;
        }
    }
    
    private synchronized void setOrdersToExecute()
    {
        synchronized(orderList)
        {
            int fuelCapacity = currentlyUsedVehicle.getFuelCapacity();
            int fuelNeededToComeback;
            int fuelNeededToGetThere;
            for (MealOrder order : orderList)
            {
                PointersArentActuallySoBad = currentPositionHomeComeback;
                fuelNeededToComeback = howManyStepsToGo(order.getAdress().getNeighbourList().get(0));
                PointersArentActuallySoBad = currentPositionTest;
                fuelNeededToGetThere = howManyStepsToGo(order.getAdress().getNeighbourList().get(0));
                if(fuelNeededToGetThere + fuelNeededToComeback < fuelCapacity)
                {
                    ordersToExecute.add(order);
                    fuelCapacity -= fuelNeededToGetThere;
                    currentPositionTest = PointersArentActuallySoBad;
                }
            }
            orderList.removeAll(ordersToExecute);
        }
    }
    
    private void makeMove(PointOnMap destination)
    {
        PointOnMap tmp, previous;
        Crossover crossover = new Crossover(0, 0);
        synchronized(PointersArentActuallySoBad)
        {
            if(PointersArentActuallySoBad.getClass() == crossover.getClass())
            {
                previous = PointersArentActuallySoBad;
                tmp = whereToGoNext(destination);
                tmp = myOwnMap.getPointOnMap(tmp.getHeight(), tmp.getWidth());
                currentPosition = myOwnMap.getPointOnMap(tmp.getHeight(), tmp.getWidth());
                previous.setOccupied(false);
                PointersArentActuallySoBad.notifyAll();
            }
            else
            {      
                tmp = whereToGoNext(destination);
                tmp = myOwnMap.getPointOnMap(tmp.getHeight(), tmp.getWidth());
                
                try
                {
                    while ((crossover.getClass() == tmp.getClass()) && tmp.isOccupied())
                    {                
                        orderList.wait();
                    }
                }
                catch (InterruptedException exception)  
                {
                    System.out.println("Must I be interrupted at every turn?! "
                            + "Enough of this!");
                }
                currentPosition = myOwnMap.getPointOnMap(tmp.getHeight(), tmp.getWidth());
            }
        }
    }
    /**
     * @return the name
     */
    
    private void drive(PointOnMap destination, MealOrder order)
    {
        try
        {
            while(getCurrentPosition() != destination)
            {
                makeMove(destination);
                //sleep 1000
                thread.sleep(5000/currentlyUsedVehicle.getSpeed());
                PointersArentActuallySoBad = currentPosition;
                currentlyUsedVehicle.setFuelLeft(currentlyUsedVehicle.getFuelLeft() - 1);
            }
            if(getCurrentPosition() == destination && !ordersToExecute.isEmpty())
            {
                order.getWhoOrderedMe().pickUpOrder(order);
            }
        } 
        catch (InterruptedException exception)  
        {
            System.out.println("Must I be interrupted at every turn?! "
                    + "Enough of this!");
        }
    }
    
    
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the PESEL
     */
    public String getPESEL() {
        return PESEL;
    }

    /**
     * @param PESEL the PESEL to set
     */
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    /**
     * @return the workTime
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * @param workTime the workTime to set
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * @return the drivingLicenceCategory
     */
    public String[] getDrivingLicenceCategory() {
        return drivingLicenceCategory;
    }

    /**
     * @param drivingLicenceCategory the drivingLicenceCategory to set
     */
    public void setDrivingLicenceCategory(String[] drivingLicenceCategory) {
        this.setDrivingLicenceCategory(drivingLicenceCategory);
    }

    /**
     * @return the currentlyUsedVehicle
     */
    public Vehicle getCurrentlyUsedVehicle() {
        return currentlyUsedVehicle;
    }

    /**
     * @param currentlyUsedVehicle the currentlyUsedVehicle to set
     */
    public void setCurrentlyUsedVehicle(Vehicle currentlyUsedVehicle) {
        this.currentlyUsedVehicle = currentlyUsedVehicle;
    }

    /**
     * @return the clientsIDsToDelivery
     */
    public String[] getClientsIDsToDelivery() {
        return clientsIDsToDelivery;
    }

    /**
     * @param clientsIDsToDelivery the clientsIDsToDelivery to set
     */
    public void setClientsIDsToDelivery(String[] clientsIDsToDelivery) {
        this.clientsIDsToDelivery = clientsIDsToDelivery;
    }

    /**
     * @return the currentPosition
     */
    public PointOnMap getCurrentPosition()
    {
        return currentPosition;
    }
    
}

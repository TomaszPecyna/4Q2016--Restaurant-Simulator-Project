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
public class Vehicle {
    private int loadCapacity;
    private int fuelCapacity;
    private String registrationNumber;
    private int speed;
    private int fuelLeft;
    
    public Vehicle()
    {
    
    }

    public void generateRandomValues(){}
    
    public void refuel()
    {
        fuelLeft = fuelCapacity;
    }
    
    /**
     * @return the loadCapacity
     */
    public int getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * @param loadCapacity the loadCapacity to set
     */
    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }


    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the fuelCapacity
     */
    public int getFuelCapacity()
    {
        return fuelCapacity;
    }

    /**
     * @param fuelCapacity the fuelCapacity to set
     */
    public void setFuelCapacity(int fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * @return the speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    /**
     * @return the fuelLeft
     */
    public int getFuelLeft()
    {
        return fuelLeft;
    }

    /**
     * @param fuelLeft the fuelLeft to set
     */
    public void setFuelLeft(int fuelLeft)
    {
        this.fuelLeft = fuelLeft;
    }
      
}

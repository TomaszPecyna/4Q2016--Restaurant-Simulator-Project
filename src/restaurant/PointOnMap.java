/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;

/**
 *
 * @author Tomek
 */
public class PointOnMap
{
    private int height;
    private int width;
    private ArrayList<PointOnMap> neighbourList = new ArrayList();
    private boolean occupied = false;
    
    public PointOnMap(int h, int w)
    {
        height = h;
        width = w;
    }
    
    public PointOnMap(PointOnMap other)
    {
        height = other.height;
        width = other.width;
    }
    
    public void setPoint(PointOnMap other)
    {
        height = other.height;
        width = other.width;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @return the width
     */
    public int getWidth()
    {
        return width;
    }
    
    
    @Override
    public boolean equals(Object otherObject)
    {
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        PointOnMap other = (PointOnMap) otherObject;
        return height == other.height && width == other.width;
    }
    
    public void connectSymmetric(PointOnMap other)
    {
        if (getNeighbourList().contains(other))return;
        
        getNeighbourList().add(other);
        other.getNeighbourList().add(this);
    }
    
    public void connect(PointOnMap other)
    {
        if (getNeighbourList().contains(other))return;
        
        getNeighbourList().add(other);
    }

    /**
     * @return the occupied
     */
    public synchronized boolean isOccupied()
    {
        return occupied;
    }   

    /**
     * @param occupied the occupied to set
     */
    public synchronized void setOccupied(boolean occupied)
    {
        this.occupied = occupied;
    }

    /**
     * @return the neighbourList
     */
    public ArrayList<PointOnMap> getNeighbourList()
    {
        return neighbourList;
    }
}

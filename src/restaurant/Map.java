/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author Tomek
 */
public class Map {
    private PointOnMap[][] map;
    private int height;
    private int width;
    private PointOnMap restaurant;
    private LinkedList<PointOnMap> deliveryAdresses;
    
    
    public Map(int h, int w)
    {
        height = h;
        width = w;
        deliveryAdresses = new LinkedList<>();
        
        map = new PointOnMap[height][width];
        generatePaths();
        
    }
    
    private void generatePaths()
    {
        
        for (int i = 0; i < getHeight(); i++)
        {
            for (int j = 0; j < getWidth(); j++)
            {
                map[i][j] = new PointOnMap(i, j);
            }
        }

        for (int i = 0; i < getHeight(); i++)
        {
            for (int j = 0; j < getWidth(); j++)
            {
                //crossovers
                if(i % 6 == 0 && j % 3 == 0)
                {
                    if(i == 0 && j == 0)
                    {
                        map[i][j] = new Crossover(i, j);
                    }
                    if(i + 1 < getHeight())
                    {
                        map[i + 1][j] = new VerticalRoad(i + 1, j);
                        map[i][j].connectSymmetric(map[i + 1][j]);
                    }
                    
                    if(j + 1 < getWidth())
                    {
                        map[i][j + 1] = new HorizontalRoad(i, j + 1);
                        map[i][j].connectSymmetric(map[i][j + 1]);
                    }
                }
                //horizontal roads
                else if((i % 6 == 0) && (j + 1 < getWidth()))
                {
                    if(((j + 1) % 3 == 0) && i == 0)
                    {
                        map[i][j + 1] = new Crossover(i, j + 1);
                    }
                    else if(j % 3 == 0 || (j - 1) % 3 == 0)
                    {
                        map[i][j + 1] = new HorizontalRoad(i, j + 1);
                    }
                    map[i][j].connectSymmetric(map[i][j + 1]);
                }
                //vertical roads
                else if((j % 3 == 0) && (i + 1 < getHeight()))
                {
                    if((i + 1) % 6 == 0)
                    {
                        map[i + 1][j] = new Crossover(i + 1, j);
                    }
                    else
                    {
                        map[i + 1][j] = new VerticalRoad(i + 1, j);
                    }
                    map[i][j].connectSymmetric(map[i + 1][j]);
                }
                
                //delivery points
                else if(((j - 1) % 3 == 0) && (i % 6 != 0))
                {
                    map[i][j] = new DeliveryPoint(i, j);
                    deliveryAdresses.add(map[i][j]);
                    map[i][j].connect(map[i][j-1]);
                }
                else if(((j + 1) % 3 == 0) && (j + 1 < getWidth()) && (i % 6 != 0))
                {
                    map[i][j] = new DeliveryPoint(i, j);
                    deliveryAdresses.add(map[i][j]);
                    map[i][j].connect(map[i][j + 1]);
                }
            }
        }
        
        //setting restaurant on a map
        restaurant = new PointOnMap(0, 0);
        
        int iRestaurant = getHeight()/2;
        int jRestaurant = getWidth()/2;
        if(iRestaurant % 6 == 0) 
        {
            iRestaurant++;
        }
        if(jRestaurant % 3 == 0) 
        {
            jRestaurant++;
        }
        restaurant = new PointOnMap(iRestaurant, jRestaurant);
        map[iRestaurant][jRestaurant] = getRestaurant();
        if((jRestaurant - 1) % 3 == 0)
        {
            map[iRestaurant][jRestaurant].connect(map[iRestaurant][jRestaurant - 1]);
        }
        else
        {
            map[iRestaurant][jRestaurant].connect(map[iRestaurant][jRestaurant + 1]);
        }
    
        Crossover c = new Crossover(0, 0);
        VerticalRoad v = new VerticalRoad(0, 0);
        HorizontalRoad h = new HorizontalRoad(0, 0);
        DeliveryPoint d = new DeliveryPoint(0, 0);
        
        for (int i = 0; i < getHeight(); i++)
        {
            for (int j = 0; j < getWidth(); j++)
            {
                if(map[i][j].equals(getRestaurant()) ) System.out.print("R");
                else if(map[i][j].getClass() == c.getClass()) System.out.print("+");
                else if(map[i][j].getClass() == v.getClass()) System.out.print("|");
                else if(map[i][j].getClass() == h.getClass()) System.out.print("-");
                else if(map[i][j].getClass() == d.getClass()) System.out.print("H");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
    } 
    
    public PointOnMap getPointOnMap(int height, int width)
    {
        return map[height][width];
    }

    /**
     * @return the restaurant
     */
    public PointOnMap getRestaurant()
    {
        return restaurant;
    }

    /**
     * @return the deliveryAdresses
     */
    public LinkedList<PointOnMap> getDeliveryAdresses()
    {
        return deliveryAdresses;
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
    
    
    
    
}
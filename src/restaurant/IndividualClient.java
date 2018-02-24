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
public class IndividualClient extends Client {
    
    private String name;
    private String surname;

    public IndividualClient(LinkedList<MealOrder> orderList, LinkedList<PointOnMap> possibleAdresses)
    {
        super(orderList, possibleAdresses);
    }
    
    /**
     * @return the name
     */
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
}

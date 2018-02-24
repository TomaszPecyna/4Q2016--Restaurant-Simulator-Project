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
public class OccasionalClient extends IndividualClient {
    
    
    public OccasionalClient(LinkedList<MealOrder> orderList, LinkedList<PointOnMap> possibleAdresses)
    {
        super(orderList, possibleAdresses);
    }
}

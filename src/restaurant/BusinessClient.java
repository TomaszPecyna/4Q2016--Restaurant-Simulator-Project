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
public class BusinessClient extends Client {
    
    private String correspondenceAdress;
    private String bankAccountNumber;
    private String REGON;
    
    public BusinessClient(LinkedList<MealOrder> orderList, LinkedList<PointOnMap> possibleAdresses)
    {
        super(orderList, possibleAdresses);
    }

    /**
     * @return the correspondenceAdress
     */
    public String getCorrespondenceAdress()
    {
        return correspondenceAdress;
    }

    /**
     * @param correspondenceAdress the correspondenceAdress to set
     */
    public void setCorrespondenceAdress(String correspondenceAdress)
    {
        this.correspondenceAdress = correspondenceAdress;
    }

    /**
     * @return the bankAccountNumber
     */
    public String getBankAccountNumber()
    {
        return bankAccountNumber;
    }

    /**
     * @param bankAccountNumber the bankAccountNumber to set
     */
    public void setBankAccountNumber(String bankAccountNumber)
    {
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * @return the REGON
     */
    public String getREGON()
    {
        return REGON;
    }

    /**
     * @param REGON the REGON to set
     */
    public void setREGON(String REGON)
    {
        this.REGON = REGON;
    }
    
}

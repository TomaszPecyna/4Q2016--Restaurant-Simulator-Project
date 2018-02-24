/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import restaurant.Client;
import restaurant.DeliveryMan;
import restaurant.Map;

/**
 *
 * @author Tomek
 */
public class GuiFrame extends JFrame
{
    
    private Dimension mySize;
    
    public GuiFrame(Map map, ArrayList<DeliveryMan> deliveryMans,
            ArrayList<Client> clients)
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        mySize = new Dimension(screenSize.width/2, screenSize.height/2); 
        
        setSize(mySize);
        GuiMap mapFrame = new GuiMap(map, mySize, deliveryMans, clients);
        mapFrame.setVisible(true);
    }
    
    public Dimension getMySize()
    {
        return mySize;
    }
}

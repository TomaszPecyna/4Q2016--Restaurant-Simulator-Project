/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import restaurant.Client;
import restaurant.DeliveryMan;
import restaurant.Map;
import restaurant.DeliveryPoint;

/**
 *
 * @author Tomek
 */
public class GuiMap extends JFrame implements ActionListener
{
    private Dimension mySize;
    private final Timer timer = new Timer(40, this);
    public GuiMap(Map map, Dimension mySize, ArrayList<DeliveryMan> deliveryMans,
            ArrayList<Client> clients)
    {
        this.mySize = mySize;
        mySize.setSize(mySize);
        setSize(mySize);
        timer.start();
        
        
        add(new PaintedMap(map, mySize, deliveryMans, clients));
    }
    
    public Dimension getMySize()
    {
        return mySize;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==timer)
        {
            repaint();
        }
    }
    
}

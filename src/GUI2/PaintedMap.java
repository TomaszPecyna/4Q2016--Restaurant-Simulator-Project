/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;    
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import restaurant.Client;
import restaurant.DeliveryMan;
import restaurant.DeliveryPoint;
import restaurant.PointOnMap;
import restaurant.Map;

/**
 *
 * @author Tomek
 */
public class PaintedMap extends JComponent
{
    private final int width;
    private final int height;
    private BufferedImage house;
    private BufferedImage inn;
    private BufferedImage car;
    private BufferedImage lightBulb;
    private BufferedImage redDot;
    private Map map;
    private Dimension mySize;
    private ArrayList<DeliveryMan> deliveryMans;
    private ArrayList<Client> clients;
    
    public PaintedMap(Map map, Dimension size, ArrayList<DeliveryMan> deliveryMans,
            ArrayList<Client> clients)
    {
        this.clients = clients;
        this.deliveryMans = deliveryMans;
        this.mySize = size;
        this.map = map;
        width = ((int) size.getWidth())/ map.getWidth();
        height = ((int) size.getHeight())/ map.getHeight() - 2;
        try
        {
            house = ImageIO.read(new URL("https://d3higte790sj35.cloudfront.net/images/xh/gd/5a4d38d04ebb1fcefa2688a121ac6f2a.png"));
            inn = ImageIO.read(new URL("https://d3higte790sj35.cloudfront.net/images/si/uv/ec52faf2b57eb19afc8401ae691ca5e4.png"));
            car = ImageIO.read(new URL("http://www.drodd.com/images15/letter-c4.jpg"));
            redDot = ImageIO.read(new URL("http://www.clker.com/cliparts/T/G/b/7/r/A/red-dot.svg"));
            lightBulb = ImageIO.read(new URL("https://d3higte790sj35.cloudfront.net/images/gx/ej/68dfe9cc5b08a3e86bcf186388ad8550.png"));
            redDot = ImageIO.read(new URL("https://d3higte790sj35.cloudfront.net/images/qy/ip/0c4f9bb5fdba9631aebbe6e4861dee1c.png"));
            
        } 
        catch (Exception IOException)
        {
            System.out.println(":(");
        }
        
                
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                super.mouseClicked(event);//To change body of generated methods, choose Tools | Templates.
                PointOnMap position;
                Dimension myLocationDimension;
                synchronized(deliveryMans)
                {
                    for (DeliveryMan deliveryMan : deliveryMans)
                    {
                        position = deliveryMan.getCurrentPosition();
                        myLocationDimension = new Dimension(position.getWidth() * width,
                            position.getHeight()* height);
                        if(myLocationDimension.getWidth() < event.getPoint().getX()
                            && event.getPoint().getX() < myLocationDimension.getWidth() + width
                            &&
                            myLocationDimension.getHeight()< event.getPoint().getY()
                            && event.getPoint().getY() < myLocationDimension.getHeight() + height)

                        {
                            DeliveryManInfo info = new DeliveryManInfo(deliveryMan,
                                                    deliveryMans);
                            info.setVisible(true);
                        }
                    }
                }
                synchronized(clients)
                {
                    for (Client client : clients)
                    {
                        position = client.getAdress();
                        myLocationDimension = new Dimension(position.getWidth() * width,
                            position.getHeight()* height);
                        if(myLocationDimension.getWidth() < event.getPoint().getX()
                            && event.getPoint().getX() < myLocationDimension.getWidth() + width
                            &&
                            myLocationDimension.getHeight()< event.getPoint().getY()
                            && event.getPoint().getY() < myLocationDimension.getHeight() + height)

                        {
                            ClientInfo info = new ClientInfo(clients,
                                                    client);
                            info.setVisible(true);
                        }
                    }
                }
            }
                    
        });
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        DeliveryPoint dp = new DeliveryPoint(1, 1);
        Dimension myLocationDimension;
        
        PointOnMap restaurant = map.getRestaurant();
        PointOnMap position;
        
        for (int i = 0; i < map.getHeight(); i++)
        {
            for (int j = 0; j < map.getWidth(); j++)
            {
                myLocationDimension = new Dimension(map.getPointOnMap(i, j).getWidth() * width,
                        map.getPointOnMap(i, j).getHeight()* height);
                if(map.getPointOnMap(i, j).getClass() == dp.getClass())
                {
                    g.drawImage(house, (int) myLocationDimension.getWidth(),
                        (int) myLocationDimension.getHeight(), width, height, this);
                }
                if(i == restaurant.getHeight() && j == restaurant.getWidth())
                {
                    g.drawImage(inn, (int) myLocationDimension.getWidth(),
                        (int) myLocationDimension.getHeight(), width, height, this);
                }
            }
        }
        synchronized(deliveryMans)
        {
            for (DeliveryMan deliveryMan : deliveryMans)
            {
                position = deliveryMan.getCurrentPosition();
                myLocationDimension = new Dimension(position.getWidth() * width,
                    position.getHeight()* height);
                g.drawImage(car, (int) myLocationDimension.getWidth(),
                    (int) myLocationDimension.getHeight(), width, height, this);
            } 
        }
        for (Client client : clients)
        {
            position = client.getAdress();
            myLocationDimension = new Dimension(position.getWidth() * width,
                position.getHeight()* height);
            g.drawImage(lightBulb, (int) myLocationDimension.getWidth(),
                (int) myLocationDimension.getHeight(), width/2, height/2, this);
            if(client.hasOrders())
            {
                g.drawImage(redDot, (int) myLocationDimension.getWidth(),
                (int) myLocationDimension.getHeight(), width/2, height/2, this);
            }

        }
    }
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }

    private static class map
    {

        public map()
        {
        }
    }
}

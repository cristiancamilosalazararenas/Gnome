package co.edu.autonoma.gnomegames;

import co.edu.autonoma.gnomegame.elements.Apple;
import co.edu.autonoma.gnomegame.elements.Gnome;
import co.edu.autonoma.gnomegame.elements.Sprite;
import co.edu.autonoma.gnomegame.elements.Worm;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Garden extends Sprite {
    private Gnome gnome;
    private ArrayList<Apple> apples = new ArrayList<>();
    private ArrayList<Worm> worms = new ArrayList<>();

    
    public Garden (int x, int y, int width, int height)
    {
        super(x, y, width, height, Color.GREEN);
        
        gnome = new Gnome(100, 100, 50, 50);
    }
    
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        gnome.draw(g);
        
        for(Apple apple : apples)
            apple.draw(g);
        
        for(Worm worm : worms)
        worm.draw(g);
    }
    
    public void handleKey(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gnome.handleKey(e);
                checkForApplesEaten();
            break;
            case KeyEvent.VK_A:
                addApple();
            break;
            case KeyEvent.VK_S:
                addWorm();
                break;
        }    
    }
    
    private void addWorm() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        Worm worm = new Worm(x, y, 25, 25);
        worms.add(worm);
    }
    
    private void checkForApplesEaten()
    {
        for(int i=0; i<apples.size(); i++)
        {
            Apple apple = apples.get(i);
            
            if(gnome.hit(apple))
            {
                apples.remove(apple);
                i --;
                
                gnome.grow();
            }
        }
        
        for (int i = 0; i < worms.size(); i++) {
            Worm worm = worms.get(i);
            if (gnome.hit(worm)) {
                worms.remove(worm);
                i--;
                gnome.shrink();
            }
        }
    }
    
    private void addApple()
    {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        Apple apple = new Apple(x, y, 25, 25);
        
        apples.add(apple);
    }
}

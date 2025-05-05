package co.edu.autonoma.gnomegame.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Gnome extends Sprite {
    
    public static final int STEP = 10;
    public static final int EAT_SIZE = 10;
    
    public Gnome(int x, int y, int width, int height) {
        super(x, y, width, height, Color.MAGENTA);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void grow()
    {
        width += EAT_SIZE;
        height += EAT_SIZE;
    }
    
    public void handleKey(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                y -= STEP;
                break;
                
            case KeyEvent.VK_DOWN:
                y += STEP;
                break;
                
            case KeyEvent.VK_LEFT:
                x -= STEP;
                break;
                
            case KeyEvent.VK_RIGHT:
                x += STEP;
                break;
        }  
    }
    
    public void shrink() {
        width = Math.max(10, width - EAT_SIZE);
        height = Math.max(10, height - EAT_SIZE);
    }
}


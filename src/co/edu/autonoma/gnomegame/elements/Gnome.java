package co.edu.autonoma.gnomegame.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Gnome extends Sprite {
    
    public static final int STEP = 10;
    public static final int EAT_SIZE = 10;
    private int gardenWidth;
    private int gardenHeight;
    
    public Gnome(int x, int y, int width, int height, int gardenWidth, int gardenHeight) {
        super(x, y, width, height, Color.MAGENTA);
        this.gardenWidth = gardenWidth;
        this.gardenHeight = gardenHeight;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void grow() {
        width += EAT_SIZE;
        height += EAT_SIZE;
        ajustarPosicionTrasCambioTamaño();
    }
    
    public void shrink() {
        width = Math.max(10, width - EAT_SIZE);
        height = Math.max(10, height - EAT_SIZE); 
        ajustarPosicionTrasCambioTamaño();
    }
    
    private void ajustarPosicionTrasCambioTamaño() {
        x = Math.min(x, gardenWidth - width);
        y = Math.min(y, gardenHeight - height);
        x = Math.max(0, x);
        y = Math.max(0, y);
    }
    
    public void handleKey(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                y -= STEP;
                y = Math.max(0, y);
                break;
                
            case KeyEvent.VK_DOWN:
                y += STEP;
                y = Math.min(y, gardenHeight - height);
                break;
                
            case KeyEvent.VK_LEFT:
                x -= STEP;
                x = Math.max(0, x);
                break;
                
            case KeyEvent.VK_RIGHT:
                x += STEP;
                x = Math.min(x, gardenWidth - width);
                break;
        }  
    }
}
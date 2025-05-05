package co.edu.autonoma.gnomegame.elements;

import java.awt.Color;
import java.awt.Graphics;

public class Worm extends Sprite {
    
    public Worm(int x, int y, int width, int height) {
        super(x, y, width, height, Color.PINK);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}

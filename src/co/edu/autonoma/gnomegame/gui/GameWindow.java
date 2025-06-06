package co.edu.autonoma.gnomegame.gui;

import co.edu.autonoma.gnomegames.Garden;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameWindow extends javax.swing.JFrame {

    private Garden garden;

    public GameWindow() {
        initComponents();
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                garden.handleKey(evt);
            break;
            
            case KeyEvent.VK_A:
                garden.handleKey(evt);
            break;
            
            case KeyEvent.VK_Q:
                exitGame();
            break;
            
            case KeyEvent.VK_S:
            garden.handleKey(evt);
            break;
        }
        
        repaint();
    }//GEN-LAST:event_formKeyPressed
    private void exitGame()
    {
        System.exit(0);
    }
    
    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
    
       garden.draw(g);
    }

    public static void main(String args[]) {
        GameWindow window = new GameWindow();
        
        Garden garden = new Garden(0, 0, window.getWidth(), window.getHeight());
        
        window.setGarden(garden);
        
        window.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

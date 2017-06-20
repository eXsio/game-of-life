package pl.exsio.gol.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellListener implements MouseListener {
    
    private Cell c;

   public CellListener(Cell c) {

        this.c = c;

   }

    public void mouseClicked(MouseEvent e) {
            
    }

    public void mousePressed(MouseEvent e) {
               if (c.isPopulated()) c.setPopulated(false);
                  else  c.setPopulated(true);

    }

    public void mouseReleased(MouseEvent e) {
 
    }

    public void mouseEntered(MouseEvent e) {
            if (e.getModifiers()!=0) {
                  if (c.isPopulated()) c.setPopulated(false);
                  else  c.setPopulated(true);
            }
    }

    public void mouseExited(MouseEvent e) {
       
    }

 

}

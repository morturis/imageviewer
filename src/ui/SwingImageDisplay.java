package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel{
    private Image currentImage;

    public SwingImageDisplay(Image currentImage) {
        this.currentImage = currentImage;
    }
    //TODO
    private BufferedImage imageOf(Image image){              
        return null;
    }
    
    @Override
    public void paint(Graphics g){
        if(currentImage==null) return;
        g.drawImage(imageOf(currentImage), 0, 0, null);
    }

    public Image current() {
        return currentImage;
    }
    
    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

package ui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SwingImageDisplay extends JLabel{
    private Image currentImage;

    public SwingImageDisplay(Image currentImage) {
        super(new ImageIcon(currentImage));
        this.currentImage = currentImage;       
    }
    public Image current() {
        return currentImage;
    }    
    public void changeImage(Image newImage){
        currentImage = newImage;
        setIcon(new ImageIcon(newImage));
    }
    
    
}

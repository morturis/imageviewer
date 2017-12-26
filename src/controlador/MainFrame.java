package controlador;

import modelo.FileImageLoader;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import ui.SwingImageDisplay;

public class MainFrame extends JFrame{
    private int count=0;
    private JTextArea campoTexto = new JTextArea(String.valueOf(0), 1, 5);
    private FileImageLoader loader;
    private SwingImageDisplay display;

    public MainFrame(FileImageLoader loader) throws IOException {
        this.loader=loader;
        this.setTitle("Prueba");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay(loader.load()));
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    
    private JPanel toolbar(){
        JPanel panel =new JPanel();
        panel.add(campoTexto);
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    private JButton nextButton(){
        JButton button = new JButton(">");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(count==loader.getNumberOfImages()-1){
                    count=0;
                }else{
                    count++;
                }
                try {
                    nextImage();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                campoTexto.setText(String.valueOf(count));
            }
        });
        return button;
    }
    
    private JButton prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(count==0){
                    count=loader.getNumberOfImages()-1;
                }else{
                    count--;
                }
                try {
                    prevImage();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                campoTexto.setText(String.valueOf(count));
            }
        });
        return button;
    }
    private SwingImageDisplay imageDisplay (Image image){
        this.display = new SwingImageDisplay(image);
        return display;
    }

    private void nextImage() throws IOException{
        display.changeImage(loader.next());
    }
    
    private void prevImage() throws IOException{
        display.changeImage(loader.prev());        
    }
    
    
}

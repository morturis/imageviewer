package controlador;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    private int count=0;
    private JTextArea campoTexto = new JTextArea(String.valueOf(0), 1, 5);

    public MainFrame() {
        this.setTitle("Prueba");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
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
                if(count==10){
                    count=0;
                }else{
                    count++;
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
                    count=10;
                }else{
                    count--;
                }
                campoTexto.setText(String.valueOf(count));
            }
        });
        return button;
    }

    public Object getImageDisplay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.MainFrame;
import java.io.IOException;
import modelo.FileImageLoader;


/**
 *
 * @author Entrar
 */
public class ImageViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileImageLoader loader = new FileImageLoader("C:\\Users\\Rafael\\Pictures");
        MainFrame mainFrame = new MainFrame (loader);        
        
    }
    
}

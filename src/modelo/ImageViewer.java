/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Persistence.FileImageLoader;
import controlador.MainFrame;
import java.awt.Image;
import java.io.File;

/**
 *
 * @author Entrar
 */
public class ImageViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File[] folder = new File ("ruta").listFiles();
        FileImageLoader listImages = new FileImageLoader(folder);
        Image image = FileImageLoader.load();
        MainFrame mainFrame = new MainFrame();
        
    }
    
}

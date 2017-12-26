package modelo;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class FileImageLoader{
    private final File[] file;
    private int current = 0;

    public FileImageLoader(String directorio) {
        this.file = new File(directorio).listFiles(imageType());
    }
    private FileFilter imageType(){
        return new FileFilter(){
            @Override
            public boolean accept(File pathname){
                return pathname.getName().endsWith(".png");
            }
        };
    }

    public String name() {
        return file[current].getName();
    }

    public InputStream stream() throws FileNotFoundException {
        return new BufferedInputStream (new FileInputStream (file[current]));
    }

    public Image next() throws IOException {
        if(current==file.length-1){
            current = 0;
        }else{
            current++;
        }
        return load();
    }

    public Image prev() throws IOException {
        if(current ==0){
            current = file.length-1;
        }else{
            current--;
        }
        return load();
    }
    
    public Image load() throws IOException {
        return ImageIO.read(file[current]);
    }
    
    public int getNumberOfImages() {return file.length;}
}

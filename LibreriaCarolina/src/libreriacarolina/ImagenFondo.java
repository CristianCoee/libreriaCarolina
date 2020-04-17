/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriacarolina;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
/**
 *
 * @author linke
 */
public class ImagenFondo implements Border {
    public BufferedImage image;
 
    public ImagenFondo(BufferedImage image){
       this.image=image; }
    
    public void paintBorder (Component c, Graphics g, int x, int y, int width, int height){
        int x0=x+(width-image.getWidth())/2;
        int y0=y+(height-image.getHeight())/2;
        g.drawImage(image, x0, y0, null);
    }
    
    public Insets getBorderInsets (Component c){
        return new Insets (0,0,0,0);
    }
    
    public boolean isBorderOpaque (){
        return true;
    }

}

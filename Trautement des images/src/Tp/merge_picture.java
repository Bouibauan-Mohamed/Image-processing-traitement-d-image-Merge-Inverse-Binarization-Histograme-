/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp;

import static Tp.Traitement.fusionner;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bouib
 */
public class merge_picture {
  
    
    //Exercice 2:fonction permet de fusionner deux image
          protected static  BufferedImage fusionner(BufferedImage img1,BufferedImage img2)     {
        
             int W = img2.getWidth();
             int H = img2.getHeight();
            BufferedImage img3 = new BufferedImage(W, H, BufferedImage.TYPE_BYTE_BINARY);
            
            
          for(int i=0; i<W; i++){
			for(int j=0; j<H; j++){
                         int a=img1.getRGB(i, j)& 0xFF;
                         int e=img2.getRGB(i, j)& 0xFF;
                          int c=a+e;
                           // System.out.println(c);
                          if(c>255){ //si depasse 255
                              c=c-255;}
                          
                           if(c<0){
                              c=c+255;}
                          
                              
                            img2.setRGB(i,j,new Color(c,c,c).getRGB());}} 
                                    
          return img2;
      }
            public static void main(String args[]) throws IOException{
          
           //2 fusion de l' img1 et img 2 +sauvegarder:
 BufferedImage   img1=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img1.jpg"));
 BufferedImage   img2=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img2.jpg"));
 
       BufferedImage fu=fusionner(img1,img2); 
       try { ImageIO.write(fu,"JPG", new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\fusion_img1_img2.jpg"));
		}
		catch (IOException e) { e.printStackTrace();}
       
    
}}

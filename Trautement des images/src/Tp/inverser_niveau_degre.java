/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp;

import static Tp.Traitement.Inverser_niveau_degre;
import static Tp.Traitement.ni;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bouib
 */
public class inverser_niveau_degre {
    
    
       // Exercice3: fonction permet d'INVERSER LES NIVEAUX DE GRIS
       
             protected static  BufferedImage Inverser_niveau_degre(BufferedImage image )     {
           int w = image.getWidth(); 
	   int h = image.getHeight();
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                         int niveu_degre=image.getRGB(i, j)& 0xFF;
                           ni=255-niveu_degre;
                            image.setRGB(i,j,new Color(ni,ni,ni).getRGB());}}
                                    
          return image;
      }
             
              public static void main(String args[]) throws IOException{
      
        //read les deux image          
 BufferedImage   img1=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img1.jpg"));
     
       // 3 INVERSER LES NIVEAUX DE GRIS de img1:
     BufferedImage inv=Inverser_niveau_degre(img1);
     
     try { ImageIO.write(inv, "JPG", new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\inverse_img1.jpg"));
		}
		catch (IOException e) { e.printStackTrace();}
    
}}

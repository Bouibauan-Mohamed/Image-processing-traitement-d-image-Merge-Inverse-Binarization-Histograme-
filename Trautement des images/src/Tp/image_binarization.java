/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp;

import static Tp.Traitement.binarisation;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bouib
 */
public class image_binarization {
     static int  s=200;
     static int  m;
     static int  ni;
     
     // Exercice 1: fonction permet de binariser une image ca depand de la seuille
      protected static  BufferedImage binarisation(BufferedImage image )     {
           int w = image.getWidth(); 
	   int h = image.getHeight();
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                         int niveu_degre=image.getRGB(i, j)& 0xFF;  //niveau degre
                 
                         if(niveu_degre<s){
                          m=0;}
                         else{
                                  m=255;
                                  }
                            image.setRGB(i,j,new Color(m,m,m).getRGB());}}
                                    
          return image;
      }
      
      public static void main(String args[]) throws IOException{
       //read les deux image          
 BufferedImage   img1=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img1.jpg"));
 BufferedImage   img2=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img2.jpg"));
      
 //1 binarisation de img1 et le sauvegarder:
 
 BufferedImage bi=binarisation(img1 )  ;

try { ImageIO.write(bi, "JPG", new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img1_en_binaire.jpg"));
		}
		catch (IOException e) { e.printStackTrace();}


    
}}

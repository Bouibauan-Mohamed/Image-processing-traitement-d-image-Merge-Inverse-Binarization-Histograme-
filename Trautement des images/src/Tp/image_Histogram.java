/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author bouib
 */
public class image_Histogram {
    
    //fonction permet de calculer la valeur  moyenne d'une image
   static public float Moyenne(BufferedImage  image){
        int somme=0;
    
              int w =image.getWidth(); 
	      int h =image.getHeight();
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                         int niveu_degre=image.getRGB(i, j)& 0xFF;
                         somme=somme+niveu_degre;}} //la somme de  la valeur de tou les pixel d'image
          
       return somme/(w*h);
    }
    
    
    
            
        //fonction permet de calculer l'ecart type d'une image par deux Méthodes il ya deux Methode
        static  public float Ecart_type(BufferedImage  image){
                 int w =image.getWidth(); 
	         int h =image.getHeight();
                 double variance=0;
                  //Methode 1: java est trés lent  prend beaucaup de temps pour faire les calcules donc j'ai decidé de commnter Methode 1 
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                           
                         //int niveu_degre=image.getRGB(i, j)& 0xFF;
                         //variance+=(w*h)*Math.pow(niveu_degre-Moyenne(image), 2);
   
                                }}
                         //float   ecart_type=(float) Math.sqrt(variance);
          //methode 2:
          float ecart=(Max(image)-Min(image))/(Max(image)+Min(image));
          
            return ecart;
          }
          
    
    //fonction permet de calculer la valeur max d'une image
      static  public int Max(BufferedImage  image){
        int max=image.getRGB(0, 0)& 0xFF;; //initialiser max par la permière valeur du l'image c-a-d pixel (0,0)
    
              int w =image.getWidth(); 
	      int h =image.getHeight();
         
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                         int niveu_degre=image.getRGB(i, j)& 0xFF;
                       if(niveu_degre>=max){   //comparer la valeur (0,0) avec les autre valeur et mise a jour chaque fois du max
                           
                           max=niveu_degre;
                       }}}
        return max;
        }
        
          //fonction permet de calculer la valeur min d'une image
       static public int Min(BufferedImage  image){
        int min=image.getRGB(0, 0)& 0xFF;  //initialiser min par la permière valeur du l'image c-a-d pixel (0,0)
    
              int w =image.getWidth(); 
	      int h =image.getHeight();
         
          for(int i=0; i<w; i++){
			for(int j=0; j<h; j++){
                         int niveu_degre=image.getRGB(i, j)& 0xFF;
                       if(niveu_degre<=min){  //comparer la valeur (0,0) avec les autre valeur et mise a jour chaque fois du min
                           
                           min=niveu_degre;
                       }}}
        return min;
        }
        
        // fonction etaler l'hitograme entre 0 et 255 c-ad les niveau des gris et leurs  occurence on utilise hachMap qui suuport 2 valeur 
       //clé qui est le niveau degré et value c'est nombre d'occurence
   static public HashMap<Integer,Integer> histog ( BufferedImage IMG){
           int w = IMG.getWidth(); 
	   int h = IMG.getHeight();
          
           HashMap<Integer,Integer> hi=new HashMap<Integer,Integer>(); //hi c'est un variable  de type  Hashmap contient les deux valeur de l'histogram
           int[] niveu_degre=new int[w*h]; //tableau contient tout les niveau degree d'image
          for(int i=0; i<w; i++){
              for(int j=0; j<h; j++){
                         niveu_degre[i]=IMG.getRGB(i,j)& 0xFF;}}
          
           for(int i=0; i<niveu_degre.length; i++){
               int c=0;// compteur calcule nombre d'occurence
           //calculer le nombre d'occuence de chaque niveau degre
              for(int j=1; j<niveu_degre.length; j++){
                  if(niveu_degre[i]==niveu_degre[j]){
                      c++;
                  }
              }
              hi.put(niveu_degre[i], c); //ici a chaque i en remplie le  HashMap par le clé qui est niveau degre et value qui est  nombre d'occurence "c"
                  
              }
           return hi;
}
//fonction permer d'egaliser l'hidtogram d'une image
   static public BufferedImage  Egalise_histogram(BufferedImage IMG){
    HashMap<Integer,Integer> hi=histog(IMG); //on utilise la fonction précident qui calcule l'hitograme d'une image et return Hashmap
     int w = IMG.getWidth(); 
     int h = IMG.getHeight();
     int s=0;
     for(Map.Entry<Integer,Integer> entry:hi.entrySet()){
               int key=entry.getKey(); //key contient les niveau degré de l'image qui sont remple dans le Hashmap
               int value=entry.getValue();//value  contient les occurences de chaque niveau dégre
              
    s=s+255/(w*h)* value; //relation de l'egalisation "sur les occurences  "
    entry.setValue(s);//modifir la valeur précident de l'occurence par un autre value respecte la relation de l'egalisation
}
return IMG;}
   
   
//fonction permer d'affiche l'histogramme d'une image sur le console "java un peu lent patientez SVP"
   
   
static public void afficher_histogram(BufferedImage IMG){
 HashMap<Integer,Integer> hi=histog(IMG); //calculer l'histogram de  l'image IMG
    
 for(Map.Entry<Integer,Integer> entry:hi.entrySet()){
               
               int key=entry.getKey();//niveau degré 
               int value=entry.getValue();//nmbr d'occurence
               System.out.printf("%3d | ",key);
               for(int i=0;i<value;i++){
                   System.out.print("=");}
               System.out.print(" "+value);
               System.out.println();
               
               
           }

}
        public static void main(String args[]) throws IOException{  
                   //read l'image          
 BufferedImage   img1=ImageIO.read(new File("C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp\\img1.jpg"));
 
              System.out.println("la Moyenne est :"+Moyenne(img1));
              System.out.println("le Max :"+Max(img1));
              System.out.println("la Min est :"+Min(img1));
              System.out.println("l'Ecart type est :"+Ecart_type(img1));
              System.out.println("l'afichage de l'histograme  prend qlq Minutes patinter SVP  :)");
          //calcule Histogramme de l'img1:
           HashMap<Integer,Integer> hi=histog(img1);
           //affiche l'histogramme de l'img1 sur le consol un peu lent
           //afficher_histogram(img1);
           BufferedImage  image_egaliser=Egalise_histogram(img1);
           afficher_histogram(image_egaliser);
 
        }
        
          
          
    
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformation;

/**
 *
 * @author bouib
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main{
	public static void main(String []args) {

		
	String path = "C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp2\\rain14.jpg" ; 
		Img img = new Img(); 
		img.read(path);
		img.save(img.img ,"C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp2\\img__a_transformer.jpg");
		
                BufferedImage res1 = null;
                BufferedImage res2 = null;
                BufferedImage res3 = null;
		//transmation
		res1 = img.translation(100, 100); 
		img.save(res1,"C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp2\\img__tanslate.jpg");
                //rotation 
		res2 = img.rotation((float)Math.PI/9); 
		img.save(res2,"C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp2\\img__rotation.jpg");
		//Homothesie 
                
               //res3 = img.Homothesie(2,1);
		//img.save(res2,"C:\\Users\\bouib\\OneDrive\\Bureau\\Bouibauan Mohamed\\Trautement des images\\src\\Tp2\\img__Homothesie.jpg");
		
	

	}

}

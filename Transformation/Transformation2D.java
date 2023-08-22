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
public class Transformation2D {
    
    
    
static float[] translation(float[] d, float dx, float dy) {
	
	float[][] mat = {{1,0,0},{0,1,0},{dx,dy,1}};

	 return Matrice.produitVectorMatrix(d,mat);
	

	}


static float[] Rotation (float[] a , float theta) {
	
		float  [][] mat = {{(float) Math.cos(theta),(float) Math.sin(theta),0},{(float) -Math.sin(theta),(float) Math.cos(theta),0},{0,0,1}};
		return   Matrice.produitVectorMatrix (a, mat); 
	}


	
	static float[] Homothesie (float[] a , float sh, float sv) {
		
		float [][] mat = {{sh,0,0},{0,sv,0},{0,0,1}};
		
	
		  return Matrice.produitVectorMatrix(a,mat);
		
	
	}
    
}

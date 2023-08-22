/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformation;
import java.util.*;

/**
 *
 * @author bouib
 */

public class Matrice {
	
	 static Scanner input = new Scanner(System.in);

		 
	
	 
	 
	
      public static float[][] litMatrice(int m,int n){

          float[][] M=new float[m][n];
		for(int i=0; i<m;i++) {
		    for (int j=0; j<n;j++){
                        System.out.println("donner l'element "+i+":");
                         float f = input.nextFloat();
		           M[i][j]=f;
		      }
		     } 
		  return M;
		}
	
	
	
     	public static void AfficheMatrice(float [][] A){
		  System.out.println("∗∗∗ Affichage de la Matrice demandee ∗∗∗");
		for(int i=0; i< A.length; i++){
		        for (int j=0; j<A[0].length;j++){
		        	System.out.print("\t" +A[i][j]+"" );
		        }
		       System.out.println();
		     }
     	}	
		
     	
		
     	
		public static float[][] Addition(float[][] A, float[][] B){
			float [][] C;
			C = new float[A.length][A[0].length];
			for(int i=0; i< A.length; i++){
		        for (int j=0; j<A[0].length;j++){
		        	C[i][j]=A[i][j]+B[i][j];
		        }
		    
		     }
			
			return C;
			}
		
		
		
		public static float[][] Transposee (float[][] A){
			float[][] B;
			B = new float[A[0].length][A.length];
			
			for(int i=0; i< A.length; i++){
		        for (int j=0; j<A[0].length;j++){
		        	B[j][i]=A[i][j];
		        }
		    
		     }
			return B;
			}
		
		
		public static  float[][] produit_par_un_scalaire(float[][] A, float x){
			float [][] B;
			B = new float[A.length][A[0].length];
			for(int i=0; i< A.length; i++){
		        for (int j=0; j<A[0].length;j++){
		        	B[i][j]=A[i][j]*x;
		        }
		    
		     }
			return B;
			}
		
		
		public static float[] produitVectorMatrix (float[] A,float [][]B){
		// n'oubliez pas la contrainte le nombre des colonnes de A = nombres des lignes de B
		int m = A.length;
		float[] vr = new float [m]; 
		float tmp = 0 ; 
		if(B.length == A.length) {
			for (int i = 0 ; i < m ; i++ ) {
					tmp = 0 ; 
					for (int k = 0 ; k < m ; k++ ) 
						tmp += A[k]*B[k][i] ; 
					vr[i]= tmp; 
				}
		}
		return vr;
	}
                
                
                
		
		public static float[][] Produit_matrice(float[][] A, float[][] B){
		   if (A[0].length == B.length )
		   {
			float[][] C;
			C = new float[A.length][B[0].length];
			for(int i=0; i< A.length; i++){
		        for (int j=0; j<B[0].length;j++){
		        	for (int k=0; k<A[0].length;k++){
			        	C[i][j]+=A[i][k]*B[k][j];
			        }
		        }
		    
		     }
			return C;
			}
		   else return null ;
			}
		
		
		public static boolean Identique(float[][] A, float [][] B){
			   int c=0;
                           boolean  identique;
			for(int i=0; i< A.length; i++){
		        for (int j=0; j<A[0].length;j++){
		          if(B[i][j]!=A[i][j]) c++; //System.out.println("Les deux matrices sont identiques");
		         // else System.out.println("Les deux matrices sont differentes");
		        }
		    
		     }
			if(c==0){
                            
                         identique=true ;
			}
                        else{
			
	             identique=false ;}
                        return  identique;
                }
		
			// Main pour tester vos fonctions
		public static void main (String[] args) {
			float[][] mat_1;
			float [][] mat_2;
			float [][] Addition;
			float [][] Transposee;
			float [][] produitS;
			float [][] produit_vecteur;
			float [][] Produit_matrice;
			boolean Identique;
			mat_1 = litMatrice(2,2);
                        System.out.println("matrice 2:");
                        mat_2 = litMatrice(2,2);
		        AfficheMatrice(mat_1)   ;  
			AfficheMatrice(mat_2)   ;  
                        Addition=Addition(mat_1,mat_2);
                        System.out.println("la somme du deux matrice");
                        AfficheMatrice(Addition);
                        System.out.println("le transposé du matrice précident:");
                        Transposee=Transposee(Addition);
                         AfficheMatrice(  Transposee) ;
                      
                         System.out.println("multuplié matrice précident par 2:");
                        produitS=produit_par_un_scalaire(Transposee,2);
                        AfficheMatrice(produitS)   ; 
                         System.out.println("le produit de deux matrice suivant :");
          
			AfficheMatrice(mat_1)   ; 
                         AfficheMatrice(mat_2)   ;
                        System.out.println("est:");
                        Produit_matrice=Produit_matrice(mat_1,mat_2);
                        AfficheMatrice(Produit_matrice);
                        Identique=Identique(mat_1,mat_2);
                        System.out.println(Identique);
			
	
                      
			}
			

    
}

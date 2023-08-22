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
public class Pixel {
      int abs,ord,nv;

    public Pixel(){
        this.abs=0;
        this.ord=0;
        this.nv=0;
        
    }
    
    public Pixel(int abs, int ord, int nv) {
        this.abs = abs;
        this.ord = ord;
        this.nv = nv;
    }
    
    public Pixel(Pixel a) {
			this.abs = a.abs ;
			this.ord = a.ord ;
			this.nv = a.nv ;
		}
static void Affiche(Pixel p){
    System.out.println("P"+p.abs+","+p.ord+")="+p.nv);
} 


	
    
    
}

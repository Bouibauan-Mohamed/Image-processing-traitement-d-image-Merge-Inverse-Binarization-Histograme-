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

  import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img {
	int M; 
	int N; 
	BufferedImage img;
	int data [][];
	public Img () {
		M = 0;
		N = 0 ; 
		img = null; 
		data = null; 
	}
	
	public void read(String path) {
		
		// LECTRUE D image
		try {
			img = ImageIO.read(new File(path)); 
			}
		catch (IOException e) { e.printStackTrace(); }
		
		ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY); 
		ColorConvertOp op = new ColorConvertOp(cs, null);
		img = op.filter(img, null);
		// intialisation image
		N = img.getWidth() ; 
		M = img.getHeight() ; 
		data = new int [M][N];
		
	}
	
	public int [][] getData() {
		int nv ; 
		int [] [] data = new int [N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++ ) {
				int rgb = img.getRGB(i, j) ;
				data[i][j] = img.getRGB(i, j) & 0xFF; 
			}
		}
		return data;
	}
	
	public void save(BufferedImage nimg , String path) {
		// sauvgarde de l'image 
		try {
			// l'image lu sera sauvegarder dans un autre fichier 
			ImageIO.write(nimg, "JPG", new File(path));
		}
		catch (IOException e ) {e.printStackTrace(); }

	}


	
	public BufferedImage translation(float dx, float dy) {
		BufferedImage res = new BufferedImage(N,M, img.getType());
		int data[][] = getData();
		for (int i=0; i<N; i++ ) {
			for (int j = 0 ; j < M ; j++) {
				float p [] = {i,j,1} ;
				p=Transformation2D.translation(p, dx, dy);
				
				if (p[0]<N && p[1]<M)
				res.setRGB((int)p[0],(int)p[1], new Color(data[i][j],data[i][j],data[i][j]).getRGB() ) ;
			}
		}
		return res;
	}
	
	/*
	 * rotation
	 * 
	 */
	public BufferedImage rotation(float teta) {
		BufferedImage res = new BufferedImage(N,M, img.getType());
		int data[][] = getData();
		for (int i=0; i<N; i++ ) {
			for (int j = 0 ; j < M ; j++) {
				float p [] = {i,j,1} ;
				p=Transformation2D.Rotation(p, teta);

				if (p[0]>=0 && p[0]<=N && p[1]>=1&&p[1]<=M)
				res.setRGB((int)p[0],(int)p[1], new Color(data[i][j],data[i][j],data[i][j]).getRGB() ) ;
			}
		}
		return res;
	}
        
        	public BufferedImage Homothesie(float sh, float sv) {
		BufferedImage res = new BufferedImage(N,M, img.getType());
		int data[][] = getData();
		for (int i=0; i<N; i++ ) {
			for (int j = 0 ; j < M ; j++) {
				float p [] = {i,j,1} ;
				p=Transformation2D.Homothesie(p,sh,sv);

				if (p[0]>=0 && p[0]<=N && p[1]>=1&&p[1]<=M)
				res.setRGB((int)p[0],(int)p[1], new Color(data[i][j],data[i][j],data[i][j]).getRGB() ) ;
			}
		}
		return res;
	}
	
	
}
  


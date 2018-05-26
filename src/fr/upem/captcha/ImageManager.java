package fr.upem.captcha;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import fr.upem.captcha.image.classIMG.ClassIMG;
import fr.upem.captcha.image.classIMG.feutres.Feutres;
import fr.upem.captcha.image.classIMG.numerique.Numerique;
import fr.upem.captcha.image.classIMG.peinture.Peinture;

public class ImageManager {
	
	private Feutres feutres;
	private Numerique numerique;
	private Peinture peinture;
	
	public ImageManager() {
		this.feutres = new Feutres();
		this.numerique = new Numerique();
		this.peinture = new Peinture();
	}
	
	public Feutres getFeutres() {
		return feutres;
	}
	
	public Numerique getNumerique() {
		return numerique;
	}
	
	public Peinture getPeinture() {
		return peinture;
		
	}
	
	public ArrayList<URL> getSelection(){
		Random rand = new Random();
		int randomDraw = rand.nextInt( 3 )+1;
		int alea = rand.nextInt( 4 )+1;
		ArrayList<URL> result = new ArrayList<URL>();
		
		switch (randomDraw) {
			case 1:
			System.out.println("alea feutres = " + alea);
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
					System.out.println("ici feutres");
				}
				
				alea = rand.nextInt( 3 )+1;
				
				System.out.println("alea peinture = " + alea);
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
					System.out.println("ici peinture");
				}
				
				alea = 8-result.size();
				
				System.out.println("alea numerique = " + alea);
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
					System.out.println("ici numerique");
				}
				
				break;
				
			case 2:
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 3 )+1;
				
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = 8-result.size();
				
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				break;
				
			case 3:
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 3 )+1;
				
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = 8-result.size();
				
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				break;

			default: return null;
		}
		
		return result;
		
	}

	public ArrayList<URL> shakeSelection(){
		ArrayList<URL> bdd = this.getSelection();
		ArrayList<URL> result = new ArrayList<URL>();
		URL url;
		Random rand = new Random();
		int j = 0;
		
		while(j < 8) {
			url = bdd.get(rand.nextInt(bdd.size()));
			if (bdd.contains(url)) {
				result.add(url);
				bdd.remove(url);
				j++;
			}	
		}
		return result;
	}
	
	
}

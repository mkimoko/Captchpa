package fr.upem.captcha;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
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
	
	/*public Feutres getFeutres() {
		return feutres;
	}
	
	public Numerique getNumerique() {
		return numerique;
	}
	
	public Peinture getPeinture() {
		return peinture;
		
	}*/
	
	public ArrayList<URL> getSelection(){
		Random rand = new Random();
		int randomDraw = rand.nextInt( 3 )+1;
		int alea = rand.nextInt( 4 )+1;
		ArrayList<URL> result = new ArrayList<URL>();
		
		switch (randomDraw) {
			case 1:
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 3 )+1;
				
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = 8-result.size();
				
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
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
	
	public int typeChoice() {
		Random rand = new Random();
		int alea = rand.nextInt(3)+1;
		
		switch (alea) {
			case 1:
				System.out.println(" Selectionnez les dessins fait au feutres");
				break;
				
			case 2:
				System.out.println(" Selectionnez les dessins digitaux");
				break;
				
			case 3:
				System.out.println(" Selectionnez les peintures");
				break;
	
			default:
				return 0;
		}
		return alea;
		
	}
	
	public boolean choice(int alea, ArrayList<URL> choiceSelection) {
			int nbGoodPhoto = 0;
			ArrayList<URL> urlList = shakeSelection();
			if (alea > 0 && alea < 5 && Objects.nonNull(choiceSelection)) {
				switch (alea) {
				case 1:
					// trouver les feutres
					for (URL url : urlList) {
						if(feutres.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					if (choiceSelection.size() == nbGoodPhoto ) {
						for (URL url : choiceSelection) {
							if(! feutres.isPhotoCorrect(url))
								return false;
						}
					}
					break;
					
				case 2:
					// trouver les numerique
					for (URL url : urlList) {
						if(numerique.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					if (choiceSelection.size() == nbGoodPhoto ) {
						for (URL url : choiceSelection) {
							if(! numerique.isPhotoCorrect(url))
								return false;
						}
					}
					break;
					
				case 3:
					// trouver les peintures
					for (URL url : urlList) {
						if(peinture.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					
					if (choiceSelection.size() == nbGoodPhoto ) {
						for (URL url : choiceSelection) {
							if(! peinture.isPhotoCorrect(url))
								return false;
						}
					}
					break;
	
				default:
					return false;		
				}
				
				
				return true;
				
			}
			return false;
			
		}
}

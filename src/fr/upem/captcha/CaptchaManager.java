/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.captcha;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import fr.upem.captcha.image.classIMG.ClassIMG;
import fr.upem.captcha.image.classIMG.feutres.Feutres;
import fr.upem.captcha.image.classIMG.numerique.Numerique;
import fr.upem.captcha.image.classIMG.peinture.Peinture;

public class CaptchaManager {
	
	private Feutres feutres;
	private Numerique numerique;
	private Peinture peinture;
	
	public CaptchaManager() {
		this.feutres = new Feutres();
		this.numerique = new Numerique();
		this.peinture = new Peinture();
	}
	
	
	public ArrayList<URL> getSelection(){
		Random rand = new Random();
		int randomDraw = rand.nextInt( 3 )+1;
		int alea = rand.nextInt( 4 )+1;
		ArrayList<URL> result = new ArrayList<URL>();
		System.out.println(alea);
		
		switch (randomDraw) {
			case 1:
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 4 )+1;
				
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				if (9-result.size() > 5) {
					result.add(feutres.getRandomPhotoURL());
					result.add(peinture.getRandomPhotoURL());
				}
				
				alea = 9-result.size();
				
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				break;
				
			case 2:
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 4 )+1;
				
				for (URL url : peinture.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				if (9-result.size() > 5) {
					result.add(numerique.getRandomPhotoURL());
					result.add(peinture.getRandomPhotoURL());
				}
				
				alea = 9-result.size();
				
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				break;
				
			case 3:
				for (URL url : feutres.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				alea = rand.nextInt( 4 )+1;
				
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
					result.add(url);
				}
				
				if (9-result.size() > 5) {
					result.add(feutres.getRandomPhotoURL());
					result.add(numerique.getRandomPhotoURL());
				}
				alea = 9-result.size();
				
				for (URL url : numerique.getRandomPhotoUrlList(alea)) {
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
		
		while(j < 9) {
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
		return alea;
		
	}
	
	public String text(int choice) {
		
		switch (choice) {
			case 1:
				return "Selectionnez les dessins fait au feutres";
				
			case 2:
				return "Selectionnez les dessins digitaux";
				
			case 3:
				return "Selectionnez les peintures";
				
			default:
				return null;
		}
		
	}
	
	public String choice(int alea, ArrayList<URL> choiceSelection) {
			int nbGoodPhoto = 0;
			if (alea > 0 && alea < 4 && Objects.nonNull(choiceSelection)) {

				switch (alea) {
				case 1:
					// trouver les feutres
					for (URL url : choiceSelection) {
						if(feutres.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					if (choiceSelection.size() == nbGoodPhoto ) {
						for (URL url : choiceSelection) {
							if(! feutres.isPhotoCorrect(url)) {
								return "Faux réessayer";
							}
								
						}
						return "Bravo !";
					}
					break;
					
				case 2:
					// trouver les numerique
					for (URL url : choiceSelection) {
						if(numerique.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					if (choiceSelection.size() == nbGoodPhoto ) {
						for (URL url : choiceSelection) {
							if(! numerique.isPhotoCorrect(url)) {
								return "Faux réessayer";
							}
								
						}
						return "Bravo !";
					}
					break;
					
				case 3:
					// trouver les peintures
					for (URL url : choiceSelection) {
						if(peinture.isPhotoCorrect(url))
							nbGoodPhoto++;
					}
					
					if (choiceSelection.size() == nbGoodPhoto ) {

						for (URL url : choiceSelection) {
							if(! peinture.isPhotoCorrect(url)) {
								return "Faux réessayer";
							}
								
						}
						System.out.println("true");
						return "Bravo !";
					}
					break;
	
				default:
					return "Faux réessayer";		
				}
				
			}
			return "Faux réessayer";
			
		}
}

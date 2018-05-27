
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.captcha.image;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//interface implémentant les fonctionnalité des images
public interface Images {
	
	
	public List<URL> getPhotos(); //retourne la lists des URL d'un dossier 
		
	public URL getRandomPhotoURL(); //retourne une URL de photo au hasard
	
	public ArrayList<URL> getRandomPhotoUrlList(int nbElmt);//retourne une arrayList d'url de nbElement element
	
	public boolean isPhotoCorrect(URL url);//vérifie si une URL appartient bien au dossier courant
		
}


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
	
	public void addUrl(URL url);
	
	public URL getRandomPhotoURL(); //retourne une URL de photo au hasard
	
	public boolean isPhotoCorrect(URL url);
		
}

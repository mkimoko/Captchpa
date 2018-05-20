/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa;

import java.net.URL;
import java.util.ArrayList;

public interface Image {

	public URL getPhotoURL(int index);//retourne URL d'une photo
	
	public ArrayList<URL> getPhotos(); //retourne les URL de toutes les photos 
	
	public URL getRandomPhotoURL(); // retourne une URL au hasard
	
	public boolean isPhotoCorrect(URL url);
	
}

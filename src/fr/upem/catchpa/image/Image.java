/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa.image;

import java.net.URL;
import java.util.ArrayList;

import fr.upem.catchpa.image.classIMG.Level;

//interface implémentant les fonctionnalité des images
public interface Image {
	
	
	public String getPhoto();//retourne le chemin du fichier image
		
	public Level getLevel();//retourne le niveau de difficulté de l'image

	public ArrayList<String> getPhotos(); //retourne les URL de toutes les photos 
	
	public ArrayList<String> getPhotosOfClass(); //retourne les url des image d'une classIMG
	
	public String getRandomPhotoPath(); // retourne le chemein d'un image au hasard au hasard
	
	public boolean isPhotoCorrect(String path);
	
}

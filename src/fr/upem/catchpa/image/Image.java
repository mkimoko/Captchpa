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
	
	
	public URL getPhoto(); //retourne le chemin du fichier image
		
	public Level getLevel(); //retourne le niveau de difficulté de l'image
	

	
	
	public boolean isPhotoCorrect(String path);
	
}

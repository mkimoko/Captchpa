/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa.image.classIMG;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import fr.upem.catchpa.image.Image;

//Classe représentant l'aspect générique d'une classe d'image
public abstract class ClassIMG implements Image{

	protected int id; //identifiant de l'image
	protected URL photo; //URL de'image
	protected Level level; //niveau de difficulté 
	protected boolean isUsed; //renvoie vrai si photo dans captcha faux sinon
	
	//Constructeur de la classe prend le chemin du fichier ainsi que sont niveau de difficulté
	protected ClassIMG(URL photo, Level level) {
		this.photo = photo;
		this.level = level;
		this.isUsed = false;
	}
	
	//Retourne l'identifiant de l'image
	public int getId() {
		return id;
	}
	
	//retourne le hasCode de l'image
	@Override
	public abstract int hashCode();
	
	//retourne le chemin du fichier image
	public URL getPhoto() {
		return photo;
		
	}

	public boolean isPhotoCorrect(URL path) {
		
		return path.getPath().contains("IMAGES");
	}
	
}

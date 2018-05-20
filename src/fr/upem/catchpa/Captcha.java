/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */
package fr.upem.catchpa;

import java.util.ArrayList;

import fr.upem.catchpa.image.classIMG.ClassIMG;

//Classe représentant le captcha
public class Captcha {

	private ArrayList<ClassIMG> images;//Contient toutes les images de toutes les classes
	
	//Retourne une ArrayList de toutes les images
	public ArrayList<ClassIMG> getImages(){
		return images;
	}
}

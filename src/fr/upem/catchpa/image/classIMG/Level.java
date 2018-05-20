/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */
package fr.upem.catchpa.image.classIMG;

//Enumération représentant le niveau de difficulté de la reconnaissance d'une classe d'image
public enum Level {
	Low, Medium, Hard;
	
	@Override
	public String toString() {
		return name();
	}

}

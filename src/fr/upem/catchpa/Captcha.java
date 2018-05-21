/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */
package fr.upem.catchpa;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import fr.upem.catchpa.image.classIMG.ClassIMG;

//Classe représentant le captcha
public class Captcha {

	private ArrayList<ClassIMG> images;//Contient toutes les images de toutes les classes
	
	
	public Captcha() {
		this.images = new ArrayList<ClassIMG>();
	}
	
	//Retourne une ArrayList de toutes les images
	public ArrayList<ClassIMG> getImages(){
		return images;
	}
	
	
	//retourne les URL de toutes les photos
	public ArrayList<String> getPhotos(){
		
		ArrayList<String> list = new ArrayList<String>();
		return getPhotoOfClass("/home/echoes/eclipse-workspace/Catchpa/IMAGES/", list);
		
	}
	 
	//retourne une arrayList des URL contenues dans un repertoire
	public ArrayList<String> getPathOfRep(String path){
		/**
		 * Si l'objet path n'est pas null, et si il contient des caractères
		 */
			if ( Objects.requireNonNull(path) != null && ! path.isEmpty() ) {
				File repertoire = new File(path); /**On crée un fichier avec l'adresse de path**/ 
				File[] files = repertoire.listFiles();/**On crée des fichier pour ces enfants**/
				ArrayList<String> list = new ArrayList<String>(files.length);
				
				/**Si le fichier est un dossier et qu'il contient des enfants**/
				if (repertoire.isDirectory() && Objects.requireNonNull(files) != null) {
					/**On ajoute leur path à list (une arrayList de string)**/
					for (File f : files) {
						list.add(f.getPath());
					}
				}
				/**On retourne la liste */
				return list;
			}
			return null;
	 }
	
	public ArrayList<String> getPhotoOfClass(String path, ArrayList<String> list){
		
		/**Si l'objet path n'est pas null, et si il contient des caractère**/
		if (Objects.requireNonNull(path) != null && !path.isEmpty() ) {
			File repertoire = new File(path); /**On crée un fichier avec l'adresse de path**/
			File[] files = repertoire.listFiles();/**On crée des fichier pour ces enfants**/
			
			/**Si le fichier n'est pas un dossier**/
			if (! repertoire.isDirectory() ) {
				//On ajoute le path à list
				list.add(repertoire.getPath());
			}
			
			/**Si le fichier est un dossier**/
			if (repertoire.isDirectory() ) {
				//Pour chaque fichier du répertoire
				for ( File newFile : files ) {
					//On applique la méthode getPhotoOfClass()
					getPhotoOfClass(newFile.getPath(), list);
				}
			}
		}
		//On retourne list
		return list;
	}
	 
	
	/**
	 * public String getRandomPhotoPath(); // retourne le chemin d'un image au hasard au hasard
	 */
}
/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.captcha.image.classIMG;

import fr.upem.captcha.image.Images;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class ClassIMG implements Images{
	
	//Constructeur
	protected ClassIMG() {}
	
	//retourne le chemin du fichier image
	public ArrayList<URL> getPhotos() {
		String NameRep = new String(this.getClass().getPackageName());
		NameRep = NameRep.replace(".", "/");
		File repertoire = new File("src/" + NameRep);  
		File[] files = repertoire.listFiles();
		ArrayList<URL> images = new ArrayList<URL>();
		
		if (Objects.Nonnull(files) != null ) {
			for (File f : files) {
				if (! f.getPath().isEmpty() && ! f.isDirectory() && ( f.getPath().contains(".jpg") || f.getPath().contains(".png") ) ) {
					try {
						images.add(f.toURI().toURL());
					} catch (MalformedURLException e) {
						System.out.println("Mauvaise URL");
					}
				}
			}
		}
		
		return images;		
	}

	//retourne une URL de photo au hasard
	public URL getRandomPhotoURL() {
		Random rand = new Random();
		
		return getPhotos().get( rand.nextInt( getPhotos().size() ) ); 
			
	}
	
	public ArrayList<URL> getRandomPhotoUrlList(int nbElmt){
		
		ArrayList<URL> bdd = this.getPhotos();
		ArrayList<URL> result = new ArrayList<URL>();
		URL url;
		int compteur = 0;
		
		while(compteur < nbElmt) {
			url = getRandomPhotoURL();
			if (bdd.contains(url)) {
				result.add(url);
				bdd.remove(url);
				compteur++;
			}	
		}
		return result;
	}
	
	public boolean isPhotoCorrect(URL url) {
		if (Objects.requireNonNull(url) != null) {
			String NameRep = new String(this.getClass().getPackageName());
			NameRep = NameRep.replace(".", "/");
			if (url.getFile().contains(NameRep)) {
				return true;
			}
		}
		return false;
	}
	
	

}

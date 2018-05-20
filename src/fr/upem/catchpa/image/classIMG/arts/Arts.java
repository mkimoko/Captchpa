/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa.image.classIMG.arts;

import java.net.URL;
import java.util.ArrayList;

import fr.upem.catchpa.image.classIMG.*;

//Classe représentant la classe d'image Arts
public abstract class Arts extends ClassIMG {

	protected Arts(URL photo, Level level) {
		super(photo, level);
	}

	@Override
	public URL getPhotoURL(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<URL> getPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getRandomPhotoURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPhotoCorrect(URL url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}

/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */
package fr.upem.catchpa.classe.arts;
import java.net.URL;
import java.util.ArrayList;

import fr.upem.catchpa.classe.Classe;

public class Arts extends Classe{
	
	protected int cleClass;
	
	protected Arts(int cle) {
		super(cle);
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

}

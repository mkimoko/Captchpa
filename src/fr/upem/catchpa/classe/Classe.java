/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa.classe;

import java.net.URL;
import java.util.ArrayList;
import fr.upem.catchpa.Image;

public abstract class Classe implements Image{
	
	public ArrayList<URL> photosList;
	protected int cle;
	
	protected Classe(int cle) {
		this.cle = cle;
	}

}

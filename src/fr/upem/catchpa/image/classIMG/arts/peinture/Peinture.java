/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.catchpa.image.classIMG.arts.peinture;

import java.net.URL;
import java.util.ArrayList;

import fr.upem.catchpa.image.classIMG.Level;
import fr.upem.catchpa.image.classIMG.arts.Arts;

//Classe représentant la classe d'image Peinture (elle appartient à la classe Arts)
public class Peinture extends Arts {

	protected Peinture(URL photo, Level level) {
		super(photo, level);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}


}

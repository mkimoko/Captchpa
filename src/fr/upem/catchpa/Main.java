/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */
package fr.upem.catchpa;

import java.util.ArrayList;

import fr.upem.catchpa.image.classIMG.Level;
import fr.upem.catchpa.image.classIMG.arts.peinture.Peinture;

public class Main {	
	
	public static void main(String[] args) {
		
		Captcha captcha = new Captcha();
		ArrayList<String> list = new ArrayList<String>();
		captcha.getPhotoOfClass("/home/echoes/eclipse-workspace/Catchpa/IMAGES/PEINTURE", list);
		
		captcha.getImages().add( new Peinture("/eclipse-workspace/Catchpa/IMAGES",Level.Low ) );
		System.out.println(list);
		System.out.println(captcha.getImages().get(0).isPhotoCorrect("ce/Catchpa/IMAGES/"));
	}

}

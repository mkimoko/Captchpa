/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.captcha;

import fr.upem.captcha.image.classIMG.numerique.Numerique;
import fr.upem.captcha.image.classIMG.peinture.Peinture;

public class Main {
	
	public static void main(String[] args) {
	
		/*Peinture p = new Peinture();
		Numerique n = new Numerique();
		System.out.println(n.getPhotos().get(1));
		System.out.println(p.isPhotoCorrect(n.getPhotos().get(0)));;*/
		
		/*CaptchManager manager = new CaptchManager();
		System.out.println(manager.shakeSelection());*/
		
		CaptchaInterface window = new CaptchaInterface();
		window.showElmt();
	}

}

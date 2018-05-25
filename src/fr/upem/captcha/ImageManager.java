package fr.upem.captcha;

import fr.upem.captcha.image.classIMG.feutres.Feutres;
import fr.upem.captcha.image.classIMG.numerique.Numerique;
import fr.upem.captcha.image.classIMG.peinture.Peinture;

public class ImageManager {
	
	private Feutres feutres;
	private Numerique numerique;
	private Peinture peinture;
	
	public ImageManager() {
		this.feutres = new Feutres();
		this.numerique = new Numerique();
		this.peinture = new Peinture();
	}

}

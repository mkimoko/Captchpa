package fr.upem.captcha;

import fr.upem.captcha.image.classIMG.peinture.Peinture;

public class Main {
	
	public static void main(String[] args) {
	
		Peinture p = new Peinture();
		System.out.println(p.getPhotos());
		p.isPhotoCorrect(p.getRandomPhotoURL());
	}

}

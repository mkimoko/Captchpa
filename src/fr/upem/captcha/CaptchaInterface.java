/**
 * 
 */
/**
 * @author Mathieu KIMOKO & Quentin LOUIS
 *
 */

package fr.upem.captcha;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CaptchaInterface {
	private static ArrayList<URL> selectedImages = new ArrayList<URL>();
	private CaptchaManager manager;
	
	public CaptchaInterface() {
		this.manager = new CaptchaManager();
	}
	
	//Crée une fenetre
	public JFrame createWindow() {
		JFrame frame = new JFrame("Captcha");
		
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);//placement au centre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ferme le processus à fermeture de la fenetre
		
		return frame;
	}
	
	//affiche les elements et leur donne un comportenemt
	public void showElmt() {
		JFrame frame = createWindow();
		frame.setLayout(new GridLayout(4,3));//on donne un layout à la fanetre
		
		final ArrayList<URL> urlList = manager.shakeSelection();//On crée la liste aléatoire d'URL
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>(urlList.size());
		ArrayList<Image> sImages = new ArrayList<Image>(urlList.size());
		ArrayList<JLabel> tmpLabels = new ArrayList<JLabel>(urlList.size());
		int urlCompteur = 0;
		int choice = manager.typeChoice();
		
		
		for (int i = 0; i < urlList.size(); i++) {
			try {
				images.add( ImageIO.read( urlList.get(i) ) );
			} catch (IOException e) {
				System.out.println("Image non lu");
			}
			sImages.add(images.get(i).getScaledInstance(800/3, 800/4, Image.SCALE_SMOOTH));
			tmpLabels.add(new JLabel(new ImageIcon(sImages.get(i))));
		}
		
		final ArrayList<JLabel> labels = tmpLabels;
		for (JLabel jLabel : labels) {
			jLabel.addMouseListener(new MouseListener() {
				private boolean isSelected = false;
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					EventQueue.invokeLater(new Runnable() {

						@Override
						public void run() {
							if(!isSelected) {
								jLabel.setBorder(BorderFactory.createLineBorder(Color.RED,3));
								isSelected = true;
								selectedImages.add(urlList.get(tmpLabels.indexOf(jLabel)));
							}
							else {
								jLabel.setBorder(BorderFactory.createEmptyBorder());
								isSelected = false;
								selectedImages.remove(urlList.get(tmpLabels.indexOf(jLabel)));
							}
							
						}
						
					});
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		urlCompteur++;
		
		JButton button = new JButton(new AbstractAction("OK !") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					
					//Comportement lorsque l'on apuie sur Ok
					@Override
					public void run() {
						//crée un String avec le résultat de notre vérification
						String result = manager.choice(choice, selectedImages);
						frame.add(new JTextArea(result));
						JFrame secondFrame = frame;
						
						secondFrame.setVisible(true);
						return;
						
					}
				} ); 
			}
		});
		
		for (JLabel jLabel : labels) {
			frame.add(jLabel);
		}
		frame.add(new JTextArea(manager.text(choice)));
		frame.add(button);
		frame.setVisible(true);
	}
	
}

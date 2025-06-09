package utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Icons {
	public static ImageIcon getEditIcon() {
		ImageIcon image = new ImageIcon("D:\\Proyectos\\Java\\dpoo-final-project\\icons\\edit.png");
		Image scaledImage = image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

		return new ImageIcon(scaledImage);
	}
	
	public static ImageIcon getCloseIcon() {
		ImageIcon image = new ImageIcon("D:\\Proyectos\\Java\\dpoo-final-project\\icons\\close-x.png");
		Image scaledImage = image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
	
	public static ImageIcon getRemoveIcon() {
		ImageIcon image = new ImageIcon("D:\\Proyectos\\Java\\dpoo-final-project\\icons\\trash.png");
		Image scaledImage = image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
	
	public static ImageIcon getRegisterIcon() {
		ImageIcon image = new ImageIcon("D:\\Proyectos\\Java\\dpoo-final-project\\icons\\register.png");
		Image scaledImage = image.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		return new ImageIcon(scaledImage);
	}
}

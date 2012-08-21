package imageCreator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;

import extras.Debugger;

public class TransparencyChecker {
	private Debugger debugger = Debugger.getInstance();

	public boolean checkForTransparency(Image selectedImage) {
		if(selectedImage instanceof BufferedImage)
			return ((BufferedImage)(selectedImage)).getColorModel().hasAlpha();
		
		PixelGrabber pg = new PixelGrabber(selectedImage, 0, 0, 1, 1, false);
	
		try {
			pg.grabPixels();
		} catch (InterruptedException e) {
			debugger.showOnConsole("Error in grabbing pixels in checking the transparency.");
			//e.printStackTrace();
		}
		
		ColorModel cm = pg.getColorModel();
		return cm.hasAlpha();
	}
}

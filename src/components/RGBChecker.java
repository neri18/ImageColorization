package components;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import extras.Debugger;

public class RGBChecker {
	
	public RGBChecker(){}
	
	public boolean isRGB(File selectedFile){
		try {
			BufferedImage bimage = ImageIO.read(selectedFile);
			
			for(int x=0; x<bimage.getWidth(); x++){
				for(int y=0; y<bimage.getHeight(); y++){
					int RGB = bimage.getRGB(x, y);
					
					int red = (RGB & 0x00FF0000) >> 16;
					int green = (RGB & 0x0000FF00) >> 8;
					int blue = (RGB & 0x000000FF);
					
					if((red == green) && (green == blue))
						continue;
					else
						return true;
					
				}
			}
		} catch (IOException e) {
			Debugger.getInstance().showOnConsole("Error during rgbchecker");
		//	e.printStackTrace();
		}
		return false;
	}
}

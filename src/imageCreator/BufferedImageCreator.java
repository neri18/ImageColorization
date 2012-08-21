package imageCreator;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class BufferedImageCreator {
	private TransparencyChecker transparencyChecker = new TransparencyChecker();
	
	public BufferedImage createBufferedImage(Image selectedImage){
		boolean imageTransparent = transparencyChecker.checkForTransparency(selectedImage);
		int imagetype;
		
		if(imageTransparent)
			imagetype = BufferedImage.TYPE_INT_RGB;
		else
			imagetype = BufferedImage.TYPE_INT_ARGB;
		
		BufferedImage bImage = new BufferedImage(selectedImage.getWidth(null), selectedImage.getHeight(null), imagetype);
		
		Graphics g = bImage.getGraphics();
		g.drawImage(selectedImage, 0, 0, null);
		g.dispose();
		
		return bImage;
	}
	
	/*
	private BufferedImage createBufferedImage(Image selectedImage) {
		boolean hasAlpha;
		int imageTransparency;
		int imagetype;
		BufferedImage bimage = null;
		GraphicsEnvironment graphicsEnvi;
		GraphicsDevice graphicsDevice;
		GraphicsConfiguration graphicsConf;
		
		
		if(selectedImage instanceof BufferedImage){
			System.out.println("selectedImage insatnce of BufferedImage");
			return (BufferedImage) selectedImage;
		}
		
		selectedImage = new ImageIcon(selectedImage).getImage();
		hasAlpha = checkForTransparency(selectedImage);
		graphicsEnvi = GraphicsEnvironment.getLocalGraphicsEnvironment();
	
		try{
			if(hasAlpha)
				imageTransparency = Transparency.BITMASK;
			else
				imageTransparency = Transparency.OPAQUE;
			
			debugger.showOnConsole("imageTransparency:"+ imageTransparency);
			graphicsDevice = graphicsEnvi.getDefaultScreenDevice();
			graphicsConf = graphicsDevice.getDefaultConfiguration();
			
			bimage = graphicsConf.createCompatibleImage(selectedImage.getWidth(null), selectedImage.getHeight(null), imageTransparency);
		
		}catch(HeadlessException ex){
			debugger.showOnConsole("The system does not gave a screen.");
		}
		
		if(bimage == null){
			debugger.showOnConsole("bimage is null");
			if( hasAlpha )
				imagetype = BufferedImage.TYPE_INT_RGB;
			else
				imagetype = BufferedImage.TYPE_INT_ARGB;
			
			debugger.showOnConsole("imagType:"+imagetype);
			
			bimage = new BufferedImage(selectedImage.getWidth(null), selectedImage.getHeight(null), imagetype);
		}
		
		Graphics g = bimage.getGraphics();
		g.drawImage(selectedImage, 0, 0, null);
		g.dispose();
		
		return bimage;
	}
	*/
}

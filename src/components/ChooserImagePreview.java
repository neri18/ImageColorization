package components;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class ChooserImagePreview extends JPanel{
	
	private int previewWidth = 175;
	private int previewHeight = 175;
	
	private Image sourceImage;
	private Image scaledImage;
	
	public ChooserImagePreview(){
		setConfig();
	}
	
	private void setConfig() {
		this.setPreferredSize(new Dimension(previewWidth, previewHeight));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Image Preview", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tempus Sans ITC", Font.PLAIN, 15), null));
	}

	public void setImage(Image image){
		sourceImage = image;
		scaledImage = null; 
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		if( g != null){
			Graphics graphics = g.create();
			graphics.setColor(getBackground());
			graphics.fillRect(0, 0, getWidth(), getHeight());
			
			if(sourceImage != null){
				rescaleSourceImage();
				graphics.drawImage(scaledImage, getWidth()/2 - scaledImage.getWidth(this)/2, getHeight()/2 - scaledImage.getHeight(this)/2, this);
			}
		}
		
	}
	
	private void rescaleSourceImage(){
		int imageWidth = sourceImage.getWidth(this);
		int imageHeight = sourceImage.getHeight(this);
		
		int panelWidth = getWidth();
		int panelHeight = getHeight();
		
		int scaledWidth = 0;
		int scaledHeight = 0;
		
		double ratio = 1.0;
		
		if( (0.95 * panelWidth / imageWidth) < (0.95 * panelHeight / imageHeight) ){
			ratio = 0.95 * panelWidth / imageWidth;
		}
		else{
			ratio = 0.95 * panelHeight / imageHeight;
		}
		
		scaledWidth = (int)(imageWidth * ratio);
		scaledHeight = (int)(imageHeight * ratio);
		
		if (scaledImage == null){
			scaledImage = sourceImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_DEFAULT);
		}
	}
	
	public boolean typeAllowed(String filename) {
		if( filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".png") || filename.toLowerCase().endsWith(".jpeg") || filename.toLowerCase().endsWith(".gif"))
			return true;
		return false;
	}

}

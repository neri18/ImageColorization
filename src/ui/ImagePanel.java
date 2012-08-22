package ui;

import imageCreator.BufferedImageCreator;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import components.RGBChecker;

public class ImagePanel extends JPanel{
	
	private static ImagePanel instance;
	
	private int panelWidth = 470;
	private int panelHeight = 510;
	
	private BufferedImage bufferedImage = null;
	
	public static ImagePanel getInstance(){
		if(instance == null) instance = new ImagePanel();
		return instance;
	}
	
	private ImagePanel(){
		setConfig();
	}

	private void setConfig() {
		setSize(panelWidth, panelHeight);
		
		//setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	public void addImageToPanel(BufferedImage bufferedImage){
		this.bufferedImage = bufferedImage;
		//setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
		repaint();
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bufferedImage, 0, 0, null);
	}
}

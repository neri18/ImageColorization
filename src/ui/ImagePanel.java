package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	private static ImagePanel instance;
	
	private int panelWidth = 470;
	private int panelHeight = 510;
	
	private int latestX = 0;
	private int latestY = 0;
	private int currentX = 0;
	private int currentY = 0;
	
	private BufferedImage bufferedImage = null;
	
	private Graphics biGraphics;
	
	public static ImagePanel getInstance(){
		if(instance == null) instance = new ImagePanel();
		return instance;
	}
	
	private ImagePanel(){
		setConfig();
		addListeners();
	}

	private void addListeners() {
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(bufferedImage!=null && arg0.getX()<=bufferedImage.getWidth() && arg0.getY()<=bufferedImage.getHeight()){
					latestX = arg0.getX();
					latestY = arg0.getY();
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(bufferedImage!=null && e.getX()<=bufferedImage.getWidth() && e.getY()<=bufferedImage.getHeight()){
					currentX = e.getX();
					currentY = e.getY();
					
					biGraphics.setColor(ColorSelectionPanel.getInstance().getColorChooser().getSelectedColor());
					biGraphics.drawLine(latestX, latestY, currentX, currentY);
					
					latestX = currentX;
					latestY = currentY;
					
					repaint();
				}
			}
		});
	}

	private void setConfig() {
		setSize(panelWidth, panelHeight);
	}
	
	public void addImageToPanel(BufferedImage bImage){
		this.bufferedImage = bImage;
		
		biGraphics = bufferedImage.getGraphics();
		//setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
		repaint();
		
		this.grabFocus();
	
		
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bufferedImage, 0, 0, null);
	}

}

package extras;

//scribble.java
//
//Author: Brian Johnson
//Modified by  on 5/4/08.
//A simple Java applet using buttons in the default (flow) layout

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.applet.*;

public class scribble extends Applet implements  ActionListener,MouseListener,MouseMotionListener{

//	Variables to hold Applet parameters

	private int lastx,lasty,x,y;              // Mouse-event x,y and previous event x,y
	private Color curColor;                   // current foreground color
	Button erase_button;                      // Buttons for the User Interface (UI)
	Button button1, button2, button3, button4;
	BufferedImage bi;                         // Off-screen graphic to draw into
	Graphics myG;                             // ... and associated graphics environment.

	// Initialize the applet
	public void init() {
		resize(400,400);
		addMouseListener(this);                 // Add listeners for mouse events
		addMouseMotionListener(this);

		erase_button = new Button("Erase");     // Make buttons, linked to "ActionPerformed"
		erase_button.addActionListener(this);   // and then add them to the (default) Layout
		this.add(erase_button);

		button1 = new Button("Black");
		button1.addActionListener(this);
		this.add(button1);

		button2 = new Button("Red");
		button2.addActionListener(this);
		this.add(button2);

		button3 = new Button("Green");
		button3.addActionListener(this);
		this.add(button3);

		button4 = new Button("Blue");
		button4.addActionListener(this);
		this.add(button4);

//The real drawing will occur in a buffer, which 'paint' will transfer to the screen as
//needed, so define a "buffered image" to receive the graphics, and a graphics environment
//(myG) to hold the rest of the graphics info, then initialize all of it.
		
		bi = new BufferedImage(getSize().width,getSize().height,BufferedImage.TYPE_INT_RGB);
		myG = bi.createGraphics();
		this.setBackground(Color.WHITE);
		myG.setColor(this.getBackground());
		myG.fillRect(0,0,getSize().width,getSize().height);
		myG.setColor(Color.BLACK);
		curColor=Color.BLACK;

//The "requestFocus" call activates the applet so we don't have to click on it before drawing		
		this.requestFocus();
		repaint();
	}

	public void paint( Graphics g ){
		super.paintComponents(g);
		g.drawImage( bi,0, 0,null );

	}
//---------------------------------------------- Handle all button clicks here ---
//"e.getSource()" returns the object (button) on which the user clicked, so check it against
//the defined buttons until we find a match, then do the appropriate thing (mostly, set the
//drawing color).
	
	public void actionPerformed(ActionEvent e){

		if (e.getSource()==erase_button){
			curColor=myG.getColor();
			myG.setColor(this.getBackground());
			myG.fillRect(0,0,getSize().width,getSize().height);
			myG.setColor(curColor);
			repaint();
		}
		else if (e.getSource()==button1){
			myG.setColor(Color.BLACK);
		}
		else if (e.getSource()==button2){
			myG.setColor(Color.RED);
		}
		else if (e.getSource()==button3){
			myG.setColor(Color.GREEN);
		}
		else if (e.getSource()==button4){
			myG.setColor(Color.BLUE);
		}
	}

//---------------------------------------------- Handle the mouse events here ---

	public void mousePressed(MouseEvent e) {
		lastx=e.getX(); 
		lasty=e.getY();
	}

	public void mouseDragged(MouseEvent e) {
		x=e.getX(); 
		y=e.getY();
		myG.drawLine(lastx,lasty, x,y);
		lastx=x;
		lasty=y;
		repaint();	
	}

	public void mouseClicked(MouseEvent arg0) {	}
	public void mouseEntered(MouseEvent arg0) {	
		System.out.println("aadi");
	}
	public void mouseExited(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
	public void mouseMoved(MouseEvent arg0) { }

}
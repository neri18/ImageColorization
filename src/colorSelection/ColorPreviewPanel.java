package colorSelection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPreviewPanel extends JPanel{
//
//	Color currentColor;
//
//    public ColorPreviewPanel(JColorChooser chooser) {
//        // Initialize the currently selected color
//        currentColor = chooser.getColor();
//
//  /*      // Add listener on model to detect changes to selected color
//        ColorSelectionModel model = chooser.getSelectionModel();
//        	model.addChangeListener(new ChangeListener() {
//				
//				@Override
//				public void stateChanged(ChangeEvent e) {
//					ColorSelectionModel model = (ColorSelectionModel)e.getSource();
//	                // Get the new color value
//	                currentColor = model.getSelectedColor();
//				}
//			});
//
//        // Set a preferred size
//         * 
//         */
//        setPreferredSize(new Dimension(50, 50));
//    }
//
//    // Paint current color
//    public void paint(Graphics g) {
//        g.setColor(currentColor);
//        g.fillRect(0, 0, getWidth()-1, getHeight()-1);
//    }
	
	public ColorPreviewPanel(){
		setConfig();
	}

	private void setConfig() {
		setSize(new Dimension(50, 50));
	}
}

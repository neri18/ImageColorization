package colorSelection;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.ColorModel;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ui.ColorSelectionPanel;

public class ColorChooser extends JColorChooser implements ChangeListener{

	private ColorSelectionModel colorModel;
	private Color selectedColor;
	
	public ColorChooser(){
		createComponenets();
		setConfig();
	}

	private void createComponenets() {
		colorModel = this.getSelectionModel();
		colorModel.addChangeListener(this);
	}
	
	private void setConfig() {
	    this.setPreviewPanel(new JPanel());
	}
	
	public void stateChanged(ChangeEvent e) {
		selectedColor = this.getColor();
		ColorSelectionPanel.getInstance().getColorPreviewPanel().setColorLabelBGColor(selectedColor);
	}
	
	public boolean noSelectedColor(){
		if( selectedColor == null )
			return true;
		return false;
	}
}

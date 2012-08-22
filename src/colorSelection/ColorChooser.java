package colorSelection;

import java.awt.Color;
import java.awt.image.ColorModel;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser extends JColorChooser implements ChangeListener{

	private ColorSelectionModel colorModel;
	private Color selectedColor;
	
	public ColorChooser(){
		setConfig();
		createComponenets();
	}

	private void createComponenets() {
		colorModel = this.getSelectionModel();
		colorModel.addChangeListener(this);
	}
	
	private void setConfig() {
		//add some setting configuration
		this.setPreviewPanel(new JLabel("Hello"));
	
	}
	
	public void stateChanged(ChangeEvent e) {
		setSelectedColor(this.getColor());
	}

	private void setSelectedColor(Color color) {
		selectedColor = color;
	}
	
	public Color getSelectedColor(){
		return selectedColor;
	}
	
}

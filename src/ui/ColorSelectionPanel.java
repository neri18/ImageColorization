package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import colorSelection.ColorChooser;

public class ColorSelectionPanel extends JPanel{

	private static ColorSelectionPanel instance;
	private ColorChooser colorChooser;
	
	private final int panelWidth = 400;
	private final int panelHeight = 300;
	
	public static ColorSelectionPanel getInstance(){
		if(instance == null) instance = new ColorSelectionPanel();
		return instance;
	}
	
	private ColorSelectionPanel(){
		setConfig();
		createComponents();
	}
	
	private void createComponents() {
		setLayout(new BorderLayout(0, 0));
		colorChooser = new ColorChooser();
		this.add(colorChooser, BorderLayout.CENTER);
	}

	private void setConfig(){
		this.setSize(new Dimension(435, 295));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Color Selection", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		
	}
}

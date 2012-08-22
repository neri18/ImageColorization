package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import colorSelection.ColorChooser;
import colorSelection.ColorPreviewPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class ColorSelectionPanel extends JComponent{

	private static ColorSelectionPanel instance;
	private ColorChooser colorChooser;
	private ColorPreviewPanel colorPreviewPanel;
	
	private final int panelWidth = 435;
	private final int panelHeight = 350;
	
	public static ColorSelectionPanel getInstance(){
		if(instance == null) instance = new ColorSelectionPanel();
		return instance;
	}
	
	private ColorSelectionPanel(){
		setConfig();
		createComponents();
	}
	
	private void createComponents() {
		colorChooser = new ColorChooser();
		colorChooser.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.add(colorChooser, BorderLayout.CENTER);
		
		colorPreviewPanel = new ColorPreviewPanel();
		this.add(colorPreviewPanel, BorderLayout.SOUTH);
	}

	private void setConfig(){
		this.setSize(new Dimension(435, 315));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Color Selection", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		this.setLayout(new BorderLayout(0, 0));
	}
	
	public ColorPreviewPanel getColorPreviewPanel(){
		return colorPreviewPanel;
	}
}

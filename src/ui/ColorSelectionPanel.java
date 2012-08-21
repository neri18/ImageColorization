package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ColorSelectionPanel extends JPanel{

	private static ColorSelectionPanel instance;
	
	private final int panelWidth = 290;
	private final int panelHeight = 270;
	
	public static ColorSelectionPanel getInstance(){
		if(instance == null) instance = new ColorSelectionPanel();
		return instance;
	}
	
	private ColorSelectionPanel(){
		setConfig();
	}
	
	private void setConfig(){
		this.setSize(new Dimension(panelWidth, panelHeight));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Color Selection", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
	}
}

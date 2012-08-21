package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ProcessPanel extends JPanel{

	private static ProcessPanel instance;
	
	private final int panelWidth = 290;
	private final int panelHeight = 265;
	
	public static ProcessPanel getInstance(){
		if(instance == null) instance = new ProcessPanel();
		return instance;
	}
	
	private ProcessPanel(){
		setConfig();
	}
	
	private void setConfig(){
		this.setSize(new Dimension(panelWidth, panelHeight));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Process", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
	}
}

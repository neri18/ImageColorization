package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProcessPanel extends JPanel{

	private static ProcessPanel instance;
	
	private final int panelWidth = 435;
	private final int panelHeight = 225;
	private JButton clearScribblesButton;
	private JButton colorizeButton;
	
	public static ProcessPanel getInstance(){
		if(instance == null) instance = new ProcessPanel();
		return instance;
	}
	
	private ProcessPanel(){
		setConfig();
		createComponents();
	}
	
	private void createComponents() {
		clearScribblesButton = new JButton(" Clear Scribbles");
		clearScribblesButton.setFont(new Font("Rockwell", Font.BOLD, 13));
		clearScribblesButton.setBounds(45, 75, 150, 40);
		this.add(clearScribblesButton);
		
		colorizeButton = new JButton("Colorize Image");
		colorizeButton.setFont(new Font("Rockwell", Font.BOLD, 13));
		colorizeButton.setBounds(245, 75, 150, 40);
		this.add(colorizeButton);
	}

	private void setConfig(){
		this.setSize(new Dimension(panelWidth, panelHeight));
		this.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Process", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		this.setLayout(null);
	}
}

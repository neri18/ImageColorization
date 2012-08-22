package colorSelection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;

public class ColorPreviewPanel extends JPanel{

	private int panelWidth = 420;
	private int panelHeight = 40;
	private JLabel textLabel;
	private JLabel colorLabel;
	private JLabel colorNumberLabel;

	public ColorPreviewPanel(){
		setConfig();
		createComponents();
	}

	private void createComponents() {
		textLabel = new JLabel("Current Selected Color:");
		textLabel.setFont(new Font("Rockwell", Font.PLAIN, 13));
		textLabel.setBounds(20, 5, 150, 30);
		add(textLabel);
		
		colorLabel = new JLabel("N/A");
		colorLabel.setOpaque(true);
		colorLabel.setBackground(this.getBackground());
		colorLabel.setFont(new Font("Rockwell", Font.PLAIN, 11));
		colorLabel.setBounds(195, 5, 75, 30);
		add(colorLabel);
		
		colorNumberLabel = new JLabel("");
		colorNumberLabel.setFont(new Font("Rockwell", Font.PLAIN, 11));
		colorNumberLabel.setBounds(280, 5, 130, 30);
		add(colorNumberLabel);
	}

	private void setConfig() {
		this.setPreferredSize(new Dimension(panelWidth, panelHeight));
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(null);
	}
	
	public void setColorLabelBGColor(Color color){
		colorLabel.setText("");
		colorLabel.setBackground(color);
		colorNumberLabel.setText("r:"+color.getRed()+"  g:"+color.getGreen()+"  b:"+color.getBlue());
	}
}

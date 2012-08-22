package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends JFrame{

	private static MainFrame instance;
	
	private JPanel contentPanel;
	
	private int frameWidth = 930;
	private int frameHeight = 600;

	private MenuSelectionBar menuBar;
	
	private JPanel imagePanelHolder;
	private ImagePanel imagePanel;
	private ColorSelectionPanel colorPanel;
	private ProcessPanel processPanel;
	
	public static MainFrame getInstance(){
		if( instance == null )	instance = new MainFrame();
		return instance;
	}
	
	private MainFrame(){
		setConfig();
		createComponents();
	}

	private void setConfig() {
		this.setTitle("Still Image Colorization");
		this.setSize(new Dimension(frameWidth, frameHeight));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void createComponents() {
		createContentPanel();
		createMenuBar();
		createImagePanel();
		createColorPanel();
	//	createProcessPanel();
	}

	private void createContentPanel() {
		contentPanel = new JPanel();
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);
	}

	private void createMenuBar() {
		menuBar = MenuSelectionBar.getInstance();
		this.setJMenuBar(menuBar);	
	}
	
	private void createImagePanel() {
		imagePanelHolder = new JPanel();
		imagePanelHolder.setBounds(5, 0, 480, 540);
		imagePanelHolder.setLayout(null);
		imagePanelHolder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		
		imagePanel = ImagePanel.getInstance();
		imagePanel.setBounds(5, 20, imagePanel.getWidth(), imagePanel.getHeight());
		imagePanelHolder.add(imagePanel);
		
		contentPanel.add(imagePanelHolder);
		
	}
	
	private void createColorPanel() {
		colorPanel = ColorSelectionPanel.getInstance();
		colorPanel.setBounds(485, 0, colorPanel.getWidth(), colorPanel.getHeight());
		contentPanel.add(colorPanel);
	}

	private void createProcessPanel() {
		processPanel = ProcessPanel.getInstance();
		processPanel.setBounds(495, 275, processPanel.getWidth(), processPanel.getHeight());
		contentPanel.add(processPanel);
	}
	
}

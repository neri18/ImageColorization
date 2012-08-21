package ui;

import imageCreator.BufferedImageCreator;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import components.FileChooser;

import extras.Debugger;

public class MenuSelectionBar extends JMenuBar{

	private static MenuSelectionBar instance;

	private JMenuItem openMItem;
	private JMenuItem exitMItem;
	private JMenu helpMenu;
	private JMenuItem helpMItem;
	private JMenuItem aboutMItem;
	private JMenu fileMenu;

	private Debugger debugger;
	
	private BufferedImage bufferedImage;
	
	private MenuSelectionBar(){
		createComponents();
		addListeners();
	}
	
	public static MenuSelectionBar getInstance(){
		if(instance == null) instance = new MenuSelectionBar();
		return instance;
	}
	
	private void createComponents() {
		createExtras();
		
		createFileMenu();
		createHelpMenu();
	}

	private void createExtras() {
		debugger = Debugger.getInstance();
	}

	private void createFileMenu() {
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		this.add(fileMenu);
		
		openMItem = new JMenuItem("Open Image");
		openMItem.setMnemonic(KeyEvent.VK_O);
		openMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,java.awt.Event.CTRL_MASK));
		fileMenu.add(openMItem);
		
		exitMItem = new JMenuItem("Exit");
		exitMItem.setMnemonic(KeyEvent.VK_X);
		exitMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,java.awt.Event.CTRL_MASK));
		fileMenu.add(exitMItem);
	}

	private void createHelpMenu() {
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		this.add(helpMenu);
		
		helpMItem = new JMenuItem("Help Contents");
		helpMItem.setMnemonic(KeyEvent.VK_C);
		helpMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,java.awt.Event.CTRL_MASK));
		helpMenu.add(helpMItem);
		
		aboutMItem = new JMenuItem("About");
		aboutMItem.setMnemonic(KeyEvent.VK_A);
		aboutMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,java.awt.Event.CTRL_MASK));
		helpMenu.add(aboutMItem);
	}
	
	private void addListeners() {
		openMItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileChooser chooser = new FileChooser();
				int filetype = chooser.showOpenDialog(MainFrame.getInstance());
				
				if(filetype == FileChooser.APPROVE_OPTION){
					debugger.showOnConsole("Selected file is an Image(.jpg/.png) : filename ='"+ chooser.getSelectedFile().getName() +"'");
					
					File selectedFile = chooser.getSelectedFile();
					uploadImage(selectedFile);
				}
				else{
					debugger.showOnConsole("Cancelled Image Selection.");
				}
			}
		});
		
		exitMItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void uploadImage(File selectedFile) {
		try {
			Image selectedImage =  ImageIO.read(selectedFile);
			
			BufferedImageCreator bimageCreator = new BufferedImageCreator();
			bufferedImage = bimageCreator.createBufferedImage(selectedImage);
			
			ImagePanel imagePanel = ImagePanel.getInstance();
			imagePanel.addImageToPanel(bufferedImage);
			//imageLabel.setIcon(new ImageIcon(bufferedImage));
		
		} catch (IOException e) {
			debugger.showOnConsole("Error in setting up the selectedImage.");
			//e.printStackTrace();
		}
	}

	
	
}

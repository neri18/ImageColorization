package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import components.FileChooser;
import extras.Debugger;

public class MainFrame extends JFrame{

	private static MainFrame instance;
	
	private Debugger debugger;
	
	private JPanel contentPanel;
	
	private int frameWidth = 800;
	private int frameHeight = 600;

	private JMenuBar menuBar;
	private JMenuItem openMItem;
	private JMenuItem exitMItem;
	private JMenu helpMenu;
	private JMenuItem helpMItem;
	private JMenuItem aboutMItem;
	private JMenu fileMenu;
	private JPanel imagePanel;
	
	private JLabel imageLabel;
	private JPanel colorPanel;
	private JPanel processPanel;
	
	private BufferedImage bufferedImage;
	
	public static MainFrame getInstance(){
		if( instance == null )	instance = new MainFrame();
		return instance;
	}
	
	private MainFrame(){
		setConfig();
		createComponents();
		addComponentListeners();
	}

	private void setConfig() {
		this.setTitle("Still Image Colorization");
		this.setSize(new Dimension(frameWidth, frameHeight));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	private void createComponents() {
		
		createExtras();
		
		createContentPanel();
		createMenuBar();
		createImagePanel();
		createColorPanel();
		createProcessPanel();
	}

	private void createExtras() {
		debugger = Debugger.getInstance();
	}

	private void createContentPanel() {
		contentPanel = new JPanel();
		this.setContentPane(contentPanel);
		contentPanel.setLayout(null);
	}

	private void createMenuBar() {
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		createFileMenu();
		createHelpMenu();
	}

	private void createFileMenu() {
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
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
		menuBar.add(helpMenu);
		
		helpMItem = new JMenuItem("Help Contents");
		helpMItem.setMnemonic(KeyEvent.VK_C);
		helpMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,java.awt.Event.CTRL_MASK));
		helpMenu.add(helpMItem);
		
		aboutMItem = new JMenuItem("About");
		aboutMItem.setMnemonic(KeyEvent.VK_A);
		aboutMItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,java.awt.Event.CTRL_MASK));
		helpMenu.add(aboutMItem);
	}
	
	private void createImagePanel() {
		imagePanel = new JPanel();
		imagePanel.setBounds(5, 0, 475, 540);
		imagePanel.setMaximumSize(new Dimension(400, 400));
		imagePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Image", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		imagePanel.setPreferredSize(new Dimension(400, 400));
		contentPanel.add(imagePanel);
		imagePanel.setLayout(new BorderLayout(0, 0));
		
		imageLabel = new JLabel("");
		imagePanel.add(imageLabel, BorderLayout.CENTER);
	}
	
	private void createColorPanel() {
		colorPanel = new JPanel();
		colorPanel.setBounds(495, 0, 290, 270);
		colorPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Color Selection", TitledBorder.LEADING, TitledBorder.TOP, new Font("Segoe UI", Font.BOLD, 15), null));
		contentPanel.add(colorPanel);
	}

	private void createProcessPanel() {
		processPanel = new JPanel();
		processPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		processPanel.setBounds(495, 280, 290, 260);
		contentPanel.add(processPanel);
	}


	private void addComponentListeners() {
		openMItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileChooser chooser = new FileChooser();
				int filetype = chooser.showOpenDialog(MainFrame.this);
				
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
			bufferedImage = createBufferedImage(selectedImage);
			
			//imageLabel.setIcon(new ImageIcon(selectedImage));
		} catch (IOException e) {
			debugger.showOnConsole("Error in setting up the selectedImage.");
			//e.printStackTrace();
		}
			
			
			
	}

	private BufferedImage createBufferedImage(Image selectedImage) {
		
		if(selectedImage instanceof BufferedImage){
			return (BufferedImage) selectedImage;
		}
		
		selectedImage = new ImageIcon(selectedImage).getImage();
		
		
		/*
		 * // This method returns a buffered image with the contents of an image
public static BufferedImage toBufferedImage(Image image) {
    if (image instanceof BufferedImage) {
        return (BufferedImage)image;
    }

    // This code ensures that all the pixels in the image are loaded
    image = new ImageIcon(image).getImage();

    // Determine if the image has transparent pixels; for this method's
    // implementation, see Determining If an Image Has Transparent Pixels
    boolean hasAlpha = hasAlpha(image);

    // Create a buffered image with a format that's compatible with the screen
    BufferedImage bimage = null;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {
        // Determine the type of transparency of the new buffered image
        int transparency = Transparency.OPAQUE;
        if (hasAlpha) {
            transparency = Transparency.BITMASK;
        }

        // Create the buffered image
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        bimage = gc.createCompatibleImage(
            image.getWidth(null), image.getHeight(null), transparency);
    } catch (HeadlessException e) {
        // The system does not have a screen
    }

    if (bimage == null) {
        // Create a buffered image using the default color model
        int type = BufferedImage.TYPE_INT_RGB;
        if (hasAlpha) {
            type = BufferedImage.TYPE_INT_ARGB;
        }
        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    }

    // Copy image to buffered image
    Graphics g = bimage.createGraphics();

    // Paint the image onto the buffered image
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bimage;
}
		 */
		return null;
	}
}

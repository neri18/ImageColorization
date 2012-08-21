package components;

import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class FileChooser extends JFileChooser{
	
	private ChooserImagePreview preview;

	public FileChooser(){
		addPreviewPanel();
		setConfig();
		addListeners();
	}

	private void addPreviewPanel() {
		preview = new ChooserImagePreview();
		this.setAccessory(preview);
	}

	private void addListeners() {
		this.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				String propertyName = arg0.getPropertyName();
				
				if(propertyName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)){
					File selectedFile = (File)arg0.getNewValue();
					String fileName;
					
					if(selectedFile == null)
						return;
					else
						fileName = selectedFile.getAbsolutePath();
					
					if((fileName != null) && preview.typeAllowed(fileName)){
						ImageIcon icon = new ImageIcon(fileName);					
	                    Image newImage = icon.getImage();
	                    preview.setImage (newImage);
					}
					else{
						preview.setImage(null);
					}
				}
			}
		});
	}


	private void setConfig() {
		this.setDialogTitle("Open Image");
		this.setFileSelectionMode(JFileChooser.FILES_ONLY);
		this.setAcceptAllFileFilterUsed(false);
		this.setFileFilter(new ImageFilter());
	}

}

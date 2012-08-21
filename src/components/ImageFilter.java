package components;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ImageFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		if(f.isDirectory())
			return true;
		
		String extension = Utils.getExtension(f);
		if(extension != null && typeAllowed(extension))
			return true;
		
		return false;
	}

	private boolean typeAllowed(String extension) {
		if(extension.equals(Utils.jpeg) || extension.equals(Utils.jpg) || extension.equals(Utils.png))
			return true;
		return false;
	}

	@Override
	public String getDescription() {
		return "Image (*.jpg *.jpeg *.png)";
	}

}

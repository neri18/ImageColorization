package components;

import java.io.File;

public class Utils {

	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String png = "png";
	
	public static String getExtension(File f){
		String extension = "";
		String filename = f.getName();
		
		int i = filename.lastIndexOf('.');
		
		if( (i > 0) && (i < filename.length() - 1) )
			extension = filename.substring(i+1).toLowerCase();
        
		return extension;
	}
}

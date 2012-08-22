package extras;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JColorChooserWithCustomPreviewPanel {

  public static void main(String[] a) {

    final JLabel previewLabel = new JLabel("I Love Swing", JLabel.CENTER);
    previewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
    previewLabel.setSize(previewLabel.getPreferredSize());
    previewLabel.setBorder(BorderFactory.createEmptyBorder(0,0,1,0));
    
    JColorChooser colorChooser = new JColorChooser();
    colorChooser.setPreviewPanel(previewLabel);

    JDialog d = colorChooser.createDialog(null,"",true,colorChooser,null,null);
    
    d.setVisible(true);
  }

}
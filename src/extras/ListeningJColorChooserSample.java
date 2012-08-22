package extras;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ListeningJColorChooserSample {

  public static void main(String args[]) {
	  try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException e) {} 
		catch (InstantiationException e) {} 
		catch (IllegalAccessException e) {} 
		catch (UnsupportedLookAndFeelException e) {}
		
    JFrame frame = new JFrame("JColorChooser Popup");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JLabel label = new JLabel("www.java2s.com", JLabel.CENTER);
    label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));

    frame.add(label, BorderLayout.SOUTH);

    final JColorChooser colorChooser = new JColorChooser(label.getBackground());

    ColorSelectionModel model = colorChooser.getSelectionModel();
    ChangeListener changeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        Color newForegroundColor = colorChooser.getColor();
        label.setForeground(newForegroundColor);
      }
    };
    model.addChangeListener(changeListener);

    frame.add(colorChooser, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}
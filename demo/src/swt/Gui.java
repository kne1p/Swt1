package swt;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author Chris
 *
 */
public final class Gui {
	/**
	 * @param args not used
	 */
	public static void main(String[] args) {

		changeLookAndFeel();

		demoFlow();
		
		try {
			File file = new File("papagei_nachher.png");
			Image image;
			image = ImageIO.read(file);
			demoIcon(image);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void changeLookAndFeel() {
		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) { e.printStackTrace();
		} catch (ClassNotFoundException e) { e.printStackTrace();
		} catch (InstantiationException e) { e.printStackTrace();
		} catch (IllegalAccessException e) { e.printStackTrace();
		}
	}
	
	private static void demoIcon(Image image) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JLabel(new ImageIcon(image)));
		f.setSize(200, 200);
		f.setVisible(true);
	}

	private static void demoFlow() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.setSize(220, 325);
		for (int i = 0; i < 20; i++) {
			f.add(new JLabel("Text"));
			f.add(new JButton("Button"));
		}
		f.setVisible(true);
	}

	private Gui() { System.out.println("Gui created. "); }
}

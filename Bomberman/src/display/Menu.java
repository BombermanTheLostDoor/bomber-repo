package display;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Menu extends JPanel
{
	/******************************************************/
	private static final long serialVersionUID = 1L;
	public static boolean visible = false;
	/******************************************************/
	
	public Menu() 
	{
		setSize(new Dimension(Display.Width, Display.Height));
		setLocation(0, 0);
		setVisible(true);
		setBackground(Color.white);
	}
	
}

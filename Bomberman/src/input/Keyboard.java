package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import display.Display;
import display.Menu;

public class Keyboard implements KeyListener
{
	
	/********************************************************/
	public static boolean[] keys = new boolean[157];
	public boolean left = false, up = false, right = false, down = false;
	/********************************************************/
	
	public void update()
	{
		left = keys[KeyEvent.VK_LEFT];
		up = keys[KeyEvent.VK_UP];
		right = keys[KeyEvent.VK_RIGHT];
		down = keys[KeyEvent.VK_DOWN];
		
		System.out.println("left: " + left + " up: " + up + " right: " + right + " down: " + down);
	}
	
	public void keyPressed(KeyEvent e) 
	{
		menuCondition(e);
		
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) 
	{
		if((e.getKeyChar() == 'p' || e.getKeyChar() == 'P') && !Menu.visible)
		{
			if(Display.running)
				Display.running = false;
			else Display.running = true;
		}
	}
	
	public void menuCondition(KeyEvent e)
	{
		if(e.getKeyCode() == 27)
		{
			if(Menu.visible)
			{
				Display.frame.remove(Display.menu);
				Display.running = true;
				Menu.visible = false;
			}
			else
				{
				Display.frame.add(Display.menu);
				Display.running = false;
				Menu.visible = true;
				}
		}
	}

}

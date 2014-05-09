package player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.Display;
import display.Menu;
import load.ImageBuffer;

public class Player 
{
	/*********************************/
	public int x, y;
	public static BufferedImage player;
	public static int speed = 1;
	public int h = (13*40) + 53;
	/*********************************/
	
	public Player(int x, int y) 
	{
		this.x = x;
		this.y = y;
		player = ImageBuffer.bufferedImages.get(3);
	}
	
	public void draw(Graphics g)
	{
		if (Display.running && !Menu.visible) 
			g.drawImage(player, x, y, null);
	}
	
	public void move()
	{
		if(Display.keyboard.left)
		{
			x-= speed;
		}
		if(Display.keyboard.up)
		{
			y-= speed;
		}
		if(Display.keyboard.right)
		{
			x+= speed;
		}
		if(Display.keyboard.down)
		{
			y+= speed;
		}
		
		if(this.x < 40)
		{
			this.x = 40;
		}
		
		if(this.x > (Display.Width - 7) - 80)
		{
			this.x = (Display.Width - 7) - 80;
		}
		
		if(this.y < 53 + 40)
		{
			this.y = 53 + 40;
		}
		
		if(this.y > (h - 40) - 40)
		{
			this.y = (h - 40) - 40;
		}
	}
	
	public int getPlayerX()
	{
		return this.x;
	}
	
	public int getPlayerY()
	{
		return this.y;
	}
	
}

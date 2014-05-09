package display;

import input.Keyboard;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import player.Player;
import load.ImageBuffer;

public class Display extends JComponent implements Runnable
{
	/******************************************************/
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public static int Width = 1080 + 7, Height = (1080 / 16)*9;
	public static boolean running = true;
	private Thread thread;
	public static Keyboard keyboard = new Keyboard();
	public static Menu menu = new Menu();
	public static int x = 0;
	public static ImageBuffer ib = new ImageBuffer();
	public static Player player = new Player(100, 100);
	/******************************************************/
	
	public Display() 
	{
		frame = new JFrame("Bomberman");
		frame.add(this);
		frame.addKeyListener(keyboard);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setSize(new Dimension(Width, Height));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	protected void paintComponent(Graphics g)
 {
		if (running && !Menu.visible) {
			
			g.drawRect(x, 10, 100, 100);
			
			for (int i = 0; i < 13; i++) {
				for (int j = 0; j < 27; j++) {
					g.drawRect((j * 40), (i * 40) + 53, 40, 40);
				}
			}

			for (int i = 0; i < 27; i++) {
				g.drawImage(ImageBuffer.bufferedImages.get(4), i * 40, 53, null);
				g.drawImage(ImageBuffer.bufferedImages.get(4), i * 40,player.h - 40, null);
			}

			for (int i = 1; i < 12; i++) {
				g.drawImage(ImageBuffer.bufferedImages.get(4), 0,(i * 40) + 53, null);
				g.drawImage(ImageBuffer.bufferedImages.get(4),(Display.Width - 7) - 40, (i * 40) + 53, null);
			}

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 5; j++) {
					g.drawImage(ImageBuffer.bufferedImages.get(4),(i * 80) + 80, (j * 2 * 40) + 133, null);
				}
			}
		}
		player.draw(g);
		
		
		if(!running && !Menu.visible)
			g.drawString("Paused", Width/2 - 25, Height/2 - 30);
		
		if(!running && Menu.visible)
		{
			g.drawImage(ImageBuffer.bufferedImages.get(0), 170, 60, null);
			g.drawImage(ImageBuffer.bufferedImages.get(1), 460, 275, null);
			g.drawImage(ImageBuffer.bufferedImages.get(2), 460, 380, null);
			g.drawString("v0.1", Width - 32, Height - 34);
		}
		
		
	}
	
	public void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() 
	{
		while(true)
		{
			while(running)
			{
				player.move();
				keyboard.update();
//				System.out.println("running");
				repaint();
				x++;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}

package load;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageBuffer 
{

	/*********************************/
	public static ImagePathCollector ipc;
	public static ArrayList<File> files = new ArrayList<File>();
	public static ArrayList<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();
	/*********************************/
	
	public ImageBuffer()
	{
		 ipc = new ImagePathCollector();
		 createFile();
		 createBufferedImage();
	}
	
	public void createFile()
	{
		for (int i = 0; i < ImagePathCollector.imagePaths.size(); i++) {
			files.add(new File(ImagePathCollector.imagePaths.get(i)));
		}
	}
	
	
	
	public void createBufferedImage()
	{
		for (int i = 0; i < files.size(); i++) {
			try {
				bufferedImages.add(ImageIO.read(files.get(i)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
	

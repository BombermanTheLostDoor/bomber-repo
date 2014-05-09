package load;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImagePathCollector
{
	
	/*******************************************************/
	public static String path = "resources/image_path.txt";
	public static File file;
	public static ArrayList<String> imagePaths = new ArrayList<String>();
	/*******************************************************/
	
	public ImagePathCollector() 
	{
		file = new File(path);
		
		try {
			scanFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void scanFile() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNext())
		{
			imagePaths.add(scanner.nextLine());
		}
		
		
		scanner.close();
	}
	
	
	
}

package ExternalSystems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class FileUtils {
	
	public static Vector<String> fileReader(String filename) {
		File f = new File(filename);
		Vector<String> file_lines = new Vector<String>();
		try {

			Scanner reader = new Scanner(f);
			while (reader.hasNextLine()) {
				file_lines.addElement(reader.nextLine());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return file_lines;
	}
	
	public static void fileWriter(String file_name, Vector<String> data_lines) {
		File f = new File(file_name);
		try {
			PrintWriter writer = new PrintWriter(f);
			writer.flush();
			for (String line : data_lines) {
				writer.println(line);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

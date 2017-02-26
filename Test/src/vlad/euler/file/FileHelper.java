package vlad.euler.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHelper {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		FileHelper fh = new FileHelper();
		
		for(String number : fh.readNumbers("resources/numbers1.txt")) {
			System.out.println("[" + number + "]");
		}

	}

	public String[] readNumbers(String filename) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			String line;
			while((line = in.readLine()) != null) {
				list.add(line);
			}
		} finally {
			in.close();
		}
		
		return list.toArray(new String[0]);
	}
}

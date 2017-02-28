package vlad.euler.names;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;

public class SumNames {

	public static void main(String[] args) throws IOException {
		SumNames s = new SumNames();
		ArrayList<String> list = s.readFile("resources/p022_names.txt");
		Collections.sort(list);
		
		System.out.println(list.get(937));

		long sum = 0;
		int position = 1;
		for(String a : list) {
			sum += s.alphabeticalValue(a) * position++;
		}
		
		System.out.println(sum);
		
	}
	
	public int alphabeticalValue(String str) {
		int sum = 0;
		int c = new String("A").getBytes()[0] - 1;
		
		for(int b : str.getBytes()) {
			sum += b - c;
		}
		
		return sum;
	}
	
	public ArrayList<String> readFile(String filename) throws IOException {
		ArrayList<String> list = new ArrayList<String>();

		CSVReader reader = new CSVReader(new FileReader(filename));
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			List<String> a = Arrays.asList(nextLine);
			list.addAll(a);
		}
		reader.close();
		return list;
	}	

}

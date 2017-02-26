package vlad.euler.grid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GridReader {

	public static void main(String[] args) throws IOException {
		
		GridReader gr = new GridReader();
		
		for(Long[] list : gr.read("resources/grid1.txt")) {
			for(Long number : list) {
				System.out.print(Helper.zeroPad(number) + " ");
			}
			System.out.println();
		}
	}
	
	public Long[][] read(String filename) throws IOException {
		
		ArrayList<Long[]> finalList = new ArrayList<Long[]>();
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		String line;
		while((line = in.readLine()) != null) {
			ArrayList<Long> l = new ArrayList<Long>();
			StringTokenizer tk = new StringTokenizer(line,  " ");
			while(tk.hasMoreTokens()) {
				l.add(Long.parseLong(tk.nextToken()));
			}
			finalList.add(l.toArray(new Long[0]));
		}
		
		in.close();
		
		return finalList.toArray(new Long[0][0]);
	}

}

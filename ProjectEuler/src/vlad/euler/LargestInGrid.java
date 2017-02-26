package vlad.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LargestInGrid {
	
	
	public static String grid;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//Long[][] grid = loadGrid("resources/grid1.txt");
		

		//long max = 0;
		
		//long candidate = findMax(grid, 0, 1, 4);
		
		//System.out.println(candidate);
		
		System.out.println("Couldn't complete this... Solution of problem 11 is on Test project...");
	}

	
	@SuppressWarnings("unused")
	private static long findMax(Long[][] grid2, int horizDir, int vertDir, int adjacents) {
		
		long max = 0;
		
		int rows = grid2.length;
		int cols = grid2[0].length;				
			
		/* right
		for(int i=0; i<rows; i++) {
			System.out.println("line " + i);
			for(int j=0; j<=(cols-adjacents); j++) {
				long candidate = sumAdjacents(grid2, i, j, adjacents, 0, 1);
				if(candidate > max) {
					max = candidate;
				}
			}
		}*/
		
		/* left 
		for(int i=0; i<rows; i++) {
			System.out.println("line " + i);
			for(int j=(cols-1); j>=(adjacents-1); j--) {
				long candidate = sumAdjacents(grid2, i, j, adjacents, 0, -1);
				if(candidate > max) {
					max = candidate;
				}
			}
		}*/

		/* down 
		for(int i=0; i<cols; i++) {
			System.out.println("col " + i);
			for(int j=0; j<=(rows-adjacents); j++) {
				long candidate = sumAdjacents(grid2, j, i, adjacents, 1, 0);
				if(candidate > max) {
					max = candidate;
				}
			}
		}*/
		
		/* up
		for(int i=0; i<cols; i++) {
			System.out.println("col " + i);
			for(int j=(rows-1);j>=(adjacents-1); j--) {
				long candidate = sumAdjacents(grid2, j, i, adjacents, -1, 0);
				if(candidate > max) {
					max = candidate;
				}
			}
		}*/
		
		/* diag1 = right + up */
		for(int i=0; i<(rows+cols); i++) {
			int row = Math.min(i,rows-1);
			int col = Math.max(0, i-rows+1);
			
			while(row>=0 && col<cols) {
				System.out.println(zeroPad(grid2[row][col]));
				row--;
				col++;
			}
			System.out.println();
		}

		return max;
	}


	@SuppressWarnings("unused")
	private static long sumAdjacents(Long[][] grid2, int i, int j, int adjacents, int h, int v) {
		long sum = 0;
		for(int z=0; z<adjacents; z++) {
			Long nextNum = grid2[i + (z*h)][j + (z*v)];
			sum += nextNum;
			System.out.print("+" + zeroPad(nextNum));
		}
		System.out.println("="+sum);
		return sum;
	}


	private static String zeroPad(long number) {		
		String str = "00" + number;		
		return str.substring(str.length() - 2);
	}


	public static Long[][] loadGrid(String filename) throws IOException {
				
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		ArrayList<Long[]> list = new ArrayList<Long[]>();
		
		String line = null;
		while((line = in.readLine()) != null) {
			ArrayList<Long> line1 = new ArrayList<Long>();
			StringTokenizer tk = new StringTokenizer(line, " ");
			while(tk.hasMoreElements()) {
				line1.add(Long.parseLong(tk.nextToken()));
			}
			list.add(line1.toArray(new Long[0]));
		}
		
		in.close();
		
		return list.toArray(new Long[0][0]);
	}
}

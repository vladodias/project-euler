package vlad.euler.sum;

import java.io.IOException;
import java.math.BigInteger;

import vlad.euler.file.FileHelper;

public class LargeSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		FileHelper fh = new FileHelper();
		
		BigInteger sum = new BigInteger("0");
		
		for(String number : fh.readNumbers("resources/numbers1.txt")) {
			//System.out.println("[" + number + "]");
			sum = sum.add(new BigInteger(number));
		}
		
		System.out.println("" + sum);
	}

}

package vlad.euler.fibonacci;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;

public class Fibonacci {

	public static void main(String[] args) {
		
		Fibonacci f = new Fibonacci();
		
		int i = 3;
		String nextFibonacci;
		do {
			nextFibonacci = "" + f.nextFibonacci();
			System.out.println(StringUtils.leftPad("" + i, 2) + " : " + nextFibonacci);
			i++;
		} while(nextFibonacci.length() < 1000);
	}

	private BigInteger fminus1 = new BigInteger("1");
	private BigInteger fminus2 = new BigInteger("1");
	
	public BigInteger nextFibonacci() {
		BigInteger thisNumber = fminus1.add(fminus2);
		fminus2 = fminus1;
		fminus1 = thisNumber;
		return thisNumber; 
	}
	
}

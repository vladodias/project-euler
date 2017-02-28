package vlad.euler.combinations;

import java.math.BigInteger;

import vlad.euler.factorial.Factorial;

public class BinomialCoeficient {
	
	public static void main(String[] args) {
		
		int grid = 20;
		
		System.out.println(BinomialCoeficient.v(new BigInteger("" + grid*2), new BigInteger("" + grid)));
	}
	
	public static BigInteger v(BigInteger n, BigInteger k) {
		return Factorial.v(n).divide(Factorial.v(k).multiply(Factorial.v(n.add(k.negate()))));
	}

}

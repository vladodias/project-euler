package vlad.euler.factorial;

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {

		for(long i=0; i<10; i++) {
			System.out.println("factorial(" + i + ") = " + Factorial.factorial(i));
		}
		
	}
	
	public static BigInteger factorial(long n) {
		return factorial("" + n);
	}
	
	public static BigInteger factorial(String n) {
		return factorial(new BigInteger(n));
	}
	
	public static BigInteger factorial(BigInteger n) {
	    BigInteger factorial = BigInteger.valueOf(1);

	    for (int i = 1; i <= n.intValue(); i++) {
	        factorial = factorial.multiply(BigInteger.valueOf(i));
	    }

	    return factorial;
	}
	
}

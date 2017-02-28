package vlad.euler.digitsum;

import java.math.BigInteger;

import vlad.euler.factorial.Factorial;

public class FactorialDigitSum {

	public static void main(String[] args) {
		BigInteger n = Factorial.v(new BigInteger("100"));
		String str = n.toString();
		long sum = 0;
		for (byte c : str.getBytes()) {
			sum += Long.parseLong(new String(new byte[] { c }));
		}
		System.out.println(sum);
	}

}

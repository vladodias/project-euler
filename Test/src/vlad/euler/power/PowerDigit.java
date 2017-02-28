package vlad.euler.power;

import java.math.BigInteger;

public class PowerDigit {

	public static void main(String[] args) {
		BigInteger n = new BigInteger("2").pow(1000);
		String str = n.toString();
		long sum = 0;
		for(byte c : str.getBytes()) {
			sum += Long.parseLong(new String(new byte[] {c}));
		}
		System.out.println(sum);
	}
}

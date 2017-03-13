package vlad.euler.powers;

import org.apache.commons.lang3.StringUtils;

public class SumPowers {

	public static void main(String[] args) {
		
		int power = 5;
		long total = 0;
		
		for(long n=2; n<=999999; n++) {
			byte[] bytes = StringUtils.leftPad("" + n, power, '0').getBytes();
			long sum = 0;
			for(byte b : bytes) {
				sum += (long) Math.pow(Long.parseLong(new String(new byte[] {b})), power);
			}
			if(sum == n) {
				total += n;
				System.out.println(n);
			}
		}
		
		System.out.println(total);
		
	}

}

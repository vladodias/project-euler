package vlad.euler.powers;

import java.math.BigInteger;
import java.util.HashMap;

public class DistinctPowers {

	public static void main(String[] args) {
		
		
		HashMap<BigInteger,BigInteger> map = new HashMap<BigInteger,BigInteger>();
		
		int start = 2;
		int end = 100;
		
		for(int a=start; a<=end; a++) {
			for(int b=start; b<=end; b++) {
				BigInteger result = new BigInteger("" + a);
				result = result.pow(b);
				map.put(result, result);
			}
		}
		
		/*for(long n : map.keySet()) {
			System.out.print(n + " ");
		}*/
		
		System.out.println();
		System.out.println(map.size());
		
	}

	
	
}

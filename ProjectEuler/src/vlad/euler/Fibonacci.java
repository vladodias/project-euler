package vlad.euler;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("result=" + sumFibonacci(new Long[] {1L, 2L}, 4000000L));
	}
	
	public static long sumFibonacci(Long[] start, long limit) {
		long sum = 0;
		ArrayList<Long> list = new ArrayList<Long>(Arrays.asList(start));
		
		for(int i=0; i<list.size(); i++) {
			if((list.get(i) % 2L) == 0) {
				sum += 0L + list.get(i);
				System.out.println("sum=" + sum);
			}
		}
		
		while(true) {
			int lastIndex = list.size()-1;
			Long nextTerm = 0L + list.get(lastIndex) + list.get(lastIndex-1);
			System.out.println("" + nextTerm);
			
			if(nextTerm > limit) {
				break;
			}

			list.add(nextTerm);
			if((nextTerm % 2L) == 0) {
				sum += 0L + nextTerm;
				System.out.println("sum=" + sum);
			}
		}
		
		return sum;
	}

}

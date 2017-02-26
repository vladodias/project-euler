package vlad.euler;

public class SumMultiples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long[] list = {3,5};
		long result = sumMultiples(list, 1000);
		
		System.out.println(result);
	}
	
	public static long sumMultiples(long[] list, long limit) {
		long sum = 0;
		for(long i=1; i<limit; i++) {
			for(int j=0; j<list.length; j++) {
				if((i % list[j]) == 0) {
					sum += i;
					break;
				}
			}
		}
		return sum;
	}

}

package vlad.euler;

public class SumSquareDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sumSqDiff(100L));

	}
	
	public static long sumSqDiff(long sequenceEnd) {
		long sumsq = 0;
		long sum = 0;
		for(long i = 1; i<=sequenceEnd; i++) {
			sumsq += Math.pow(i, 2);
			sum += i;
		}
		return (long) Math.pow(sum, 2) - sumsq;
	}

}

package vlad.euler;

public class SmallestDivisible {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(smallestDivisible(20L));
	}
	
	public static long smallestDivisible(long sequenceEnd) {
		long candidate = sequenceEnd * 2;
		
		while(true) {
			if(checkDivisible(sequenceEnd, candidate)) {
				return candidate;
			}
			candidate++;
		}

	}

	private static boolean checkDivisible(long sequenceEnd, long candidate) {

		for(long i=2L; i<=sequenceEnd; i++) {
			if((candidate % i) != 0) {
				return false;
			}
		}
		
		return true;
	}

}

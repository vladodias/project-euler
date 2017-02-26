package vlad.euler.divisors;

public class DivisorsFinder {

	public static void main(String[] args) {
		System.out.println(new DivisorsFinder().countDivisors(21));
	}
	
	public long countDivisors(long number) {
		int count = 2; // any number is divisible by 1 and by itself, so it starts with two
		for(long i=2L; i<=(number/2L); i++) {
			if((number % i) == 0) {
				count++;
				//System.out.print(i + ", ");
			}
		}
		//System.out.println();
		return count;
	}

}

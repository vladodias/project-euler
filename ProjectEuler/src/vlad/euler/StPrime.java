package vlad.euler;

public class StPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes p = new Primes();
		
		long prime = 0L;
		for(long i=1; i<=10001; i++) {
			prime = p.nextPrime(Long.MAX_VALUE);
		}
		
		System.out.println(prime);
	}

}

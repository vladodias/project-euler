package vlad.euler;

public class PrimesSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes p = new Primes();
		
		long sum = 0;
		
		Long prime = 0L;
		do {
			sum += prime;
			prime = p.nextPrime(2000000L);
		} while(prime != null);
		
		System.out.println(sum);
	}

}

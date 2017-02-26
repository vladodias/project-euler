package vlad.euler;

import java.util.ArrayList;

public class Primes {
	
	ArrayList<Long> primes = new ArrayList<Long>();
	
	public Primes() {
	}

	/**
	 * @param args
	 */
	public static void main1(String[] args) {

		for(long number : factors(600851475143L)) {
			System.out.println(number);
		}
		
	}
	
	public static void main(String[] args) {

		for(long number : factors(20L)) {
			System.out.println(number);
		}
		
	}
	
	public static ArrayList<Long> factors(long number) {
		ArrayList<Long> factors = new ArrayList<Long>();
		
		Primes p = new Primes();
		long limit = number/2;
		
		long mult = 1;
		Long prime = 0L;
		while((mult < number) && (prime != null)) {
			prime = p.nextPrime(limit);
			if(prime != null && ((number % prime) == 0)) {
				factors.add(prime);
				mult *= prime;
			}
		}
		
		return factors;
	}
	
	public Long nextPrime(long limit) {
		
		long start = 2L;
		if(primes.size() == 0) {
			primes.add(2L);
			return 2L;
		} else if(primes.size() == 1) {
			primes.add(3L);
			return 3L;
		} else {
			start = primes.get(primes.size()-1);
		}

		for(long number = start; number <= limit; number+=2) {
			if(checkPrime(number, primes)) {
				primes.add(number);
				return number;
			}
		}
		
		return null;
	}

	private boolean checkPrime(long number, ArrayList<Long> list) {
		
		for(Long prime : list) {
			if((number % prime) == 0) {
				return false;
			}
		}
		
		return true;
	}

}

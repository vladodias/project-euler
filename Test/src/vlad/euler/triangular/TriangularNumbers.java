package vlad.euler.triangular;

import vlad.euler.divisors.DivisorsFinder;

public class TriangularNumbers {
	
	public static void main(String[] args) {
		
		TriangularNumbers tn1 = new TriangularNumbers();
		
		for(int i=1; i<=10; i++) {
			System.out.print(tn1.nthTriangular(i) + ", ");
		}
		System.out.println();
		
		DivisorsFinder df = new DivisorsFinder();
		TriangularNumbers tn = new TriangularNumbers();
		long countDivisors;
		long number;
		long n = 12300L;
		do {
			number = tn.nthTriangular(n++);
			countDivisors = df.countDivisors(number);
			System.out.println("n = " + n + " number = " + number + " divisors = " + countDivisors);
		} while(countDivisors <= 500);
	}

	public static void main1(String[] args) {
		
		TriangularNumbers tn1 = new TriangularNumbers();
		
		for(int i=0; i<10; i++) {
			System.out.print(tn1.nextTriangular() + ", ");
		}
		
		// this solution will probably work
		// but it will take a while
		DivisorsFinder df = new DivisorsFinder();
		TriangularNumbers tn = new TriangularNumbers();
		long countDivisors;
		long number;
		do {
			number = tn.nextTriangular();
			countDivisors = df.countDivisors(number);
			System.out.println("number = " + number + " divisors = " + countDivisors);
		} while(countDivisors <= 500);
		
	}
	
	private long triangular = 0L;
	private long nextNatural = 1L;
	
	public long nextTriangular() {
		triangular += nextNatural++;
		return triangular;
	}
	
	public long nthTriangular(long n) {
		// a triangular number is the sum of an arithmetic progression
		// with start a1 = 1 and increment = 1 ... 1, 2, 3, 4, 5
		// the formula to calculate the sum or an arithmetic progression is
		// sum = n * ((a1 + an) / 2)
		return (long) (n * ((1 + n)/2.0));
	}

}
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

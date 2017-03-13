package vlad.euler.divisors;

public class AmicableNumbers {

	public static void main(String[] args) {
		
		DivisorsFinder df = new DivisorsFinder();
		
		long sum = 0;
		for(int a=1; a<10000; a++) {
			long b = df.sumDivisors(a);
			//System.out.println("D(" + a + ")=" + b);
			if(b != a && b < 10000 && df.sumDivisors(b) == a) {
				sum += b+a;
				System.out.println("a = " + a + " b = " + b);
			}
		}
		
		System.out.println(sum/2);
	}

}

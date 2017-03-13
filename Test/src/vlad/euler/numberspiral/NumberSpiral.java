package vlad.euler.numberspiral;

public class NumberSpiral {

	public static void main(String[] args) {
		
		long square = 1001;
		long d1 = 3;
		long d2 = 12;
		long sum = 1;
		
		for(int i=0; i<(square/2); i++) {
			sum += (d1*d1)*4 - d2; 
			d1 += 2;
			d2 += 12;
		}
		
		System.out.println(sum);
	}

}

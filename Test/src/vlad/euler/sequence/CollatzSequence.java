package vlad.euler.sequence;

public class CollatzSequence {

	public static void main(String[] args) {
		
		long longestChain = 0;
		long startingNumber = 0;
		
		for(int i=2; i<1000000; i++) {
			CollatzSequence s = new CollatzSequence(i);
			long number;
			long chain = 2;
			System.out.print("" + i + ", ");
			while((number = s.nextNumber()) != 1) {
				System.out.print("" + number + ", ");
				chain++;
			}
			System.out.println("1");
			if(chain > longestChain) {
				longestChain = chain;
				startingNumber = i;
				System.out.println("longestChain = " + longestChain);
			}
		}
		
		System.out.println("chain size = " + longestChain + " number = " + startingNumber);
	}
	
	long number;
	
	public CollatzSequence(long startingNumber) {
		number = startingNumber;
	}
	
	public long nextNumber() {
		if((number % 2) == 0) {
			number /= 2;
		} else {
			number = 3*number + 1;
		}
		return number;
	}

}
// 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

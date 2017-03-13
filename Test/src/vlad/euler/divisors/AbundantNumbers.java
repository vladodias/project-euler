package vlad.euler.divisors;

import java.util.ArrayList;

public class AbundantNumbers {

	public static void main(String[] args) {

		long sum = 0;
		for(int n=24; n<=28123; n++) {
			if(AbundantNumbers.canBeWrittenAsASumOfTwoAbundant2(n)) {
			} else {
				sum += n;
			}
		}
		
		System.out.println(sum);
		
		for(int i=1; i<=23; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
	
	public static void main1(String[] args) {
		
		AbundantNumbers an1 = new AbundantNumbers();
		
		for(int i=0; i<10; i++) {
			System.out.println(an1.nextAbundant());
		}
	}

	private static ArrayList<Long> abundants = null;

	private static ArrayList<Long> getListOfAbundants() {
		
		if(abundants != null) {
			return abundants;
		} else {
			abundants = new ArrayList<Long>();
			AbundantNumbers an1 = new AbundantNumbers();
			long abundant;
			do {
				abundant = an1.nextAbundant();
				abundants.add(abundant);
			} while(abundant <= 28123);

			return abundants;
		}
	}
	
	private static boolean canBeWrittenAsASumOfTwoAbundant2(int n) {

		Long[] abundants = getListOfAbundants().toArray(new Long[0]);
		
		for(int i=0; i<abundants.length; i++) {
			
						
			if((abundants[i] * 2) > n) {
				break;
			}
			
			for(int j=i; j<abundants.length; j++) {
				long sum = abundants[i] + abundants[j];
				
				if(sum > n) {
					break;
				}
				
				if(sum == n) {
					System.out.println("" + abundants[i] + "+" + abundants[j] + "=" + n);
					return true;
				}
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("unused")
	private static boolean canBeWrittenAsASumOfTwoAbundant(int n) {
		
		AbundantNumbers an1 = new AbundantNumbers();
		long firstNumber = an1.nextAbundant();
		AbundantNumbers an2 = new AbundantNumbers();
		long secondNumber = an2.nextAbundant();
		while((firstNumber + secondNumber) <= n) {
			while((firstNumber + secondNumber) <= n) {
				if((firstNumber + secondNumber) == n) {
					System.out.println("" + firstNumber + "+" + secondNumber + "=" + n);
					return true;
				}
				secondNumber = an2.nextAbundant();
			}
			firstNumber = an1.nextAbundant();
			an2 = new AbundantNumbers();
			secondNumber = an2.nextAbundant(firstNumber);
		}
		
		return false;
	}

	private long lastNumber = 12;
	
	public long nextAbundant() {
		return nextAbundant(lastNumber);
	}
	
	public long nextAbundant(long _lastNumber) {
		
		this.lastNumber = _lastNumber;
		
		DivisorsFinder df = new DivisorsFinder();
		
		for(long n = lastNumber; n<Long.MAX_VALUE; n++) {
			if(df.sumDivisors(n) > n) {
				lastNumber = n+1;
				return n;
			}
		}
		
		throw new RuntimeException("Cannot find more abundant numbers...");
	}

}

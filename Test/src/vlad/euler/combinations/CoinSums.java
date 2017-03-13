package vlad.euler.combinations;

public class CoinSums {
	
	public static void main(String[] args) {
		System.out.println(new CoinSums().perm(200));
	}
	
	private static int[] coins = {
			1, 2, 5, 10, 20, 50, 100, 200
	};
	
	public int perm(int finalSum) {
		return perm(finalSum,0,0);
	}
	
	public int perm(int finalSum, int currentSum, int nextCoin) {
		
		int combinations = 0;
		
		for(int i=nextCoin; i<coins.length; i++) {

			int nextSum = currentSum + coins[i];

			if(nextSum == finalSum) {
				combinations++;
			}
			
			if(nextSum < finalSum) {
				combinations += perm(finalSum, nextSum, i);
			}
		}

		return combinations;
	}
	

}

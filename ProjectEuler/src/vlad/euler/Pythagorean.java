package vlad.euler;

public class Pythagorean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(long a=0; a<1000; a++) {
			for(long b=a+1; b<(1000-a); b++) {
				for(long c=(1000L - (a+b)); c>b; c--) {
					if((a+b+c) == 1000L) {
						if(checkPitagoras(a,b,c)) {
							System.out.println(a * b * c);
						}
					}
				}
			}
		}
	}

	private static boolean checkPitagoras(long a, long b, long c) {

		if((Math.pow(a,2) + Math.pow(b, 2)) == Math.pow(c, 2)) {
			return true;
		} else {
			return false;
		}

	}

}

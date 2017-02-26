package vlad.euler;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long max = 0;
		
		long d1 = 999L;
		long d3 = 999L;
		while(d1 > 1L && (d1*d3) > max) {
			long d2 = d3;
			while(d2 > 1L && (d1*d2) > max) {
				//System.out.println("" + d1 + "*" + d2 + " = " + d1*d2);
				if(checkPalindrome(d1 * d2)) {
					System.out.println("Palindrome " + d1 + "*" + d2 + " = " + d1*d2);
					if((d1*d2) > max) {
						max = d1*d2;
					}
					break;
				}
				d2--;
			}
			d1--;
			d3--;
		}
		
	}
	
	public static boolean checkPalindrome(Long number) {
		//System.out.println(number);
		
		String str = number.toString();
		int len = str.length();
		
		for(int i=0; i < (len/2); i++) {
			if(str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}
		
		return true;
	}

}

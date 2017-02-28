package vlad.euler.string;

import org.apache.commons.lang3.StringUtils;

public class WriteNumbers {

	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<1000; i++) {
			String str = WriteNumbers.v(i);
			System.out.println(str);
			sum += str.length();
		}
		sum += "onethousand".length();
		System.out.println(sum);
	}
	
	public static String v(int number) {
		StringBuffer s = new StringBuffer();
		
		String str = Integer.toString(number);
		byte[] b = StringUtils.reverse(str).getBytes();
		int[] n = new int[b.length];
		for(int i=0; i<b.length; i++) {
			n[i] = b[i] - new String("0").getBytes()[0];
		}
		
		if(n.length > 1) {
			s.insert(0, n[1]==1 ? teens[n[0]] : dezenas[n[1]] + units[n[0]]);
		} else {
			s.insert(0, units[n[0]]);
		}
		
		if(n.length > 2) {
			s.insert(0, n[1]!=0 || n[0]!=0 ? "and" : "");
			s.insert(0, n[2]==1 ? "onehundred" : units[n[2]] + "hundred");
		}
		
		return s.toString();
	}
	
	private static String units[] = {
			"",
			"one",
			"two",
			"three",
			"four",
			"five",
			"six",
			"seven",
			"eight",
			"nine"
	};
	
	private static String dezenas[] = {
			"",
			"",
			"twenty",
			"thirdy",
			"forty",
			"fifty",
			"sixty",
			"seventy",
			"eighty",
			"ninety"
	};
	
	private static String teens[] = {
			"ten",
			"eleven",
			"twelve",
			"thirteen",
			"fourteen",
			"fifteen",
			"sixteen",
			"seventeen",
			"eighteen",
			"nineteen"
	};
	
}

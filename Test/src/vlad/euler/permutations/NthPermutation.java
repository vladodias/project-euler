package vlad.euler.permutations;

import java.util.ArrayList;

public class NthPermutation {
	
	public static void main(String[] args) {
		
		NthPermutation nth = new NthPermutation();
		
		ArrayList<String> list = nth.perm("0123456789");
		
		System.out.println(list.get(999999)); // the millionth combination
		
		//for(int i=0; i<list.size(); i++) {
			//System.out.println(StringUtils.leftPad("" + i+1, 6) + " : " + list.get(i));
		//}
	}
	
	public ArrayList<String> perm(String numbers) {
		return perm(numbers, "");
	}
	
	public ArrayList<String> perm(String numbers, String startingWith) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		if(startingWith.length() == numbers.length()) {
			list.add(startingWith);
			return list;
		}
		
		if(startingWith.length() > numbers.length()) {
			throw new RuntimeException("The start cannot be longer than the sequence of numbers...");
		}
		
		
		byte[] b1 = numbers.getBytes();
		byte[] b2 = startingWith.getBytes();
		int i;
		int j;
		for(i=0; i<b1.length; i++) {
			boolean used = false;
			for(j=0; j<b2.length; j++) {
				if(b1[i] == b2[j]) {
					used = true;
					break;
				}
			}
			if(!used) {
				list.addAll(perm(numbers, startingWith + new String(new byte[] {b1[i]})));
			}
		}

		return list;
	}

}

package vlad.euler.combinations;

import java.math.BigInteger;

import vlad.euler.factorial.Factorial;

public class Combinations {

	public static void main(String[] args) {
		
		Combinations c = new Combinations();
		
		System.out.println(c.calculateCombinations(15, 4));
		
		System.out.println(c.calculatePermutations(15, 4));
		
		System.out.println(c.calculateCombinations(4, 2));
		
		System.out.println(c.calculatePermutations(4, 2));
		
		System.out.println(c.calculateCombinations(6, 2));
		
		System.out.println(c.calculatePermutations(6, 2));
		
		System.out.println(c.calculateCombinations(8, 2));
		
		System.out.println(c.calculatePermutations(8, 2));
		
		System.out.println(c.calculateCombinations(3, 2));
		
		System.out.println(c.calculatePermutations(3, 2));

		
	}
	
	// Combination Formula
	// A formula for the number of possible combinations of r objects from a set of n objects.
	// http://www.mathwords.com/c/combination_formula.htm
	// Example:	
	// How many different committees of 4 students can be chosen from a group of 15?
	// Answer:	There are  possible combinations of 4 students from a set of 15.
	public BigInteger calculateCombinations(long n, long r) {
		return Factorial.factorial(n).divide(Factorial.factorial(r).multiply(Factorial.factorial(n-r)));
	}

	// Permutation Formula
	// 	A formula for the number of possible permutations of k objects from a set of n.
	// Example:	
	// How many ways can 4 students from a group of 15 be lined up for a photograph?
	// Answer:	
	// There are 15P4 possible permutations of 4 students from a group of 15.
	public BigInteger calculatePermutations(long n, long k) {
		return Factorial.factorial(n).divide(Factorial.factorial(n-k));
	}
}

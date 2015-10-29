package primeSolution;

import java.util.LinkedList;

public class FiftyOne extends PrimeSolution 
{
	static final int MAX = 1000000;
	static final int MIN = 56993;
	static final int NOT_FOUND = -1;
	static Integer allNumbers[] = new Integer[MAX];
	static Integer primes[] = new Integer[75000];
	static LinkedList<Integer> nonUniqueNumberedPrimes = new LinkedList<Integer>();
	static int pLength = 0;
	
	
	// Find the smallest prime which, by replacing part of the number 
	// (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
	public static void main(String args[])
	{
		// Sieve out primes
		Sieve(allNumbers,MAX);
		
		// Make an array of contiguous primes
		pLength = PrimesOnly(primes, allNumbers, MAX, MIN);
		
		
	}
	
	public static void PrimeDigitReplacements()
	{
		/* We start knowing that {56003, 56113, 56333, 56443, 56663, 56773, and 56993} is a series
		 * with 7 elements. Each having the form 56$$3.
		 * How can we find an 8 digit family?
		 * 
		 * Sorting:
		 * For each prime,
		 * 		Eliminate it if it has no repeated numbers excluding the least significant digit.
		 *  	find which digits are repeated (that aren't the first digit)
		 *  	increment those digits and check if the new number is prime (will only work for pairs of digits)
		 *  	Continue to increment while there are less than 3 new numbers made that are not prime
		 */
		int replacements = 2;
		for(int i = 0; i<pLength; i++)
		{
			String currentNumber = primes[i].toString();
			int firstCharPosition = HasRepeat(currentNumber);
			if(firstCharPosition != NOT_FOUND)
			{
				// Add it to nonUniqueNumberedprimes 
				if(!nonUniqueNumberedPrimes.contains(primes[i]))
					nonUniqueNumberedPrimes.add(primes[i]);
				
				// Start the incrementing process
				
			}
			// otherwise continue
		}
		
	}
	
	public static void DigitReplacement(int replacements)
	{
		
	}
	
	public static int HasRepeat(String number)
	{
		for(int i = 1; i<number.length(); i++)
		{
			for (int j = i+1; j<number.length(); j++)
			{
				if(number.charAt(i) == number.charAt(j))
				{
					return i;
				}
			}
		}
		return NOT_FOUND;
	}
}

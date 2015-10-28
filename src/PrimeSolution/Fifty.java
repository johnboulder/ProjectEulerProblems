package PrimeSolution;

import java.util.HashMap;

public class Fifty extends PrimeSolution
{
	static final int MAX = 1000000;
	static final int NOT_PRIME = -1;
	static int allNumbers[];
	static int primes[];
	static int pLength;
	static int finalSumLength;
	// Maps start position to sum
	static HashMap<Integer, Integer> consecutiveSumsMap;
	
	public static void main(String args[])
	{
		allNumbers = new int[1000000];
		primes = new int[100000];
		pLength = 0;
		finalSumLength = 0;
		consecutiveSumsMap = new HashMap<Integer, Integer>();
		
		// Sieve out primes
		Sieve(allNumbers,MAX);
		
		// Make an array of contiguous primes
		pLength = PrimesOnly(primes, allNumbers, MAX, 0);
		
		int theSum = ConsecutiveSum();
		System.out.println("Sum: "+theSum);
	}
	
	public static int ConsecutiveSum()
	{
		// Find the initial sums of length 23
		int tempSum = 0;
		int maxSum = 0;
		int sumLength = 23;
		for(int i = 0; i<pLength-sumLength; i++)
		{
			tempSum = 0;
			for(int j = 0; j<sumLength; j++)
			{
				tempSum+=primes[j+i];
			}
			// Add the sum of primes from start position i, and the sum to the hashmap
			if(tempSum<MAX)
			{
				consecutiveSumsMap.put(i, tempSum);
				if(tempSum>maxSum && isPrime(tempSum, allNumbers))
					maxSum = tempSum;
			}	
			else 
				break;
		}
		
		tempSum = 0;
		
		while(consecutiveSumsMap.size()>0)
		{
			// Loop through sums mapping, calculating the next greatest sum of sumLength+2
			// Save the biggest sum that's also prime
			int i = 0;
			sumLength+=2;
			while(tempSum<MAX && i<pLength)
			{
				if(!consecutiveSumsMap.containsKey(i))
					break;
				
				int currentSum = consecutiveSumsMap.get(i);
				currentSum+= primes[i+sumLength-1] + primes[i+sumLength-2];
				if(currentSum<MAX)
				{
					// Add it back to the sums mapping
					consecutiveSumsMap.replace(i, currentSum);
					
					if(isPrime(currentSum, allNumbers))
					{
						// Save it as the max sum
						maxSum = currentSum;
					}
				}
				else
				{
					// Remove it and any others from the mapping using a for loop that breaks when a key is not found
					while(consecutiveSumsMap.containsKey(i))
					{
						consecutiveSumsMap.remove(i);
						i++;
					}
				}
				
				i++;
			}
		}
		finalSumLength = sumLength;
		return maxSum;
	}
}

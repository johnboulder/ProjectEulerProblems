package PrimeSolution;

public class PrimeSolution {

	protected static final int NOT_PRIME = -1;
	/**
	 * @author John Stockwell
	 * Simple implementation of the Sieve of Eratosthenes.
	 * Takes an empty integer array, fills it with integers from 0 to the size of the array,
	 * and marks any composite numbers with NOT_PRIME.
	 * @param array The array we want to contain prime values
	 * @param max The upper bound
	 */
	protected static void Sieve(int[] array, int max)
	{
		for(int i = 0; i<max; i++)
		{
			array[i] = i;
		}
		
		array[0] = NOT_PRIME;
		array[1] = NOT_PRIME;
		
		for(int i = 2; i<max; i++)
		{
			for(int j = 2; j*i<max; j++)
			{
				array[i*j] = NOT_PRIME;
			}
		}
	}
	
	protected static void Sieve(Integer[] array, Integer max)
	{
		for(int i = 0; i<max; i++)
		{
			array[i] = i;
		}
		
		array[0] = NOT_PRIME;
		array[1] = NOT_PRIME;
		
		for(int i = 2; i<max; i++)
		{
			for(int j = 2; j*i<max; j++)
			{
				array[i*j] = NOT_PRIME;
			}
		}
	}
	
	/**
	 * @author John Stockwell
	 * Take an array which has been processed by Sieve and separates out the primes into their own array so they 
	 * are consecutive.
	 * @param primes The array which will contain the prime values
	 * @param allNumbers A mapping of numbers to themselves if they're prime, or NOT_PRIME if they are not
	 * @param ub The upper bound of where we will stop looking for primes
	 * @param lb The lower bound where we will start looking for primes
	 * @return The number of primes in the prime array
	 */
	protected static int PrimesOnly(int[] primes, int[] allNumbers, int ub, int lb)
	{
		int p = 0;
		for(int i=lb; i<ub; i++)
		{
			if(allNumbers[i] != NOT_PRIME)
			{
				primes[p] = allNumbers[i];
				p++;
			}
		}
		return p;
	}
	
	protected static int PrimesOnly(Integer[] primes, Integer[] allNumbers, Integer ub, Integer lb)
	{
		int p = 0;
		for(int i=lb; i<ub; i++)
		{
			if(allNumbers[i] != NOT_PRIME)
			{
				primes[p] = allNumbers[i];
				p++;
			}
		}
		return p;
	}
	
	/**
	 * @author John Stockwell
	 * 
	 * @param number
	 * @param allNumbers
	 * @return
	 */
	protected static boolean isPrime(int number, int[] allNumbers)
	{
		if(allNumbers[number] != NOT_PRIME)
			return true;
		else return false;
	}
}

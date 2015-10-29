package primeSolution;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class FortyNine extends PrimeSolution
{
	static final int MAX = 9999;
	static final int NOT_PRIME = -1;
	static final int NOT_FOUND = NOT_PRIME;
	static int allNumbers[] = new int[10000];
	static int primes[] = new int[10000];
	static int pLength = 0;
	// Maps start position to sum
	static HashMap<String, List> intCombinations = new HashMap<String, List>();
	
	public static void main(String args[])
	{
		// Sieve out primes
		Sieve(allNumbers,MAX);
		
		// Make an array of contiguous primes
		pLength = PrimesOnly(primes, allNumbers, MAX, 1000);
		
		combo();
	}
	
	public static int combo()
	{
		int i = 0;
		//String theNumber = "";
		
		while(i<pLength)
		{
			// Get the number
			Integer currentNumber = primes[i];
			// Make it a string
			String numberString = currentNumber.toString();
			// Make it a char array
			char[] charArray = numberString.toCharArray();
			// Sort the char array
			Arrays.sort(charArray);
			// Make it a string again
			String sortedString = Arrays.toString(charArray);
			
			// Check if the sorted number string exists as a key in the hash
			if(intCombinations.containsKey(sortedString))
			{
				LinkedList<Integer> currentList = (LinkedList<Integer>) intCombinations.get(sortedString);
				currentList.add(currentNumber);
				intCombinations.replace(sortedString, currentList);
				
			}
			else
			{
				LinkedList<Integer> currentList = new LinkedList<Integer>();
				currentList.add(currentNumber);
				intCombinations.put(sortedString, currentList);
			}
			i++;
		}
		
		// Pop each list from the hash
		// for each, get the first value and add 3330 to it. If the list contains that value, check for the third. Print that group.
		// BiConsumer
		BiConsumer<String, List> biConsumer = (key,value)->
		{
			Object[] currentList = value.toArray();
			int length = value.size();
			int it = 0;
			int jt = it;
			while(it<length)
			{
				Integer l, m, n;
				
				l = (Integer)currentList[it];
				jt = it+1;
				while(jt<length)
				{
					m = (Integer)currentList[jt];
					
					n = m + (m-l);
					if(value.contains(n))
						System.out.println(l.toString()+m.toString()+n.toString());
					jt++;
				}
				it++;
			}
		};
		
		intCombinations.forEach(biConsumer);
		return -1;
	}
}

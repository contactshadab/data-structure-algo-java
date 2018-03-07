/*Find all prime numbers between 1 to n

Algorithm: Sieve of Eratosthenes
For n to be prime we need to check only till sqrt(n)
e.g
36 => {1, 36}, {2, 18}, {3, 12}, {4, 9}, {6, 6}
{9, 4}, {12, 3}, {18, 2}, {36, 1}
For two co-factors a and b,
if a < b then a < sqrt(n)
if b < a then b < sqrt(n)

1. Assume all numbers between 2 and n are prime
2. For i=2 -> sqrt(n), mark every factors of i as non-prime

*/

package shadab.programs.array;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeNumbersBetween1ton {
	
	public int[] findPrimeNumbers(int n){
		int[] primeNumbers = new int[n+1];
		
		//Assume all numbers between 2 and n are prime (1=>prime, 0=>non-prime)
		for(int i=2; i<=n; i++){
			primeNumbers[i] = 1;
		}
		
		//We know 0 and 1 are not prime numbers
		primeNumbers[0] = 0;
		primeNumbers[1] = 0;
		
		for(int i=2; i <= Math.sqrt(n); i++){
			for(int j=2; i*j<=n; j++){
				//Only scan numbers that are not non-prime
				if(primeNumbers[i*j] == 1){
					//Factors of i cannot be prime
					primeNumbers[i*j] = 0;
				}
			}
		}
		return primeNumbers;
	}

	public static void main(String[] args) {
		FindPrimeNumbersBetween1ton finder = new FindPrimeNumbersBetween1ton();
		int[] primeNumbers = finder.findPrimeNumbers(50);
		for(int i=2; i<primeNumbers.length; i++){
			if(primeNumbers[i] == 1)
				System.out.println(i);
		}
	}

}

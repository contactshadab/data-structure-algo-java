/*Find a number that occurs odd no of times in an array.
Rest of the elements occur even no of times
Dont use extra space*/

/*XOR Table
A	B	Result
a	a	0
0	0	0
a	0	a
0	a	a*/

package dataStructure.array;

public class FindNumberOccursOddNoOfTimes_NoExtraSpace {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 3, 1, 3, 3, 1};
		int num = 0;
		for(int i=0; i<arr.length; i++){
			//Using XOR operator
			num = num ^ arr[i];
		}
		System.out.println(num);
	}

}

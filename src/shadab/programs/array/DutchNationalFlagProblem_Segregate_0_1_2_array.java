package shadab.programs.array;

public class DutchNationalFlagProblem_Segregate_0_1_2_array {
	
	public static void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		display(arr);
		
		int low = 0;
		int mid = 0;
		int high = arr.length-1;
		
		while(mid <= high){
			if(arr[mid] == 0){
				swap(arr, mid, low);
				low++;
				mid++;
			}else if(arr[mid] == 1){
				mid++;
			}else{
				//If it is 2, move it to right
				swap(arr, mid, high);
				high--;
			}
		}
		
		display(arr);

	}
	
	public static void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}

}

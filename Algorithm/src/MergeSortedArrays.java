import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String args[]) {
		
		int[] arr1 = {5, 7, 8, 9};
		int[] arr2 = {4, 6, 10, 11, 12};
		
		System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
	}
	
	public static int[] mergeArrays(int[] arr1, int[] arr2){
		
		int[] resultArray = new int[arr1.length + arr2.length];
		int indexOfArr1 = 0;
		int indexOfArr2 = 0;
		int resultIndex = 0;
		while(indexOfArr1 < arr1.length || indexOfArr2 < arr2.length) {
			
			if(indexOfArr1 >= arr1.length && indexOfArr2 < arr2.length) {
				//copy rest of the items in arr2
				resultArray[resultIndex++] = arr2[indexOfArr2++];
				continue;
			}
			
			if(indexOfArr2 >= arr2.length && indexOfArr1 < arr1.length) {
				//copy rest of the items in arr2
				resultArray[resultIndex++] = arr1[indexOfArr1++];
				continue;
			}
			
			if(arr1[indexOfArr1] < arr2[indexOfArr2]) {
				resultArray[resultIndex++] = arr1[indexOfArr1++];
			}
			else {
				resultArray[resultIndex++] = arr2[indexOfArr2++];
			}
		}
			
		return resultArray;
		
	}
}

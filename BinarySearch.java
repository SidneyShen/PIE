/*
Implement a function to perform a binary search on a sorted array 
of integers to find the index of a given integer. Comment on the 
efficiency of this search, and compare it with other search methods.
*/

import java.lang.*;

class BSException extends RuntimeException{
	public BSException(){
        super();
    }

    public BSException(String message){
        super(message);
    }
}

public class BinarySearch{
	public int iterBinarySearch(int[] arr, int target) throws BSException{
		int low = 0, high = arr.length-1;
		int center, range;

		if(low>high){
			throw new BSException("Limits reversed");
		}

		while(true){
			range = high - low;

			if(range == 0 && arr[low]!=target){
				throw new BSException("Element not in array");
			}
			if(arr[low]>arr[high]){
				throw new BSException("Array not sorted");
			}

			center = low + range/2;
			if(arr[center]==target){
				return center;
			}else if(arr[center]>target){
				high = center-1;
			}
			else{
				low = center +1;
			}		
		}
	}

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		BinarySearch test = new BinarySearch();
		int pos = test.iterBinarySearch(input, 8);
		System.out.println(pos);
	}
}
// Gap theorem
import java.util.*;
import java.lang.*;
import java.io.*;

class MergeSort
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = new int[] {2,15,4,1,24,5,21,7,3,11,9,6,8,0};
		sort(arr, 0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort( int[] arr , int start, int finish) {
    	if(start < finish) {
            int mid = (start + finish) / 2;
            sort(arr, start, mid);
            sort(arr, mid+1, finish);
            merge(arr, start, mid, finish);
        }
    }
    
    public static void merge(int[] arr, int start, int mid, int end) {
    	int sizeArray = end - start +1;
	// gap half of size of array- Mid
    	int gap = sizeArray/2;
    	while(gap>=1) {
            int point1 = start;
            int point2 = start+gap;
            while(point2<=end) {
                if(arr[point1] > arr[point2]) {
			// swap the two pointers and move ahead
                    swap(arr, point1, point2);
                }
                point1++;
                point2++;
            }
            gap = gap/2;
        }
    }
    
    public static void swap( int[] arr , int a, int b) {
    	int intrm =  arr[a];
    	arr[a] = arr[b];
    	arr[b] = intrm;
    }

}

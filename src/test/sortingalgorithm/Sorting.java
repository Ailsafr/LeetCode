package test.sortingalgorithm;

import java.util.Arrays;

/**
 * @author By
 *
 */
public class Sorting {
	
	/**
	 * 我自己写的冒泡排序
	 * @param array
	 */
	public static void bubbleSort(int[] array){
		if(array==null){
			return;
		}
		int len = array.length;
		while(len>1){
			for(int i=0;i<len-1;i++){
				if(array[i]>array[i+1]){
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			len--;
		}
	}
	
	/**
	 * 百度百科的冒泡排序
	 * @param arr
	 */
	public static void bubbleSort1(int[] arr) {
        for(int i=0;i<arr.length-1;i++) { 
        	for(int j=0;j<arr.length-i-1;j++) {//-1为了防止溢出
        		if(arr[j]>arr[j+1]) {
        			int temp = arr[j];
        			arr[j]=arr[j+1];
	            	arr[j+1]=temp;
        		}
        	}    
        }
	}
	
	/**
	 * 我自己写的交换排序
	 * @param array
	 */
	public static void exchangeSort(int[] array){
		for(int i=0;i<array.length;i++){
			int min = Integer.MAX_VALUE;
			for(int j=i;j<array.length;j++){
				if(array[j]<min){
					min = array[j];
					int temp = array[i];
					array[i] = min;
					array[j] = temp;
				}
			}
		}
	}
	
	/**
	 * 百度百科的交换排序
	 * @param array
	 */
	public static void exchangeSort1(int[] array){
		for(int i=0; i<array.length-1; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[i]>array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
	}
	
	/**
	 * 我自己写的快速排序
	 * @param array
	 */
	public static void quickSort(int[] array){
		helper(array,0,array.length-1);
	}
	
	private static void helper(int[] array, int low, int high){
		int l = low;
        int h = high;
        int pivot = array[low];
        
        while(l<h){
            while(l<h&&array[h]>=pivot)
            	h--;
            if(l<h){
            	array[l]=array[h];
            	l++;
            }
            while(l<h&&array[l]<=pivot)
            	l++;
            if(l<h){
            	array[h]=array[l];
            	h--;
            }
        }
        array[l] = pivot;
        if(l-1>low)helper(array,low,l-1);
        if(h+1<high)helper(array,h+1,high);
	}
	
	public static void main(String[] args){
		int[] array = {8,4,3,9,5,7,6};
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
	
}

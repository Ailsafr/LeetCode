package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-03-09
 * Easy
 * Question 088:Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
	
	/**
	 * ���Լ�д�ķ���   һ�ι�  ����̫��ʱ��
	 * ������뵽һ����������һֱ�ڿ��Ǵ��ĸ����ĸ�����ʵ��������Ҫ���˼�ֻҪһ�����ֽ����
	 * ʱ�临�Ӷȣ�O(m*n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = 0;
		for(int i=0;i<m+n;i++){
			if(k<n){
				if(nums1[i]>nums2[k]){
					for(int j=m+n-1;j>i;j--){
						nums1[j]=nums1[j-1];
					}
					nums1[i] = nums2[k];
					k++;
				}
			}
		}
		if(k<n){
			for(int j=k;j<n;j++){
				nums1[m+j] = nums2[j];
			}
		}
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�--�Ӻ�ǰ���ܺõ�˼ά
	 * ʱ�临�Ӷȣ�O(n+m)
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * @return
	 */
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		int k = m+n-1;
		while(i >=0 && j>=0){
			if(nums1[i] > nums2[j]){
				nums1[k--] = nums1[i--];
			}
			else{
				nums1[k--] = nums2[j--];
			}
		}
		while(j>=0){
			nums1[k--] = nums2[j--];
    	}
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[6];
		nums1[0] = 1;
		nums1[1] = 3;
		nums1[2] = 5;
		int[] nums2 = {2,4,6};
		merge(nums1,3,nums2,3);

		System.out.println(Arrays.toString(nums1));
	}

}

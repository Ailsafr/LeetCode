package solution.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-07-26
 * Easy
 * Question 350: Intersection of Two Arrays II.
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		int[] res = {};
		if(nums1.length==0||nums2.length==0){
			return res;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums1.length;i++){
			if(map.containsKey(nums1[i])){
				map.put(nums1[i], map.get(nums1[i])+1);
			}else{
				map.put(nums1[i], 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums2.length;i++){
			if(map.containsKey(nums2[i])){
				if(map.get(nums2[i])>0){
					list.add(nums2[i]);
				}
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		int[] result = new int[list.size()];
		int k = 0;
		for(int i:list){
			result[k++] = i;
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }
    
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
    
       return r;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(n)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1};
		System.out.println(intersect(nums1,nums2));
	}

}

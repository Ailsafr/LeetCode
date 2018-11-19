package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-11-19
 * Easy
 * Question 599:Minimum Index Sum of Two Lists.
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum. 
 * If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * 1.The length of both lists will be in the range of [1, 1000].
 * 2.The length of strings in both lists will be in the range of [1, 30].
 * 3.The index is starting from 0 to the list length minus 1.
 * 4.No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(2*l1+l2) 
	 * 空间复杂度：O(l1+l2)
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static String[] findRestaurant(String[] list1, String[] list2) {
		Map<String,Integer> map1 = new HashMap<String,Integer>();
		Map<String,Integer> map2 = new HashMap<String,Integer>();
		for(int i=0;i<list1.length;i++){
			map1.put(list1[i], i);
		}
		for(int i=0;i<list2.length;i++){
			map2.put(list2[i], i);
		}
		List<String> list = new ArrayList<String>();
		int num = Integer.MAX_VALUE;
		for(String key:map1.keySet()){
			if(map2.containsKey(key)){
				int temp = map1.get(key)+map2.get(key);
				if(temp<num){
					num = temp;
					list.clear();
					list.add(key);
				}else if(temp==num){
					list.add(key);
				}
			}
		}
		String[] array =new String[list.size()];
		return list.toArray(array);
    }
	
	/**
	 * 答案1--Using HashMap[Accepted]
	 * 时间复杂度：O(l1*l2*x)  x refers to average string length.
	 * 空间复杂度：O(l1*l2*x)
	 * @param list1
	 * @param list2
	 * @return
	 */
	public String[] findRestaurant1(String[] list1, String[] list2) {
        HashMap < Integer, List < String >> map = new HashMap < > ();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList < String > ());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
	
	/**
	 * 答案2--Without Using HashMap[Accepted]
	 * 时间复杂度：O((l1+l2)^2*x) x refers to the average string length.
	 * 空间复杂度：O(r*x) res list is used to store the result. Assuming r is the length of res.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public String[] findRestaurant2(String[] list1, String[] list2) {
        List < String > res = new ArrayList < > ();
        for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for (int i = 0; i <= sum; i++) {
                if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i]))
                    res.add(list1[i]);
            }
            if (res.size() > 0)
                break;
        }
        return res.toArray(new String[res.size()]);
    }
    
    /**
	 * 答案3--Using HashMap (linear)[Accepted],跟我的答案思路一样
	 * 时间复杂度：O(l1+l2) 
	 * 空间复杂度：O(l1*x) x refers to average string length.
	 * @param list1
	 * @param list2
	 * @return
	 */
	public String[] findRestaurant3(String[] list1, String[] list2) {
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List < String > res = new ArrayList < > ();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
    
	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		System.out.println(findRestaurant(list1,list2)[0]);
	}

}

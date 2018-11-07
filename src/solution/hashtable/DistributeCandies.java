package solution.hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author By RuiCUI
 * 2018-11-07
 * Easy
 * Question 575:Distribute Candies.
 * Given an integer array with even length, where different numbers in this array represent different kinds of candies. 
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. 
 * Return the maximum number of kinds of candies the sister could gain.
 * Example 1:
 * Input: candies = [1,1,2,2,3,3]
 * Output: 3
 * Explanation:
 * There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
 * The sister has three different kinds of candies. 
 * Example 2:
 * Input: candies = [1,1,2,3]
 * Output: 2
 * Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
 * The sister has two different kinds of candies, the brother has only one kind of candies. 
 * Note:
 * 1.The length of the given array is in range [2, 10,000], and will be even.
 * 2.The number in given array is in range [-100,000, 100,000].
 * Hint:
 * 1.To maximize the number of kinds of candies, we should try to distribute candies such that sister will gain all kinds.
 * 2.What is the upper limit of the number of kinds of candies sister will gain? Remember candies are to distributed equally.
 * 3.Which data structure is the most suitable for finding the number of kinds of candies?
 * 4.Will hashset solves the problem? Inserting all candies kind in the hashset and then checking its size with upper limit.
 */
public class DistributeCandies {

	/**
	 * 我自己写的方法,其实不用判断set.contains
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param candies
	 * @return
	 */
	public static int distributeCandies(int[] candies) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:candies){
			if(set.contains(i)){
				continue;
			}else{
				set.add(i);
			}
		}
		int len = candies.length/2;
		if(len>set.size()){
			return set.size();
		}
		return len;
    }
	
	/**
	 * 答案1--Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n!) 
	 * 空间复杂度：O(n)
	 * @param candies
	 * @return
	 */
	int max_kind = 0;
    public int distributeCandies1(int[] candies) {
        permute(candies, 0);
        return max_kind;
    }
    public void permute(int[] candies, int l) {
        if (l == candies.length - 1) {
            HashSet < Integer > set = new HashSet < > ();
            for (int i = 0; i < candies.length / 2; i++) {
                set.add(candies[i]);
            }
            max_kind = Math.max(max_kind, set.size());
        }
        for (int i = l; i < candies.length; i++) {
            swap(candies, i, l);
            permute(candies, l + 1);
            swap(candies, i, l);
        }
    }
    public void swap(int[] candies, int x, int y) {
        int temp = candies[x];
        candies[x] = candies[y];
        candies[y] = temp;
    }
	
	/**
	 * 答案2--Better Brute Force[Time Limit Exceeded]
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(1)
	 * @param candies
	 * @return
	 */
    public int distributeCandies2(int[] candies) {
        int count = 0;
        for (int i = 0; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] != Integer.MIN_VALUE) {
                count++;
                for (int j = i + 1; j < candies.length; j++) {
                    if (candies[j] == candies[i])
                        candies[j] = Integer.MIN_VALUE;
                }
            }
        }
        return count;
    }
    
    /**
	 * 答案3--Using sorting[Accepted]
	 * 时间复杂度：O(nlogn) 
	 * 空间复杂度：O(1)
	 * @param candies
	 * @return
	 */
    public int distributeCandies3(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
    
    /**
	 * 答案4--Using set[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param candies
	 * @return
	 */
    public int distributeCandies4(int[] candies) {
        HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
    
	public static void main(String[] args) {
		int[] candies = {1,1,2,2,3,3};
		System.out.println(distributeCandies(candies));
	}

}

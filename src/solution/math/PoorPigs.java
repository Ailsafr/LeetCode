package solution.math;

/**
 * @author By RuiCUI
 * 2018-09-07
 * Easy
 * Question 458:Poor Pigs.
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. 
 * They all look the same. If a pig drinks that poison it will die within 15 minutes. 
 * What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
 * Answer this question, and write an algorithm for the follow-up general case.
 * Follow-up:
 * If there are n buckets and a pig drinking poison will die within m minutes, 
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes? 
 * There is exact one bucket with poison.
 */
public class PoorPigs {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param buckets
	 * @param minutesToDie
	 * @param minutesToTest
	 * @return
	 */
	public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int status = minutesToTest/minutesToDie + 1;
        int num_of_pig = 0;
        while(Math.pow(status, num_of_pig) < buckets){
        	num_of_pig++;
        }
        return num_of_pig;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn) 
	 * 空间复杂度：O(1)
	 * @param buckets
	 * @param minutesToDie
	 * @param minutesToTest
	 * @return
	 */
	public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
		int status = minutesToTest/minutesToDie + 1;
        int num_of_pig = 0;
        while(Math.pow(status, num_of_pig) < buckets){
        	num_of_pig++;
        }
        return num_of_pig;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(logn) 
	 * 空间复杂度：O(1)
	 * @param buckets
	 * @param minutesToDie
	 * @param minutesToTest
	 * @return
	 */
	public int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
	    if (buckets < 2) return 0;
	    if (minutesToDie > minutesToTest) return Integer.MAX_VALUE;
	    int k = minutesToTest / minutesToDie;
	    return (int)Math.ceil((Math.log(buckets) / Math.log(k + 1)));
	}
   
	public static void main(String[] args) {
		int num = 9;
		System.out.println(poorPigs(num,num,num));
	}

}

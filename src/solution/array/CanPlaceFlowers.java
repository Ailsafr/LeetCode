package solution.array;

/**
 * @author By RuiCUI
 * 2018-11-20
 * Easy
 * Question 605:Can Place Flowers.
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * 1.The input array won't violate no-adjacent-flowers rule.
 * 2.The input array size is in the range of [1, 20000].
 * 3.n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
	
	/**
	 * 答案1--Single Scan[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
	
	/**
	 * 答案2--Optimized[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count>=n)
                return true;
            i++;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] flowerbed = {0,0,1,0,0};
		int n = 2;
		System.out.println(canPlaceFlowers(flowerbed,n));
	}

}

package solution.array;

/**
 * @author By RuiCUI
 * 2018-09-29
 * Easy
 * Question 492:Construct the Rectangle.
 * For a web developer, it is very important to know how to design a web page's size. 
 * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, 
 * whose length L and width W satisfy the following requirements:
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 * Example:
 * Input: 4
 * Output: [2, 2]
 * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,  
 * [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * Note:
 * 1. The given area won't exceed 10,000,000 and is a positive integer
 * 2. The web page's width and length you designed must be positive integers.
 */
public class ConstructTheRectangle {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param area
	 * @return
	 */
	public static int[] constructRectangle(int area) {
		int max = (int) Math.sqrt(area);
		int[] result = new int[2];
		for(int i=1;i<max+1;i++){
			if(area%i==0){
				result[0] = i;
				result[1] = area/i;
			}
		}
		if(result[0]<result[1]){
			int tmp = result[0];
			result[0] = result[1];
			result[1] = tmp;
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样，但是更巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param area
	 * @return
	 */
	public int[] constructRectangle1(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
	}
	
	public static void main(String[] args) {
		int area = 2;
		System.out.println(constructRectangle(area));
	}
}

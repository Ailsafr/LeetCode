package solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-01-09
 * Easy
 * Question 728:Self Dividing Numbers.
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * Example 1:
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 * Hint:
 * For each number in the range, 
 * check whether it is self dividing by converting that number to a character array (or string in Python), 
 * then checking that each digit is nonzero and divides the original number.
 */
public class SelfDividingNumbers {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) where n is the number of integers in the range.
	 * 空间复杂度：O(n) where n is the number of integers in the range.
	 * @param left
	 * @param right
	 * @return
	 */
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<Integer>();
		if(left>right){
			return result;
		}
		for(int i=left;i<=right;i++){
			boolean add = true;
			int n = i;
			while(n>0){
				int s = n%10;
				if(s==0){
					add = false;
					break;
				}else{
					if(i%s!=0){
						add = false;
						break;
					}
				}
				n = n/10;
			}
			if(add){
				result.add(i);
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Brute Force[Accepted]
	 * 时间复杂度：O(n) where n is the number of integers in the range.
	 * 空间复杂度：O(n) where n is the number of integers in the range.
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }
    public boolean selfDividing1(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) > 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		int left = 1;
		int right = 22;
		System.out.println(selfDividingNumbers(left,right));
	}

}

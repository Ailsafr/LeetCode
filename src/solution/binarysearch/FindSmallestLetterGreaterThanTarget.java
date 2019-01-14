package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2019-01-14
 * Easy
 * Question 744:Find Smallest Letter Greater Than Target.
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, 
 * find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * 1.letters has a length in range [2, 10000].
 * 2.letters consists of lowercase letters, and contains at least 2 unique letters.
 * 3.target is a lowercase letter.
 * Hint:
 * Try to find whether each of 26 next letters are in the given string array.
 */
public class FindSmallestLetterGreaterThanTarget {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O（n）
	 * 空间复杂度：O(1)
	 * @param letters
	 * @param target
	 * @return
	 */
	public static char nextGreatestLetter(char[] letters, char target) {
		int n = target;
		char result = letters[0];
		for(char c:letters){
			if(c>n){
				result = c;
				break;
			}
		}
		return result;
    }
	
	
	/**
	 * 答案1--Record Letters Seen[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param letters
	 * @param target
	 * @return
	 */
	public char nextGreatestLetter1(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char c: letters)
            seen[c - 'a'] = true;

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
	
	/**
	 * 答案2--Linear Scan[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param letters
	 * @param target
	 * @return
	 */
	public char nextGreatestLetter2(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
	
	/**
	 * 答案3--Binary Search[Accepted]
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param letters
	 * @param target
	 * @return
	 */
	public char nextGreatestLetter3(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }
	
	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'k';
		System.out.println(nextGreatestLetter(letters,target));
	}

}

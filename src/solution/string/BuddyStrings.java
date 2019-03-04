package solution.string;

/**
 * @author By RuiCUI
 * 2019-03-04
 * Easy
 * Question 859:Buddy Strings.
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * Example 1:
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * Input: A = "", B = "aa"
 * Output: false
 * Note:
 * 1. 0 <= A.length <= 20000
 * 2. 0 <= B.length <= 20000
 * 3. A and B consist only of lowercase letters.
 */
public class BuddyStrings {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean buddyStrings(String A, String B) {
		int lenA = A.length();
		int lenB = B.length();
		if(lenA!=lenB){
			return false;
		}
		if(A.equals(B)){
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;
            for (int c: count)
                if (c > 1) return true;
            return false;
        }
		int a = -1;
		int b = -1;
		for(int i=0;i<lenA;i++){
			if(A.charAt(i)!=B.charAt(i)){
				if(a==-1){
					a = i;
				}else if(b==-1){
					b = i;
				}else{
					return false;
				}
			}
		}
		if(a==-1||b==-1){
			return false;
		}
		return A.charAt(a)==B.charAt(b)&&B.charAt(a)==A.charAt(b);
    }
	
	/**
	 * 答案--Enumerate Cases
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param A
	 * @param B
	 * @return
	 */
	public boolean buddyStrings1(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
	
	public static void main(String[] args) {
		String A = "aaaaaaabc";
		String B = "aaaaaaacb";
		System.out.println(buddyStrings(A,B));
	}

}

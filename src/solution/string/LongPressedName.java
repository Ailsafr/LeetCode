package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-04-01
 * Easy
 * Question 925:Long Pressed Name.
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * Note:
 * 1. name.length <= 1000
 * 2. typed.length <= 1000
 * 3. The characters of name and typed are lowercase letters.
 */
public class LongPressedName {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param name
	 * @param typed
	 * @return
	 */
	public static boolean isLongPressedName(String name, String typed) {
		int len = name.length();
		int lenT = typed.length();
		int i = 0;
		int j = 0;
		while(i<len&&j<lenT){
			if(typed.charAt(j)==name.charAt(i)){
				j++;
				i++;
			}else{
				if(j==0){
					return false;
				}else if(typed.charAt(j-1)==typed.charAt(j)){
					j++;
				}else{
					return false;
				}
			}
		}
		if(i==len){
			return true;
		}
		return false;
    }

	/**
	 * 答案1--Group into Blocks
	 * 时间复杂度：O(N+T), where N,T are the lengths of name and typed.
	 * 空间复杂度：O(N+T), where N,T are the lengths of name and typed.
	 * @param name
	 * @param typed
	 * @return
	 */
	public boolean isLongPressedName1(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        StringBuilder key = new StringBuilder();
        List<Integer> count = new ArrayList();
        int anchor = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || S.charAt(i) != S.charAt(i+1)) { // end of group
                key.append(S.charAt(i));
                count.add(i - anchor + 1);
                anchor = i+1;
            }
        }

        return new Group(key.toString(), count);
    }
	
	/**
	 * 答案2--Two Pointer
	 * 时间复杂度：O(N+T), where N,T are the lengths of name and typed.
	 * 空间复杂度：O(1)
	 * @param name
	 * @param typed
	 * @return
	 */
    public boolean isLongPressedName2(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }
	
	public static void main(String[] args) {
		String name = "dfuyalc";
		String typed = "fuuyallc";
		System.out.println(isLongPressedName(name,typed));
	}

}

class Group {
    String key;
    List<Integer> count;
    Group(String k, List<Integer> c) {
        key = k;
        count = c;
    }
}

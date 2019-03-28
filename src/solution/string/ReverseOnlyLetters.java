package solution.string;

import java.util.Stack;

/**
 * @author By RuiCUI
 * 2019-03-28
 * Easy
 * Question 917:Reverse Only Letters.
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * Note:
 * 1. S.length <= 100
 * 2. 33 <= S[i].ASCIIcode <= 122 
 * 3. S doesn't contain \ or ".
 */
public class ReverseOnlyLetters {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public static String reverseOnlyLetters(String S) {
		String result = "";
		int len = S.length();
		if(len==0){
			return result;
		}
		char[] array = S.toCharArray();
		int i = 0;
		int j = len - 1;
		while(i<=j){
			if((array[i]>64&&array[i]<91)||(array[i]>96&&array[i]<123)){
				if((array[j]>64&&array[j]<91)||(array[j]>96&&array[j]<123)){
					char tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					i++;
					j--;
				}else{
					j--;
				}
			}else{
				i++;
			}
		}
		
		for(char c:array){
			result += c;
		}
		return result;
	}
	
	/**
	 * 答案1--Stack of Letters
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String reverseOnlyLetters1(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }
        return ans.toString();
    }
	
	/**
	 * 答案2--Reverse Pointer
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param S
	 * @return
	 */
	public String reverseOnlyLetters2(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));
            } else {
                ans.append(S.charAt(i));
            }
        }

        return ans.toString();
    }
	
	public static void main(String[] args) {
		String S = "ab-cd";
		System.out.println(reverseOnlyLetters(S));
	}

}

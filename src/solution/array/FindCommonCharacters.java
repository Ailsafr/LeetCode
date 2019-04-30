package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-04-30
 * Easy
 * Question 1002:Find Common Characters.
 * Given an array A of strings made only from lowercase letters, 
 * return a list of all characters that show up in all strings within the list (including duplicates).  
 * For example, if a character occurs 3 times in all strings but not 4 times, 
 * you need to include that character three times in the final answer.
 * You may return the answer in any order.
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * Note:
 * 1. 1 <= A.length <= 100
 * 2. 1 <= A[i].length <= 100
 * 3. A[i][j] is a lowercase letter.
 */
public class FindCommonCharacters {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static List<String> commonChars(String[] A) {
		int len = A.length;
		String s = A[0];
		int[] array = new int[26];
		for(char c:s.toCharArray()){
			array[c-97] += 1;
		}
		for(int i=1;i<len;i++){
			String str = A[i];
			int[] ar = new int[26];
			for(char c:str.toCharArray()){
				ar[c-97] += 1;
			}
			for(int j=0;j<26;j++){
				array[j] = Math.min(array[j], ar[j]);
			}
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<26;i++){
			if(array[i]!=0){
				for(int j=0;j<array[i];j++){
					list.add(((char)(i+97))+"");
				}
			}
		}
		return list;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public List<String> commonChars1(String[] a) {
        int n = a.length;
        int[] freq1 = new int['z'+1];
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        String s = a[0];
        for(char ch : s.toCharArray()){
            freq1[ch]++;
        }
        for(int i=1; i < n; i++){
            int[] freq2 = new int['z'+1];
            for(char ch : a[i].toCharArray()){
                if(freq1[ch] > 0){
                    freq2[ch]++;
                    freq1[ch]--;
                }
            }
            freq1 = freq2;
        }
        for(int i=0; i < 'z'+1; i++){
            if(freq1[i] > 0){
                int count = freq1[i];
                while(count-- > 0)
                    res.add(String.valueOf((char)i));
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] A = {"cool","lock","cook"};
		System.out.println(commonChars(A));
	}
}

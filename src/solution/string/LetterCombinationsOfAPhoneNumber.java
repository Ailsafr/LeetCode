package solution.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-06-11
 * Medium
 * Question 017:Letter Combinations of a Phone Number.
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(3^N*4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.
	 * 空间复杂度：O(3^N*4^M)
	 * @param digits
	 * @return
	 */
	public static List<String> letterCombinations(String digits) {
		Map<Character,Set<Character>> map = new HashMap<Character,Set<Character>>();
		map.put('2', new HashSet<Character>(){{add('a');add('b');add('c');}});
		map.put('3', new HashSet<Character>(){{add('d');add('e');add('f');}});
		map.put('4', new HashSet<Character>(){{add('g');add('h');add('i');}});
		map.put('5', new HashSet<Character>(){{add('j');add('k');add('l');}});
		map.put('6', new HashSet<Character>(){{add('m');add('n');add('o');}});
		map.put('7', new HashSet<Character>(){{add('p');add('q');add('r');add('s');}});
		map.put('8', new HashSet<Character>(){{add('t');add('u');add('v');}});
		map.put('9', new HashSet<Character>(){{add('w');add('x');add('y');add('z');}});
		List<String> result = new ArrayList<String>();
		if("".equals(digits)){
			return result;
		}
		helper(map,result,"",digits);
		return result;
	}
	private static void helper(Map<Character,Set<Character>> map, List<String> list, String str, String digit){
		if(digit.length()==0){
			list.add(str);
		}else{
			char d = digit.charAt(0);
			Set<Character> set = map.get(d);
			for(Iterator<Character> iter = set.iterator();iter.hasNext();){
				char c = iter.next();
				helper(map,list,str+c,digit.substring(1));
			}
		}
	}
	
	/**
	 * 答案--Backtracking
	 * 时间复杂度：O(3^N*4^M) 
	 * 空间复杂度：O(3^N*4^M)
	 * @param digits
	 * @return
	 */
	 Map<String, String> phone = new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	}};
	List<String> output = new ArrayList<String>();
	public void backtrack(String combination, String next_digits) {
	    // if there is no more digits to check
	    if (next_digits.length() == 0) {
	        // the combination is done
	        output.add(combination);
	    }
	    // if there are still digits to check
	    else {
	        // iterate over all letters which map 
	        // the next available digit
	        String digit = next_digits.substring(0, 1);
	        String letters = phone.get(digit);
	        for (int i = 0; i < letters.length(); i++) {
	    	    String letter = phone.get(digit).substring(i, i + 1);
		        // append the current letter to the combination
		        // and proceed to the next digits
		        backtrack(combination + letter, next_digits.substring(1));
	        }
	    }
	}
	public List<String> letterCombinations1(String digits) {
	    if (digits.length() != 0)
	    	backtrack("", digits);
	    return output;
	}
	
	/**
	 * 其他人的答案
	 * 时间复杂度：O(3^N*4^M) 
	 * 空间复杂度：O(3^N*4^M)
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}

}

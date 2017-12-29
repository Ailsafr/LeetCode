package solution.math;

import java.util.HashMap;

/**
 * @author By RuiCUI
 * 2017-12-29
 * Easy
 * Question 013:Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 罗马数字一共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
 * Example:
 * Input: X  Output:10
 * Input: XCIX Output: 99
 */
public class RomanToInteger {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	private static int romanToInt(String s) throws Exception {
		int result = 0;
		if("".equals(s)){
			throw new Exception("Input is not right");
		}
		for(int i=0;i<s.length();i++){
			if(i==0){
				result += getValut(s.substring(0,1));
			}else{
				int beforeNum = getValut(s.substring(i-1,i));
				int thisNum = getValut(s.substring(i,i+1));
				if(beforeNum==0||thisNum==0){
					throw new Exception("Input is not right");
				}
				if(beforeNum>=thisNum){
					result += thisNum;
				}else{
					result = result - 2*beforeNum + thisNum;
				}
			}
		}
		if(result>3999||result<0){
			throw new Exception("Input is not right");
		}
		return result;
    }
	
	private static int getValut(String s){
		switch(s){
			case "I":
				return 1;
			case "V":
				return 5;
			case "X":
				return 10;
			case "L":
				return 50;
			case "C":
				return 100;
			case "D":
				return 500;
			case "M":
				return 1000;
			default:
				return 0;
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,利用HashMap和charAt()方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public static int romanToInt1(String s) {
		if (s == null || s.length() == 0)
			return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length(), result = map.get(s.charAt(len - 1));
		for (int i = len - 2; i >= 0; i--) {
			if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
				result += map.get(s.charAt(i));
			else
				result -= map.get(s.charAt(i));
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		//String s = "MMMCMXCIX";
		//String s = "XCIX";
		String s = "DCXXI";
		System.out.println(romanToInt1(s));
	}

}

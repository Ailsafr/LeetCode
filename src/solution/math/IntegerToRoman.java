package solution.math;

/**
 * @author By RuiCUI
 * 2019-06-05
 * Medium
 * Question 12:Integer to Roman.
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. 
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * Example 1:
 * Input: 3
 * Output: "III"
 * Example 2:
 * Input: 4
 * Output: "IV"
 * Example 3:
 * Input: 9
 * Output: "IX"
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

	/**
	 * 我自己写的方法
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		String result = "";
		if(num>999){
			int n = num/1000;
			while(n>0){
				result += "M";
				n--;
			}
			num = num%1000;
		}
		if(num>99){
			int n = num/100;
			result += helper("C","D","M",n);
			num = num%100;
		}
		if(num>9){
			int n = num/10;
			result += helper("X","L","C",n);
			num = num%10;
		}
		
		result += helper("I","V","X",num);
		
		return result;
    }
	
	private static String helper(String str1, String str2, String str3, int num){
		switch(num){
			case 1: 
				return str1;
			case 2:
				return str1 + str1;
			case 3:
				return str1 + str1 + str1;
			case 4:
				return str1 + str2;
			case 5:
				return str2;
			case 6:
				return str2 + str1;
			case 7:
				return str2 + str1 + str1;
			case 8:
				return str2 + str1 + str1 + str1;
			case 9:
				return str1 + str3;
			default:
				return "";
		}
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public static String intToRoman1(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public String intToRoman2(int num) {

	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		int num = 1994;
		System.out.println(intToRoman(num));
	}

}

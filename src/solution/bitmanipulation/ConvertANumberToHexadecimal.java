package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-08-09
 * Easy
 * Question 405:Convert a Number to Hexadecimal.
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; 
 * otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 */
public class ConvertANumberToHexadecimal {
	
	/**
	 * >>>:无符号右移，忽略符号位，空位都以0补齐
	 * 我自己写的方法,看的别人的
	 * @param num
	 * @return
	 */
	public static String toHex(int num) {
		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public static String toHex1(int num) {
		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public String toHex2(int dec) {
		if (dec == 0) return "0";
		StringBuilder res = new StringBuilder();
	  
		while (dec != 0) {
			int digit = dec & 0xf;
			res.append(digit < 10 ? (char)(digit + '0') : (char)(digit - 10 + 'a'));
			dec >>>= 4;
		}
		return res.reverse().toString();
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public String toHex3(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return sb.append(0).toString();
        int sign = 1;
        int bitNum = 8;
        if (num < 0) {
            num = -num - 1;
            sign = -1;
        }
        
        while (sign == 1 && num != 0) {  // num is positive
            int rest = num % 16;
            if (rest < 10) {
                sb.append(rest);
            }
            else {
                sb.append((char)('a' + rest - 10));
            }
            num /= 16;
        }
        
        while (sign == -1 && bitNum > 0) {  // num is negative
            int rest = num % 16;
            if (rest < 6) {
                sb.append((char)('f' - rest));
            }
            else {
                sb.append(15 - rest);
            }
            num /= 16;
            bitNum--;
        }
        
        return sb.reverse().toString();
    } 
	
	public static void main(String[] args) {
		int num = -1;
		System.out.println(toHex(num));
	}

}

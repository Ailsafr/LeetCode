package solution.math;

/**
 * @author By RuiCUI
 * 2018-08-15
 * Easy
 * Question 415:Add Strings.
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings(String num1, String num2) {
		StringBuilder str1 = new StringBuilder(num1);	                  
		String string1 = str1.reverse().toString();
		StringBuilder str2 = new StringBuilder(num2);	                  
		String string2 = str2.reverse().toString();
		int l1 = string1.length();
		int l2 = string2.length();
		int len = l1>l2?l2:l1;
		boolean plus = false;
		String result = "";
		for(int i=0;i<len;i++){
			char a = string1.charAt(i);
			char b = string2.charAt(i);
			int num = a + b;
			if(num>105){
				if(plus){
					result += (char)(num-57);
				}else{
					result += (char)(num-58);
				}
				plus = true;
			}else if(num==105){
				if(plus){
					result += '0';
					plus = true;
				}else{
					result += '9';
					plus = false;
				}
			}else{
				if(plus){
					result += (char)(num-47);
				}else{
					result += (char)(num-48);
				}
				plus = false;
			}
		}
		
		if(l1>l2){
			for(int i=len;i<l1;i++){
				char a = string1.charAt(i);
				if(plus){
					if(a=='9'){
						result += '0';
						plus = true;
					}else{
						result += (char)(a+1);
						plus = false;
					}
				}else{
					result += a;
				}
			}
		}else{
			for(int i=len;i<l2;i++){
				char a = string2.charAt(i);
				if(plus){
					if(a=='9'){
						result += '0';
						plus = true;
					}else{
						result += (char)(a+1);
						plus = false;
					}
				}else{
					result += a;
				}
			}
		}
		if(plus){
			result += '1';
		}
		StringBuilder str = new StringBuilder(result);	                  
		String ret = str.reverse().toString();
		return ret;
    }
	
	/*
	Char("48") 0 
	Char("49") 1
	Char("50") 2
	Char("51") 3
	Char("52") 4
	Char("53") 5
	Char("54") 6
	Char("55") 7
	Char("56") 8
	Char("57") 9
	*/
	
	/**
	 * 官网没有solution,这是其他人的答案,思维很巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟上个答案原理一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int a = i >= 0 ? (num1Array[i--] - '0') : 0;
            int b = j >= 0 ? (num2Array[j--] - '0') : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String a = "21196";
		String b = "1101";
		System.out.println(addStrings(a,b));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2018-03-01
 * Easy
 * Question 067:Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
		String result = "";
		if("0".equals(a)){
			return b;
		}else if("0".equals(b)){
			return a;
		}
		int al = a.length();
		int bl = b.length();
		if(al>bl){
			for(int i=0;i<al-bl;i++){
				b = "0" + b;
			}
		}else{
			for(int i=0;i<bl-al;i++){
				a = "0" + a;
			}
		}
		boolean jinwei = false;
		for(int i=a.length()-1;i>=0;i--){
			if("1".equals(a.substring(i,i+1))){
				if("1".equals(b.substring(i,i+1))){
					if(jinwei){
						result = "1" + result;
					}else{
						result = "0" + result;
					}
					jinwei = true;
				}else{
					if(jinwei){
						result = "0" + result;
						jinwei = true;
					}else{
						result = "1" + result;
						jinwei = false;
					}
				}
			}else{
				if("1".equals(b.substring(i,i+1))){
					if(jinwei){
						result = "0" + result;
						jinwei = true;
					}else{
						result = "1" + result;
						jinwei = false;
					}
				}else{
					if(jinwei){
						result = "1" + result;
					}else{
						result = "0" + result;
					}
					jinwei = false;
				}
			}
		}
		if(jinwei){
			result = "1" + result;
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,思维很巧妙
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		String a = "1111";
		String b = "1101";
		System.out.println(addBinary1(a,b));
		

	}

}

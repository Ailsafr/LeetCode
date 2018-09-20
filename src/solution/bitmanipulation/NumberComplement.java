package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-09-20
 * Easy
 * Question 476:Number Complement.
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class NumberComplement {
	
	/**
	 * 我自己写的方法
	 * @param num
	 * @return
	 */
	public static int findComplement(int num) {
		String bNum = Integer.toBinaryString(num);
		String str = "";
		int i = 0;
		int len = bNum.length();
		while(i<len){
			str += "1";
			i++;
		}
		int n = Integer.parseInt(str, 2);
		int result = num^n;
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public int findComplement1(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param nums
	 * @return
	 */
	public int findComplement2(int num) 
    {
        int i = 0;
        int j = 0;
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }

	/**
	 * 官网没有solution,这是其他人的答案
	 * @param num
	 * @return
	 */
	public int findComplement3(int num) {
	    int x=1,i=1;
	    while(x<=num && i<32)
	    {
	        num=num^x;
	        x=x<<1;
	        i++;
	    }
	    return num;
	}
	
	public static void main(String[] args) {
		int num = 1;
		System.out.println(findComplement(num));
	}

}

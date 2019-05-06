package solution.math;

/**
 * @author By RuiCUI
 * 2019-05-06
 * Easy
 * Question 1009:Complement of Base 10 Integer.
 * Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.
 * Note that except for N = 0, there are no leading zeroes in any binary representation.
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.
 * For example, the complement of "101" in binary is "010" in binary.
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * Note:
 * 1. 0 <= N < 10^9.
 * Hint:
 * 1. A binary number plus its complement will equal 111....111 in binary. Also, N = 0 is a corner case.
 */
public class ComplementOfBase10Integer {

	/**
	 * 我自己写的方法
	 * @param N
	 * @return
	 */
	public static int bitwiseComplement(int N) {
		String str = Integer.toBinaryString(N);
		String result = "";
		for(char c:str.toCharArray()){
			if('0'==c){
				result += "1";
			}else{
				result += "0";
			}
		}
		return Integer.parseInt(result, 2);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param N
	 * @return
	 */
	public int bitwiseComplement1(int N) {

	    int noOfbits=(int)(Math.log(N)/Math.log(2))+1; //getting min num of bits to represent number N
	    int i=-1<<noOfbits; 
	    
	    /*-1 is a number with all set bits and 
	    left shifting the bits to get 0 in only the required bits*/
	    
	    N=i^N; 
	    /*xor of that number with all set bits expect 
	    the noOfbits used to represent a number which will 
	    give the present number's bit along with the previous bits will 
	    all get set so that complement will make them all zero.*/
	        
	    
	    return ~N;
	}
	
	public static void main(String[] args) {
		int N = 0;
		System.out.println(bitwiseComplement(N));
	}

}

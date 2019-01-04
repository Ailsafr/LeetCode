package solution.array;

/**
 * @author By RuiCUI
 * 2019-01-04
 * Easy
 * Question 717:1-bit and 2-bit Characters.
 * We have two special characters. The first character can be represented by one bit 0. 
 * The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. 
 * Return whether the last character must be a one-bit character or not. 
 * The given string will always end with a zero.
 * Example 1:
 * Input: 
 * bits = [1, 0, 0]
 * Output: True
 * Explanation: 
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input: 
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation: 
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * 1.1 <= len(bits) <= 1000.
 * 2.bits[i] is always 0 or 1.
 * Hint:
 * Keep track of where the next character starts. At the end, you want to know if you started on the last bit.
 */
public class OneBitAndTwoBitCharacters {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param bits
	 * @return
	 */
	public static boolean isOneBitCharacter(int[] bits) {
		if(bits==null||bits.length==0){
			return false;
		}
		int len = bits.length;
		for(int i=0;i<len;i++){
			if(bits[i]==1){
				i++;
			}else{
				if(i==len-1){
					return true;
				}
			}
		}
		return false;
    }
	
	/**
	 * 答案1--Increment Pointer[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param bits
	 * @return
	 */
	public boolean isOneBitCharacter1(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
	
	/**
	 * 答案2--Greedy[Accepted]
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param bits
	 * @return
	 */
	public boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }
	
	public static void main(String[] args) {
		int[] bits = {1, 0, 0};
		System.out.println(isOneBitCharacter(bits));
	}

}

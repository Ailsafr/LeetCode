package solution.string;

/**
 * @author By RuiCUI
 * 2018-08-24
 * Easy
 * Question 443:String Compression.
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * Example 1:
 * Input:
 * ['a','a','b','b','c','c','c']
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
 * Explanation:
 * 'aa' is replaced by 'a2'. 'bb' is replaced by 'b2'. 'ccc' is replaced by 'c3'.
 * Example 2:
 * Input:
 * ['a']
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ['a']
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
 * Explanation:
 * Since the character 'a' does not repeat, it is not compressed. 'bbbbbbbbbbbb' is replaced by 'b12'.
 * Notice each digit has it's own entry in the array.
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * Hint:  
 * How do you know if you are at the end of a consecutive group of characters?
 */
public class StringCompression {

	/**
	 * 我自己写的方法,参考的答案,我刚开始写的方法只考虑了返回值,忽略了数组也要变为相应的值
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param chars
	 * @return
	 */
	public static int compress(char[] chars) {
		int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
	
	/**
	 * 答案1-- Read and Write Heads
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param chars
	 * @return
	 */
	public int compress1(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
	
	/**
	 * 别人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param chars
	 * @return
	 */
	public int compress2(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
	
	/**
	 * 别人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param chars
	 * @return
	 */
	public int compress3(char[] chars) {        
        int start = 0;
        for(int end = 0, count = 0; end < chars.length; end++) {
            count++;
            if(end == chars.length-1 || chars[end] != chars[end + 1] ) {
                //We have found a difference or we are at the end of array
                chars[start] = chars[end]; // Update the character at start pointer
                start++;
                if(count != 1) {
                    // Copy over the character count to the array
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int i=0;i<arr.length;i++, start++)
                        chars[start] = arr[i];
                }
                // Reset the counter
                count = 0;
            }
        }
        return start;
    }
	
	public static void main(String[] args) {
		//char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		char[] chars = {'a','a'};
		System.out.println(compress(chars));
	}

}

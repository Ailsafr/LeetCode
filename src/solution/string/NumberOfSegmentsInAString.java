package solution.string;

/**
 * @author By RuiCUI
 * 2018-08-20
 * Easy
 * Question 434:Number of Segments in a String.
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class NumberOfSegmentsInAString {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public static int countSegments(String s) {
		String[] strs = s.split(" ");
		int result = 0;
		for(String str:strs){
			if(!"".equals(str)){
				result += 1;
			}
		}
		return result;
    }
	
	/**
	 * 答案1--Using Language Builtins
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
	public int countSegments1(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
	
	/**
	 * 答案2--In-place
	 * 时间复杂度：O(S) 
	 * 空间复杂度：O(1)
	 * @param s
	 * @return
	 */
	public int countSegments2(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
	
	public static void main(String[] args) {
		String s = "Hello, my name is  John";
		System.out.println(countSegments(s));
	}

}

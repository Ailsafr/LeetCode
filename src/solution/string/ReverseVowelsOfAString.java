package solution.string;

/**
 * @author By RuiCUI
 * 2018-07-24
 * Easy
 * Question 345:Reverse Vowels of a String.
 * Write a function that takes a string as input and reverse only the vowels of a string.  vowels-Ԫ����ĸ��a��e��i��o��u��
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
	
	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param s
	 * @return
	 */
	public static String reverseVowels(String s) {
		if(s.length()<2){
			return s;
		}
		int i=0,j=s.length()-1;
		char[] array = s.toCharArray();
		while(i<j){
			if(isVowel(array[i])){
				if(isVowel(array[j])){
					char tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					i++;
					j--;
				}else{
					j--;
				}
			}else{
				i++;
			}
		}
		return new String(array);
    }
	
	private static boolean isVowel(char c){
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
			return true;
		}
		return false;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,���ҵ�˼·һ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param s
	 * @return
	 */
	public String reverseVowels1(String s) {
	    if(s == null || s.length()==0) return s;
	    String vowels = "aeiouAEIOU";
	    char[] chars = s.toCharArray();
	    int start = 0;
	    int end = s.length()-1;
	    while(start<end){
	        
	        while(start<end && !vowels.contains(chars[start]+"")){
	            start++;
	        }
	        
	        while(start<end && !vowels.contains(chars[end]+"")){
	            end--;
	        }
	        
	        char temp = chars[start];
	        chars[start] = chars[end];
	        chars[end] = temp;
	        
	        start++;
	        end--;
	    }
	    return new String(chars);
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1) 
	 * @param s
	 * @return
	 */
	public String reverseVowels2(String s) {
	    StringBuilder sb = new StringBuilder();
	    int j = s.length() - 1;
	    for (int i = 0; i < s.length(); i++)
	    {
	        if ("AEIOUaeiou".indexOf(s.charAt(i)) != -1)
	        {
	            while (j >= 0 && "AEIOUaeiou".indexOf(s.charAt(j)) == -1)
	            {
	                j--;
	            }
	            sb.append(s.charAt(j));
	            j--;
	        }
	        else
	            sb.append(s.charAt(i));
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		String str = "leetcode";
		System.out.println(reverseVowels(str));
	}

}

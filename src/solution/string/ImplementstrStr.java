package solution.string;

/**
 * @author By RuiCUI
 * 2018-01-25
 * Easy
 * Question 028:Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class ImplementstrStr {
		
	/**
	 * ���Լ�д�ķ�����͵���ˣ�ò�Ʋ�����Ŀ���⣩
	 * @param haystack
	 * @param needle
	 * @return
	 */
	private static int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
    }
	
	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(1)
	 * @param haystack
	 * @param needle
	 * @return
	 */
	private static int strStr1(String haystack, String needle) {
		int i,j = 0;
		for(i=0;i<haystack.length()&&j<needle.length();i++){
			if(haystack.charAt(i)==needle.charAt(j)){
				j++;
			}else{
				if(j==needle.length()){
					return i-j;
				}else{
					i = i-j;
					j = 0;
				}
			}
		}
		if(j==needle.length()){
			return i-j;
		}else{
			return -1;
		}
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,����subString
	 * ʱ�临�Ӷȣ�O(S)
	 * �ռ临�Ӷȣ�O(1)
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr2(String haystack, String needle) {
		int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,����д�ķ���˼����
	 * ʱ�临�Ӷȣ�O(S^2)
	 * �ռ临�Ӷȣ�O(1)
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr3(String haystack, String needle) {
		for(int i=0;;i++){
			for(int j=0;;j++){
				if(j==needle.length()) return i;
				if(i+j==haystack.length()) return -1;
				if(needle.charAt(j)!=haystack.charAt(i+j)) break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(strStr1("hello","ll"));
		System.out.println(strStr1("aaaaa","bba"));
	}

}

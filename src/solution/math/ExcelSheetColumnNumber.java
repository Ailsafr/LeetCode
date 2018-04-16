package solution.math;

/**
 * @author By RuiCUI
 * 2018-04-16
 * Easy
 * Question 171:Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {

	/**
	 * ���Լ�д�ķ���--�������������εģ����˴�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param s
	 * @return
	 */
	public static int titleToNumber(String s) {
		int result  = 0;
        for (int i = 0; i < s.length(); i++){
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1);    
        }
        return result;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param s
	 * @return
	 */
	public static int titleToNumber1(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++);
		return result;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,˼·��һ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param s
	 * @return
	 */
	public int titleToNumber2(String s) {
	    int result = 0;
	    for(int i = 0 ; i < s.length(); i++) {
	      result = result * 26 + (s.charAt(i) - 'A' + 1);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String s = "AJHX";
		System.out.println(titleToNumber(s));
	}

}

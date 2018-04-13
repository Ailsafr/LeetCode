package solution.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-04-12
 * Easy
 * Question 168:Excel Sheet Column Title.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {
		String result = "";
		List<Integer> list = new ArrayList<Integer>();
		while(n>26){
			int ys = n%26;
			if(ys!=0){
				list.add(0, ys);
				n = n/26;
			}else{
				list.add(0,26);
				n = n/26-1;
			}
		}
		list.add(0,n);
		for(int i=0;i<list.size();i++){
			result += (char)(list.get(i)+64);
		}
		return result;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,˼ά������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
	public static String convertToTitle1(int n) {
		return n == 0 ? "" : convertToTitle1(--n / 26) + (char)('A' + (n % 26));
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,˼ά������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
	public String convertToTitle2(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,˼ά������
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
	public String convertToTitle3(int n) {
	    String res = "";
	    while(n != 0) {
	        char ch = (char)((n - 1) % 26 + 65);
	        n = (n - 1) / 26;
	        res = ch + res;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int n = 27;
		System.out.println(convertToTitle(n));
	}

}

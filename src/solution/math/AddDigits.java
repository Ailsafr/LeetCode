package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-09
 * Easy
 * Question 258:Add Digits.
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Example:
 * Input: 38
 * Output: 2 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * Hints
 * A naive implementation of the above process is trivial. Could you come up with other methods?
 * What are all the possible results?
 * How do they occur, periodically or randomly?
 * You may find this Wikipedia article useful.
 */
public class AddDigits {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		if(num<10){
			return num;
		}
		while(num>9){
			int result = 0;
			String str = Integer.toString(num);
			for(int i=0;i<str.length();i++){
				result += Integer.parseInt(str.substring(i,i+1));
			}
			num = result;
		}
		return num;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,˼ά������
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public int addDigits1(int num) {
        return num==0?0:(num%9==0?9:(num%9));
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public int sumDigits(int num){
	    if(num==0)
	        return 0;
	    return (num%10) + sumDigits(num/10);
	}
	
	public static void main(String[] args) {
		int num = 38;
		System.out.println(addDigits(num));
	}

}

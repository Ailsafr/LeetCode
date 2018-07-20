package solution.math;

/**
 * @author By RuiCUI
 * 2018-07-20
 * Easy
 * Question 342:Power of Four.
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * Credits:
 * Special thanks to @yukuairoy for adding this problem and creating all test cases.
 */
public class PowerOfFour {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(log4n) 4Ϊ����
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public static boolean isPowerOfFour(int num) {
		if (num < 1) {
            return false;
        }
        while (num % 4 == 0) {
        	num /= 4;
        }
        return num == 1;
    }
	
	/**
	 * ����û��solution,���Ƿ�����Power Of Three�Ĵ�
	 * ʱ�临�Ӷȣ�O(log4n) 4Ϊ����
	 * �ռ临�Ӷȣ�O(log4n) 4Ϊ����
	 * @param num
	 * @return
	 */
	public static boolean isPowerOfFour1(int num) {
		return Integer.toString(num, 4).matches("^10*$");
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * @param num
	 * @return
	 */
	public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }
	
	public static void main(String[] args) {
		int n = 16;
		System.out.println(isPowerOfFour(n));
	}

}

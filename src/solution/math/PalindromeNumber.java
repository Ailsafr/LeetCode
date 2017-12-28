package solution.math;

/**
 * @author By RuiCUI
 * 2017-12-28
 * Easy
 * Question 009:Determine whether an integer is a palindrome. Do this without extra space.
 * ��n��һ������Ȼ��������n�ĸ�λ���ַ�������������Ȼ��n1��n��ȣ����nΪһ������
 * ע�⣺�������ǻ�����
 * Example:
 * Input: 123     Output:false
 * Input: 1235321 Output: true
 * Input: 126621  Output: true
 */
public class PalindromeNumber {

	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n/2)
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @return
	 */
	private static boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}else if(x<10){
			return true;
		}
		int n = (int) Math.log10(x);
		for(int i=0;i<n;i++){
			if(i>=n-i){
				return true;
			}else{
				if(((int) (x/Math.pow(10, (n-i))))==((int) (x/Math.pow(10, i)%10))){
					x = (int) (x%(Math.pow(10, (n-i))));
				}else{
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * ��1--��ת��һ�������
	 * ʱ�临�Ӷȣ�O(log10n) logʮn
	 * �ռ临�Ӷȣ�O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean isPalindrome1(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }

	public static void main(String[] args) {
		//int x = 126787621;
		int x = 1000021;
		System.out.println(isPalindrome1(x));
	}

}

package solution.math;

/**
 * @author By RuiCUI
 * 2018-04-20
 * Easy
 * Question 172:Factorial Trailing Zeroes.
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	/**
	 * ���Լ�д�ķ���--���ı��˵Ĵ𰸣���Ϊ��û��������һ���±ư�����ʲô�⣬Ȼ��û�뵽��˼򵥡�����
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
    public static int trailingZeroes(int n) {
    	return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    
    /**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
    public static int trailingZeroes1(int n) {
        int cnt = 0;
        while(n>0){
            cnt += n/5;
            n/=5;
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		int n= 29;
		System.out.println(trailingZeroes(n));
	}

}

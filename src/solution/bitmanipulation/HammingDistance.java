package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-09-13
 * Easy
 * Question 461:Hamming Distance.
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 �� x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ��   ��
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
	
	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(1) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance(int x, int y) {
		int res = x^y;
		return Integer.bitCount(res);
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,���ҵ�һ��
	 * ʱ�临�Ӷȣ�O(1) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * ʱ�临�Ӷȣ�O(1) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance2(int x, int y) {
	    int xor = x ^ y, count = 0;
	    for (int i=0;i<32;i++) count += (xor >> i) & 1;
	    return count;
	}
	
	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		System.out.println(hammingDistance(x,y));
	}

}

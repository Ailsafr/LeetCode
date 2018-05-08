package solution.bitmanipulation;

/**
 * @author By RuiCUI
 * 2018-05-08
 * Easy
 * Question 191:Number of 1 Bits.
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * Example 1:
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
 * Example 2:
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
public class NumberOf1Bits {
	
	/**
	 * ���Լ�д�ķ���,����toBinaryString����
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	String s = Integer.toBinaryString(n);
    	int result = 0;
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='1'){
    			result +=1;
    		}
    	}
		return result;
    }
    
    /**
	 * ��1--Loop and Flip ��λ��& (��Ϊ1Ϊ1������Ϊ0)
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    
    /**
	 * ��2--Bit Manipulation Trick ��λ��& (��Ϊ1Ϊ1������Ϊ0) ��������û��ǣ����Ǹо������뵽
	 * ʱ�临�Ӷȣ�O(1)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
	// you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    
	public static void main(String[] args) {
		//int n = -43261596;
		int n = -1;
		//int n = 0;
		System.out.println(hammingWeight(n));
	}

}

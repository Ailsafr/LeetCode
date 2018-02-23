package solution.array;

import java.util.Arrays;

/**
 * @author By RuiCUI
 * 2018-02-23
 * Easy
 * Question 066:Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	
	/**
	 * ���Լ�д�ķ���
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if(digits[length-1]!=9){
        	digits[length-1] = digits[length-1]+1;
        	return digits;
        }
        for(int i=length-1;i>=0;i--){
        	if(digits[i]==9){
        		digits[i] = 0;
            }else{
            	digits[i] = digits[i]+1;
            	break;
            }
        	if(i==0){
        		digits[0] = 1;
        		digits = Arrays.copyOf(digits, length+1);
        	}
        }
        return digits;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�--���ҵ��뷨��࣬���ҵļ�㣨ע�⣺�½�������ÿ���Ĭ��ֵΪ���������͵�Ĭ��ֵ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param digits
	 * @return
	 */
	public int[] plusOne1(int[] digits) {
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        
	        digits[i] = 0;
	    }
	    
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    
	    return newNumber;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�--���ҵķ�����ࣨע�⣺�½�������ÿ���Ĭ��ֵΪ���������͵�Ĭ��ֵ��
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param digits
	 * @return
	 */
	public int[] plusOne2(int[] digits) {
	    for (int i = digits.length - 1; i >=0; i--) {
	        if (digits[i] != 9) {
	            digits[i]++;
	            break;
	        } else {
	            digits[i] = 0;
	        }
	    }
	    if (digits[0] == 0) {
	        int[] res = new int[digits.length+1];
	        res[0] = 1;
	        return res;
	    }
	    return digits;
	}
	
	public static void main(String[] args) {
		int[] nums = {9};
		System.out.println(plusOne(nums));
	}
}

package solution.math;

/**
 * @author By RuiCUI
 * 2018-10-12
 * Easy
 * Question 507:Perfect Number.
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class PerfectNumber {

	/**
	 * ���Լ�д�ķ���[Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public static boolean checkPerfectNumber(int num) {
		if(num<=0){
			return false;
		}
		int n = num/2;
		int result = num-1;
		for(int i=2;i<=n;i++){
			if(num%i==0){
				result = result-i;
			}
		}
		if(result==0){
			return true;
		}
		return false;
    }
	
	/**
	 * ��1--Brute Force [Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1)
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber1(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }

        }
        return sum == num;
    }
	
	/**
	 * ��2--Better Brute Force [Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n) 
	 * �ռ临�Ӷȣ�O(1) 
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber2(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
            if(sum>num) {
                return false;
            }
        }
        return sum == num;
    }
    
    /**
	 * ��3--Optimal Solution [Accepted]
	 * ʱ�临�Ӷȣ�O(sqrt(n))
	 * �ռ临�Ӷȣ�O(1) 
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber3(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;
    }
    
    /**
	 * ��4--Euclid-Euler Theorem [Accepted]
	 * ʱ�临�Ӷȣ�O(logn)
	 * �ռ临�Ӷȣ�O(logn)
	 * @param num
	 * @return
	 */
	public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    public boolean checkPerfectNumber4(int num) {
        int[] primes=new int[]{2,3,5,7,13,17,19,31};
        for (int prime: primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }
    
	public static void main(String[] args) {
		int num = 29;
		System.out.println(checkPerfectNumber(num));
	}

}

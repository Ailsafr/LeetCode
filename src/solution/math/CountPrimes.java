package solution.math;

/**
 * @author By RuiCUI
 * 2018-05-21
 * Easy
 * Question 204:Count Primes.
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

	/**
	 * ���Լ�д�ķ���-Time Limit Exceeded
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n) {
		if(n<3){
			return 0;
		}
		int result = 0;
		for(int i=2;i<n;i++){
			if(isPrime(i)){
				result += 1;
			}
		}
		return result;
    }
	
	private static boolean isPrime(int number){
        for(int i=2;i<=number/2;i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 * @param n
	 * @return
	 */
	public int countPrimes1(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,����һ��������㷨
	 * @param n
	 * @return
	 */
	public int countPrimes2(int n){
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,����һ��������㷨
	 * @param n
	 * @return
	 */
	public int countPrimes3(int n) {
	    if (n < 3)
	        return 0;
	        
	    boolean[] f = new boolean[n];
	    //Arrays.fill(f, true); boolean[] are initialed as false by default
	    int count = n / 2;
	    for (int i = 3; i * i < n; i += 2) {
	        if (f[i])
	            continue;
	        
	        for (int j = i * i; j < n; j += 2 * i) {
	            if (!f[j]) {
	                --count;
	                f[j] = true;
	            }
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.println(countPrimes(n));
	}

}

package solution.math;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author By RuiCUI
 * 2018-09-21
 * Easy
 * Question 479:Largest Palindrome Product.
 * Find the largest palindrome made from the product of two n-digit numbers.
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * Example:
 * Input: 2
 * Output: 987
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * Note:
 * The range of n is [1,8].
 */
public class LargestPalindromeProduct {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int largestPalindrome(int n) {
	    int max = (int)Math.pow(10, n) - 1;
	    int min = max - (int)Math.pow(10, (n + 1) >> 1);
	    	
	    Comparator<int[]> cmp = new Comparator<int[]>() {
	    	@Override
		public int compare(int[] a, int[] b) {
	    	    return Long.compare((long)b[0] * b[1], (long)a[0] * a[1]);
	    	}
	    };
	    	
	    PriorityQueue<int[]> pq = new PriorityQueue<>(max - min, cmp);
	    	
	    for (int i = max; i > min; i--) {
	    	int r = i % 10;
	    		
	    	if (r == 3 || r == 7) {
	    	    pq.offer(new int[] {i, i});
	    	} else if (r == 1) {
	    	    pq.offer(new int[] {i, i - 2});
	    	} else if (r == 9) {
	    	    pq.offer(new int[] {i, i - 8});
	    	}
	    }
	    	
	    while (!pq.isEmpty()) {
	    	int[] a = pq.poll();
	    	long p = (long)a[0] * a[1];
	    		
	    	if (isPalindrome(p)) return (int)(p % 1337);
	    		
	    	if (a[1] > min) {
	    	    a[1] -= 10;
	    	    pq.offer(a);
	    	}
	    }
	    
	    return 0;
	}
		    
	private static boolean isPalindrome(long z) {
	    long r = 0;
	    for (long x = z; x != 0; r = r * 10 + x % 10, x /= 10);
	    return r == z;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static int largestPalindrome1(int n) {
	    int max = (int)Math.pow(10, n) - 1;
	    int min = max - (int)Math.pow(10, (n + 1) >> 1);
	    	
	    Comparator<int[]> cmp = new Comparator<int[]>() {
	    	@Override
		public int compare(int[] a, int[] b) {
	    	    return Long.compare((long)b[0] * b[1], (long)a[0] * a[1]);
	    	}
	    };
	    	
	    PriorityQueue<int[]> pq = new PriorityQueue<>(max - min, cmp);
	    	
	    for (int i = max; i > min; i--) {
	    	int r = i % 10;
	    		
	    	if (r == 3 || r == 7) {
	    	    pq.offer(new int[] {i, i});
	    	} else if (r == 1) {
	    	    pq.offer(new int[] {i, i - 2});
	    	} else if (r == 9) {
	    	    pq.offer(new int[] {i, i - 8});
	    	}
	    }
	    	
	    while (!pq.isEmpty()) {
	    	int[] a = pq.poll();
	    	long p = (long)a[0] * a[1];
	    		
	    	if (isPalindrome1(p)) return (int)(p % 1337);
	    		
	    	if (a[1] > min) {
	    	    a[1] -= 10;
	    	    pq.offer(a);
	    	}
	    }
	    
	    return 0;
	}
		    
	private static boolean isPalindrome1(long z) {
	    long r = 0;
	    for (long x = z; x != 0; r = r * 10 + x % 10, x /= 10);
	    return r == z;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int largestPalindrome2(int n) {
	    long max = (long)Math.pow(10, n) - 1;
	    long min = max / 10;
	        
	    for (long h = max; h > min; h--) {
	        long left = h, right = 0;
	        for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10);
	        long palindrom = left + right;      // construct the palindrome
	            
	        for (long i = max; i > min; i--) {
	            long j = palindrom / i;
	            if (j > i) break;     // terminate if the other number is greater than current number
	            if (palindrom % i == 0) return (int)(palindrom % 1337); // found if current number is a factor
	        }
	    }

	    return 9;    // account for case n = 1
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int largestPalindrome3(int n) {
        if (n==1) return 9;
        int max=(int)Math.pow(10, n)-1;
        for (int v=max-1;v>max/10;v--) {
            long u=Long.valueOf(v+new StringBuilder().append(v).reverse().toString());
            for (long x=max;x*x>=u;x--)
                if (u%x==0)
                    return (int)(u%1337);
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int n = 2; 
		System.out.println(largestPalindrome(n));
	}

}

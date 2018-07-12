package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2018-07-12
 * Easy
 * Question 278:First Bad Version.
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version. 
 */
public class FirstBadVersion {

	/**
	 * 我自己写的方法，用的二分法
	 * 时间复杂度：O（log2n）
	 * 空间复杂度：O(1)
	 * @param x
	 * @return
	 */
	//The isBadVersion API is defined in the parent class VersionControl.
    private static boolean isBadVersion(int version){
		if(version>1702766718){
			return true;
		}
		return false;
    }; 
	public static int firstBadVersion(int n) {
		return helper(1,n);
    }
	
	private static int helper(int first,int last){
		if(isBadVersion(last)&!isBadVersion(last-1)){
			return last;
		}
		int middle = first + (last-first)/2;
		if(isBadVersion(middle)){
			if(!isBadVersion(middle-1)){
				return middle;
			}else{
				return helper(first,middle);
			}
		}else{
			return helper(middle,last);
		}
		
	}
	
	/**
	 * 答案1--Linear Scan
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int firstBadVersion1(int n) {
	    for (int i = 1; i < n; i++) {
	        if (isBadVersion(i)) {
	            return i;
	        }
	    }
	    return n;
	}
	
	/**
	 * 答案2--Binary Search,比我的简单,用的条件很好
	 * 时间复杂度：O(logn)
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public int firstBadVersion2(int n) {
	    int left = 1;
	    int right = n;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (isBadVersion(mid)) {
	            right = mid;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
	
	public static void main(String[] args) {
		//int x = 2147395600;
		int x = 2126753390;
		//int x = 0;
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(firstBadVersion(x));
	}
	
	
	
}

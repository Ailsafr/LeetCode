package solution.binarysearch;

/**
 * @author By RuiCUI
 * 2018-07-31
 * Easy
 * Question 374:Guess Number Higher or Lower.
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 */
public class GuessNumberHigherOrLower {

	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); 
	*/
	
	private static int guess(int num){
		int n = 6;
		if(num<n){
			return -1;
		}else if(num>n){
			return 1;
		}else{
			return 0;
		}
	}; 
	
	/**
	 * ���Լ�д�ķ������õĶ��ַ�
	 * ʱ�临�Ӷȣ�O��log2n�� 2Ϊ����
	 * �ռ临�Ӷȣ�O(1)
	 * @param x
	 * @return
	 */
	public static int guessNumber(int n) {
		int left = 1;
		int right = n;
		while(left<=right){
			int middle = left + (right-left)/2;
			int res = guess(middle);
			if(res==0){
				return middle;
			}else if(res==-1){
				left = middle-1;
			}else{
				right = middle+1;
			}
		}
		return -1;
	}
	
	/**
	 * ��1--Brute Force [Time Limit Exceeded]
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
    public int guessNumber1(int n) {
        for (int i = 1; i < n; i++)
            if (guess(i) == 0)
                return i;
        return n;
    }
	
	/**
	 * ��2--Binary Search [Accepted] ���ҵ�һ��
	 * ʱ�临�Ӷȣ�O(log2n) 2Ϊ����
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
    public int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
	
    /**
	 * ��3--Binary Search [Accepted] ���ҵ�һ��
	 * ʱ�临�Ӷȣ�O(log3n) 3Ϊ����
	 * �ռ临�Ӷȣ�O(1)
	 * @param n
	 * @return
	 */
    public int guessNumber3(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		//int x = 2147395600;
		//int x = 2126753390;
		int x = 10;
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(guessNumber(x));
	}
	
	
	
}

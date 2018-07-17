package solution.brainteaser;

/**
 * @author By RuiCUI
 * 2018-07-17
 * Easy
 * Question 292:Nim Game.
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * Example:
 * Input: 4
 * Output: false 
 * Explanation: 
 * If there are 4 stones in the heap, then you will never win the game;
 * No matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */
public class NimGame {

	/**
	 * 我自己写的方法,跟答案一样
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public static boolean canWinNim(int n) {
		if(n%4==0){
			return false;
		}
		return true;
    }
	
	/**
	 * 答案1--跟我的答案一样
	 * 时间复杂度：O(1) 
	 * 空间复杂度：O(1)
	 * @param n
	 * @return
	 */
	public boolean canWinNim1(int n) {
	    return (n % 4 != 0);
	}
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(canWinNim(n));
	}

}

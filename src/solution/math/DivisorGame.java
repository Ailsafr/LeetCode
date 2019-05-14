package solution.math;

/**
 * @author By RuiCUI
 * 2019-05-14
 * Easy
 * Question 1025:Divisor Game.
 * Alice and Bob take turns playing a game, with Alice starting first.
 * Initially, there is a number N on the chalkboard. On each player's turn, that player makes a move consisting of:
 * 1. Choosing any x with 0 < x < N and N % x == 0.
 * 2. Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * Example 1:
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * Note:
 * 1 <= N <= 1000.
 * Hint:
 * If the current number is even, we can always subtract a 1 to make it odd. If the current number is odd, we must subtract an odd number to make it even.
 */
public class DivisorGame {

	/**
	 * 我自己写的方法
	 * @param N
	 * @return
	 */
	public static boolean divisorGame(int N) {
		return N%2==0;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param N
	 * @return
	 */
	public static boolean divisorGame1(int N) {
		boolean[] wisdom = new boolean[N+1];
        wisdom[0] = false;
        wisdom[1] = false;
        for(int i=2;i<=N;i++){
            boolean ans = false;
            for(int j=1;j<i;j++){
                if(i%j == 0){
                    ans = ans || (!wisdom[i-j]);
                }
            }
            wisdom[i] = ans;
        }
        return wisdom[N];
	}
	
	public static void main(String[] args) {
		int N = 2;
		System.out.println(divisorGame(N));
	}

}

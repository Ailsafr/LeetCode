package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2019-03-27
 * Easy
 * Question 914:X of a Kind in a Deck of Cards.
 * In a deck of cards, each card has an integer written on it.
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * Example 1:
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 * Note:
 * 1. 1 <= deck.length <= 10000
 * 2. 0 <= deck[i] < 10000.
 */
public class XOfAKindInADeckOfCards {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param deck
	 * @return
	 */
	public static boolean hasGroupsSizeX(int[] deck) {
		int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = helper(g, count[i]);
            }

        return g >= 2;
    }
    public static int helper(int x, int y) {
        return x == 0 ? y : helper(y%x, x);
    }
	
	/**
	 * 答案1--Brute Force
	 * 时间复杂度：O(N^2loglogN) 
	 * 空间复杂度：O(n)
	 * @param deck
	 * @return
	 */
	public boolean hasGroupsSizeX1(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search: for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v: values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }
	
	/**
	 * 答案2--Greatest Common Divisor
	 * 时间复杂度：O(Nlog^2N)
	 * 空间复杂度：O(n)
	 * @param deck
	 * @return
	 */
	public boolean hasGroupsSizeX2(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }
    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
	
	public static void main(String[] args) {
		int[] deck = {0,0,0,0,1,1,1,1,2,2};
		System.out.println(hasGroupsSizeX(deck));
	}

}

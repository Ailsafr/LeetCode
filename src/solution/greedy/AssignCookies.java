package solution.greedy;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author By RuiCUI
 * 2018-09-06
 * Easy
 * Question 455:Assign Cookies.
 * Assume you are an awesome parent and want to give your children some cookies. 
 * But, you should give each child at most one cookie. 
 * Each child i has a greed factor gi, 
 * which is the minimum size of a cookie that the child will be content with; 
 * and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, 
 * and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive. 
 * You cannot assign more than one cookie to one child.
 * Example 1:
 * Input: [1,2,3], [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: [1,2], [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
 * You have 3 cookies and their sizes are big enough to gratify all of the children, 
 * You need to output 2.
 */
public class AssignCookies {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param g
	 * @param s
	 * @return
	 */
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for(int j=0;i<g.length&&j<s.length;j++){
			if(g[i]<=s[j]){
				i++;
			}
		}
		return i;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param g
	 * @param s
	 * @return
	 */
	public static int findContentChildren1(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0;
		for(int j=0;i<g.length && j<s.length;j++) {
			if(g[i]<=s[j]) i++;
		}
		return i;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,跟上面的方法一样
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param g
	 * @param s
	 * @return
	 */
	public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int pointG = 0;
        int pointS = 0;
        
        while (pointG<g.length && pointS<s.length) {
            if (g[pointG]<=s[pointS]) {
                pointG++;
                pointS++;
            } else {
                pointS++;
            }
        }
        
        return pointG;
    }
    
	/**
	 * 官网没有solution,这是其他人的答案--二叉搜索树
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param g
	 * @param s
	 * @return
	 */
	public static int findContentChildren3(int[] g, int[] s) {
    	int count = 0;
    	TreeMap<Integer,Integer> tree = new TreeMap<>();
    	for(int temp : s){
    		Integer num = tree.get(temp);
    		num = num==null?0:num;
    		tree.put(temp,num+1);
    	}
    	for(int temp : g){
    		Integer targ = tree.ceilingKey(temp);
    		if(targ!=null){
    			Integer num = tree.get(targ);
    			if(num>0){
    				count++;
    				if(num==1){
    					tree.remove(targ);
    				}else{
                    	tree.put(targ, num - 1);
                    }
    			}
    		}
    	}
        return count;
    }
	
	public static void main(String[] args) {
		int[] g = {2,7,9,3,1};
		int[] s = {2,1,1,2};
		System.out.println(findContentChildren(g,s));
	}

}

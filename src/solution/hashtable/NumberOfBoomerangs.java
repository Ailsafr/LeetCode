package solution.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-08-27
 * Easy
 * Question 447:Number of Boomerangs.
 * Given n points in the plane that are all pairwise distinct, 
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals 
 * the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. 
 * You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
 */
public class NumberOfBoomerangs {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n)
	 * @param points
	 * @return
	 */
	public static int numberOfBoomerangs(int[][] points) {
		int res = 0;

	    Map<Integer, Integer> map = new HashMap<>();
	    for(int i=0; i<points.length; i++) {
	        for(int j=0; j<points.length; j++) {
	            if(i == j)
	                continue;
	            
	            int d = getDistance(points[i], points[j]);                
	            map.put(d, map.getOrDefault(d, 0) + 1);
	        }
	        
	        for(int val : map.values()) {
	            res += val * (val-1);
	        }            
	        map.clear();
	    }
	    
	    return res;
	}

	private static int getDistance(int[] a, int[] b) {
	    int dx = a[0] - b[0];
	    int dy = a[1] - b[1];
	    
	    return dx*dx + dy*dy;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n)
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs1(int[][] points) {
	    int res = 0;

	    Map<Integer, Integer> map = new HashMap<>();
	    for(int i=0; i<points.length; i++) {
	        for(int j=0; j<points.length; j++) {
	            if(i == j)
	                continue;
	            
	            int d = getDistance1(points[i], points[j]);                
	            map.put(d, map.getOrDefault(d, 0) + 1);
	        }
	        
	        for(int val : map.values()) {
	            res += val * (val-1);
	        }            
	        map.clear();
	    }
	    
	    return res;
	}

	private int getDistance1(int[] a, int[] b) {
	    int dx = a[0] - b[0];
	    int dy = a[1] - b[1];
	    
	    return dx*dx + dy*dy;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n^2) 
	 * 空间复杂度：O(n)
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs2(int[][] points) {
        int result = 0;
        HashMap<Integer,Integer> distMap = new HashMap<Integer,Integer>();
        for(int[] i : points) {
            for(int[] j : points) {
                if(i==j) continue;
                int dist = (i[0]-j[0])*(i[0]-j[0]) + (i[1]-j[1])*(i[1]-j[1]);
                int prevDist = distMap.containsKey(dist) ? distMap.get(dist) : 0;
                result += 2*prevDist;
                distMap.put(dist, prevDist+1);
            }
            distMap.clear();
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
	}

}

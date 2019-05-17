package solution.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author By RuiCUI
 * 2019-05-16
 * Easy
 * Question 1030:Matrix Cells in Distance Order.
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), 
 * where 0 <= r < R and 0 <= c < C.
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 * Return the coordinates of all cells in the matrix, 
 * sorted by their distance from (r0, c0) from smallest distance to largest distance.  
 * Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, 
 * |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
 * Example 1:
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 * Example 2:
 * Input: R = 2, C = 2, r0 = 0, c0 = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * Example 3:
 * Input: R = 2, C = 3, r0 = 1, c0 = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 * Note:
 * 1. 1 <= R <= 100
 * 2. 1 <= C <= 100
 * 3. 0 <= r0 < R
 * 4. 0 <= c0 < C.
 */
public class MatrixCellsInDistanceOrder {
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param R
	 * @param C
	 * @param r0
	 * @param c0
	 * @return
	 */
	public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		int[][] res = new int[R * C][2];
        boolean[][] visited = new boolean[R][C]; 
        visited[r0][c0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r0, c0});
        int i = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res[i][0] = cur[0];
            res[i++][1] = cur[1];
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row >= 0 && row < R && col >= 0 && col < C && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.offer(new int[]{row, col});
                }
            }
        }
        return res;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param R
	 * @param C
	 * @param r0
	 * @param c0
	 * @return
	 */
	public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int bucketSize = Collections.max(Arrays.asList(r0+c0,r0+((C-1)-c0),((R-1)-r0)+c0,((R-1)-r0)+((C-1)-c0)));

        int[][][] buckets=new int[bucketSize][][];
        //bucket[i]=4*(i+1)
        for(int i=0;i<bucketSize;i++){
            buckets[i]=new int[4*(i+1)][];
        }
        //represent next idx of bucket;
        int[] idxs=new int[bucketSize];
        //special handle if distance equal 0.
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int distance=Math.abs(r0-i)+Math.abs(c0-j);
                if(distance==0){
                    continue;
                }
                distance-=1;
                buckets[distance][idxs[distance]++]=new int[]{i,j};
            }
        }
        int[][] result=new int[R*C][];
        result[0]=new int[]{r0,c0};
        int k=1;
        for(int i=0;i<bucketSize;i++){
            if(idxs[i]>0){
                for(int j=0;j<idxs[i];j++){
                    result[k++]=buckets[i][j];
                }
            }
        }
        return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param R
	 * @param C
	 * @param r0
	 * @param c0
	 * @return
	 */
	public int[][] allCellsDistOrder2(int R, int C, int r0, int c0){
        List<int[]> list = new ArrayList<>();
        for(int i =0; i<R;i++){
            for(int j =0; j<C;j++){
                list.add(new int[]{i,j});
            }
        }
        return list
            .stream()
            .sorted((int[] p1, int[] p2) -> Math.abs(p1[0]-r0)+Math.abs(p1[1]-c0)-Math.abs(p2[0]-r0)-Math.abs(p2[1]-c0))
            .toArray(int[][]::new);
    }
	
	public static void main(String[] args) {
		int R = 1;
		int C = 2;
		int r0 = 0;
		int c0 = 0;
		System.out.println(allCellsDistOrder(R,C,r0,c0));
	}

}

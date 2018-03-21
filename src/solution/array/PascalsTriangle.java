package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-03-21
 * Easy
 * Question 118:Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
 */
public class PascalsTriangle {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param numRows
	 * @return
	 */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if(numRows==0){
			return resultList;
		}
		if(numRows==1){
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			resultList.add(list);
			return resultList;
		}
		if(numRows==2){
			resultList.add(generate(1).get(0));
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(1);
			resultList.add(list);
			return resultList;
		}
		resultList = generate(numRows-1);
		List<Integer> geneList = resultList.get(numRows-2);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for(int i=0;i<geneList.size()-1;i++){
			list.add(geneList.get(i)+geneList.get(i+1));
		}
		list.add(1);
		resultList.add(list);
		return resultList;
    }
	
	/**
	 * 答案--动态规划（没有用递归）
	 * 时间复杂度：O(n2) n的平方 
	 * 空间复杂度：O(n2)
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            
            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
	
	public static void main(String[] args) {
		System.out.println(generate(7));
	}

}

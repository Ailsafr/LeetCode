package solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-03-22
 * Easy
 * Question 119:Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

	/**
	 * ���Լ�д�ķ��� �õĿռ��е����
	 * ʱ�临�Ӷȣ�O(n2) n��ƽ��
	 * �ռ临�Ӷȣ�O(n2)
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> resultList = new ArrayList<Integer>();
		if(rowIndex<0){
			return resultList;
		}
		if(rowIndex==0){
			resultList.add(1);
			return resultList;
		}
		if(rowIndex==1){
			resultList.add(1);
			resultList.add(1);
			return resultList;
		}
		List<Integer> list = getRow(rowIndex-1);
		resultList.add(1);
		for(int i=0;i<list.size()-1;i++){
			resultList.add(list.get(i)+list.get(i+1));
		}
		resultList.add(1);
		return resultList;
    }
	
	/**
	 * ����û��solution,���������˵Ĵ�,�����
	 * ʱ�临�Ӷȣ�O(n2) n��ƽ��
	 * �ռ临�Ӷȣ�O(n)
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow1(int rowIndex) {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
	
	/**
	 * ����û��solution,���������˵Ĵ�,����������ǹ�ʽ
	 * �ռ临�Ӷȣ�O(n)
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow2(int rowIndex) {
        Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        for(int i=1; i<rowList.length;i++) {
            rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
        }
        return Arrays.asList(rowList);
    }
	
	public static void main(String[] args) {
		System.out.println(getRow(5));
	}

}

package solution.math;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author By RuiCUI
 * 2019-04-11
 * Easy
 * Question 949:Largest Time for Given Digits.
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 * Note:
 * 1. A.length == 4
 * 2. 0 <= A[i] <= 9.
 */
public class LargestTimeForGivenDigits {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param A
	 * @return
	 */
	public static String largestTimeFromDigits(int[] A) {
		List<Integer> arrayList = Arrays.stream(A).boxed().collect(Collectors.toList());
		StringBuilder data = new StringBuilder();
		List<String> arrayListData = new ArrayList<String>();
		arrayListData = helper(arrayList,data,arrayListData);
		String result = "1970-01-01 00:00:00";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day = null;
		try {
			day = df.parse(result);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		for(String str:arrayListData){
			if(Integer.parseInt(str.substring(0,2))>23){
				continue;
			}
			str = "2019-04-11 " + str.substring(0,2) + ":" + str.substring(2, 4) + ":00";
			Date date = null;
			try{
				date = df.parse(str);
			}catch(Exception e){
				continue;
			}
			if(date.after(day)){
				day = date;
			}
		}
		if("1970-01-01 00:00:00".equals(df.format(day))){
			return "";
		}
		result = df.format(day).substring(11, 16);
		return result;
    }
	private static List<String> helper(List<Integer> arrayList ,StringBuilder data, List<String> arrayListData){
		for (int i=0; i<arrayList.size(); i++) {
            data.append(arrayList.get(i));
            ArrayList<Integer> newArrayList = new ArrayList<>(arrayList);
            newArrayList.remove(i);
            helper(newArrayList,data,arrayListData);
        }
        if (arrayList.size()==0)
        {
            arrayListData.add(data.toString());
        }
        if (data.length()!=0){
            data.deleteCharAt(data.length()-1);
        }
        return arrayListData;
	}
	
	/**
	 * 答案--Brute Force
	 * 时间复杂度：O(1)
	 * 空间复杂度：O(1)
	 * @param A
	 * @return
	 */
	public String largestTimeFromDigits1(int[] A) {
        int ans = -1;
        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j) if (j != i)
                for (int k = 0; k < 4; ++k) if (k != i && k != j) {
                    int l = 6 - i - j - k;
                    // For each permutation of A[i], read out the time and
                    // record the largest legal time.
                    int hours = 10 * A[i] + A[j];
                    int mins = 10 * A[k] + A[l];
                    if (hours < 24 && mins < 60)
                        ans = Math.max(ans, hours * 60 + mins);
                }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
    
	public static void main(String[] args) {
		int[] A = {5,5,5,5};
		System.out.println(largestTimeFromDigits(A));
	}

}

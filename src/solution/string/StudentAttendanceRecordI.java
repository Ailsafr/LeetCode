package solution.string;

/**
 * @author By RuiCUI
 * 2018-10-26
 * Easy
 * Question 551:Student Attendance Record I.
 * You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
	
	/**
	 * 我自己写的方法
	 * @param s
	 * @return
	 */
	public static boolean checkRecord(String s) {
		if(s.contains("LLL")){
			return false;
		}
		if(s.length()-s.replaceAll("A", "").length()>1){
			return false;
		}
		return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param s
	 * @return
	 */
	public boolean checkRecord1(String s) {
	    return !s.matches(".*LLL.*|.*A.*A.*");
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param s
	 * @return
	 */
	public boolean checkRecord2(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @param s
	 * @return
	 */
	public boolean checkRecord3(String s) {
        int countA=0;
        int continuosL = 0;
        int charA = 'A';
        int charL ='L';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == charA){
                countA++;
                continuosL = 0;
            }
            else if(s.charAt(i) == charL){
                continuosL++;
            }
            else{
                continuosL = 0;
            }
            if(countA >1 || continuosL > 2 ){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String str = "PPALLL";
		System.out.println(checkRecord(str));
	}

}

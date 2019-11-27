package solution.noclassification;

/**
 * @author By RuiCUI
 * 2019-11-27
 * Medium
 * Question 194:Transpose File.
 * Given a text file file.txt, transpose its content.
 * You may assume that each row has the same number of columns and each field is separated by the ' ' character.
 * Example:
 * If file.txt has the following content:
 * name age
 * alice 21
 * ryan 30
 * Output the following:
 * name alice ryan
 * age 21 30.
 */
public class TransposeFile {

	/**
	 * 我自己写的方法
	 */
	//# Read from the file file.txt and print its transposed content to stdout.
//	awk '
//	{
//	    for (i = 1; i <= NF; i++) {
//	        if(NR == 1) {
//	            s[i] = $i;
//	        } else {
//	            s[i] = s[i] " " $i;
//	        }
//	    }
//	}
//	END {
//	    for (i = 1; s[i] != ""; i++) {
//	        print s[i];
//	    }
//	}' file.txt
	
	/**
	 * 官网没有solution,这是其他人的答案
	 */
//	awk '
//	{
//	    for (i = 1; i <= NF; i++) {
//	        if(NR == 1) {
//	            s[i] = $i;
//	        } else {
//	            s[i] = s[i] " " $i;
//	        }
//	    }
//	}
//	END {
//	    for (i = 1; s[i] != ""; i++) {
//	        print s[i];
//	    }
//	}' file.txt
	
	/**
	 * 官网没有solution,这是其他人的答案
	 */
//	ncol=`head -n1 file.txt | wc -w`
//	for i in `seq 1 $ncol`
//	do
//	    echo `cut -d' ' -f$i file.txt`
//	done
	
}

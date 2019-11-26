package solution.noclassification;

/**
 * @author By RuiCUI
 * 2019-11-26
 * Medium
 * Question 192:Word Frequency.
 * Write a bash script to calculate the frequency of each word in a text file words.txt.
 * For simplicity sake, you may assume:
 * words.txt contains only lowercase characters and space ' ' characters.
 * Each word must consist of lowercase characters only.
 * Words are separated by one or more whitespace characters.
 * Example:
 * Assume that words.txt has the following content:
 * the day is sunny the the
 * the sunny is is
 * Your script should output the following, sorted by descending frequency:
 * the 4
 * is 3
 * sunny 2
 * day 1
 * Note:
 * Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.
 * Could you write it in one-line using Unix pipes?
 */
public class WordFrequency {

	/**
	 * ���Լ�д�ķ���
	 */
	//# Read from the file words.txt and output the word frequency list to stdout.
//	cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 */
//	cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
	
	/**
	 * ����û��solution,���������˵Ĵ�
	 */
//	awk '\
//	{ for (i=1; i<=NF; i++) { ++D[$i]; } }\
//	END { for (i in D) { print i, D[i] } }\
//	' words.txt | sort -nr -k 2

}

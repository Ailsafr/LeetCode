package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-11-25
 * Medium
 * Question 187:Repeated DNA Sequences.
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<String>();
    	if (s == null || s.length() < 11) {
    		return list;
    	}
    	Set<String> set = new HashSet<String>();
    	int len = s.length();
    	int i = 0;
    	while (i <= len - 10) {
    		String dna = s.substring(i, i + 10);
    		if (set.contains(dna) && !list.contains(dna)) {
    			list.add(dna);
    		} else {
    			set.add(dna);
    		}
    		i++;
    	}
		return list;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,用的数组,跟我的思路一样
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> seen = new HashSet<String>(), repeated = new HashSet<String>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList<String>(repeated);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,遍历一次
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }
	
    /**
	 * 官网没有solution,这是其他人的答案,遍历一次
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    private static final Map<Character, Integer> A = new HashMap<>();
    static { A.put('A',0); A.put('C',1); A.put('G',2); A.put('T',3); }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);
    public List<String> findRepeatedDnaSequences3(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }
    
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";  
		//String s = "AAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(s));
	}

}

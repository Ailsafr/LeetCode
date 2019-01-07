package solution.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author By RuiCUI
 * 2019-01-07
 * Easy
 * Question 720:Longest Word in Dictionary.
 * Given a list of strings words representing an English Dictionary, 
 * find the longest word in words that can be built one character at a time by other words in words. 
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * Example 1:
 * Input: 
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation: 
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input: 
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation: 
 * Both "apply" and "apple" can be built from other words in the dictionary. 
 * However, "apple" is lexicographically smaller than "apply".
 * Note:
 * 1.All the strings in the input will only contain lowercase letters.
 * 2.The length of words will be in the range [1, 1000].
 * 3.The length of words[i] will be in the range [1, 30].
 * Hint:
 * 1.For every word in the input list, 
 * we can check whether all prefixes of that word are in the input list by using a Set.
 */
public class LongestWordInDictionary {

	/**
	 * 我自己写的方法
	 * @param words
	 * @return
	 */
	public static String longestWord(String[] words) {
		int len = words.length;
		Set<String> set = new HashSet<String>();
		Set<String> result = new TreeSet<String>();
		for(int i=0;i<len;i++){
			set.add(words[i]);
		}
		for(int i=0;i<len;i++){
			int n = words[i].length();
			boolean add = true;
			for(int j=1;j<n;j++){
				if(!set.contains(words[i].substring(0, j))){
					add = false;
					break;
				}
			}
			if(add){
				result.add(words[i]);
			}
		}
		String res = "";
		if(result.size()>0){
			int size = 0;
			for(String s:result){
				if(s.length()>size){
					size = s.length();
					res = s;
				}
			}
		}
		return res;
    }
	
	/**
	 * 答案1--Brute Force[Accepted]
	 * @param words
	 * @return
	 */
	public String longestWord1(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }    
        }
        return ans;
    }
	
	/**
	 * 答案2--Trie + Depth-First Search[Accepted]
	 * @param words
	 * @return
	 */
	public String longestWord2(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word: words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }
	
	class Node {
	    char c;
	    HashMap<Character, Node> children = new HashMap();
	    int end;
	    public Node(char c){
	        this.c = c;
	    }
	}

	class Trie {
	    Node root;
	    String[] words;
	    public Trie() {
	        root = new Node('0');
	    }

	    public void insert(String word, int index) {
	        Node cur = root;
	        for (char c: word.toCharArray()) {
	            cur.children.putIfAbsent(c, new Node(c));
	            cur = cur.children.get(c);
	        }
	        cur.end = index;
	    }

	    public String dfs() {
	        String ans = "";
	        Stack<Node> stack = new Stack();
	        stack.push(root);
	        while (!stack.empty()) {
	            Node node = stack.pop();
	            if (node.end > 0 || node == root) {
	                if (node != root) {
	                    String word = words[node.end - 1];
	                    if (word.length() > ans.length() ||
	                            word.length() == ans.length() && word.compareTo(ans) < 0) {
	                        ans = word;
	                    }
	                }
	                for (Node nei: node.children.values()) {
	                    stack.push(nei);
	                }
	            }
	        }
	        return ans;
	    }
	}
    
	public static void main(String[] args) {
		//String[] words = {"w","wo","wor","worl", "world"};
		//String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
		System.out.println(longestWord(words));
	}

}

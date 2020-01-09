package solution.design;

/**
 * @author By RuiCUI
 * 2020-01-09
 * Medium
 * Question 211:Add and Search Word - Data structure design.
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * Example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * Hint:
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 */
public class AddAndSearchWordDataStructureDesign {

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */
	/**
	 * 我自己写的方法
	 * @return
	 */
	public class TrieNode {
		public TrieNode[] children = new TrieNode[26];
       	public String item = "";
	}
	
	private TrieNode root = new TrieNode();
	
	 /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
    	for (char c : word.toCharArray()) {
    		if (node.children[c - 'a'] == null) {
    			node.children[c - 'a'] = new TrieNode();
    		}
    		node = node.children[c - 'a'];
    	}
    	node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return match(word.toCharArray(), 0, root);
    }
	
    private boolean match(char[] chs, int k, TrieNode node) {
    	if (k == chs.length) return !node.item.equals("");   
    	if (chs[k] != '.') {
    		return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
    	} else {
    		for (int i = 0; i < node.children.length; i++) {
    			if (node.children[i] != null) {
    				if (match(chs, k + 1, node.children[i])) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
	/**
	 * 官网没有solution,这是其他人的答案
	 * @return
	 */
//    public class TrieNode {
//        public TrieNode[] children = new TrieNode[26];
//        public String item = "";
//    }
//    
//    private TrieNode root = new TrieNode();
//
//    public void addWord(String word) {
//        TrieNode node = root;
//        for (char c : word.toCharArray()) {
//            if (node.children[c - 'a'] == null) {
//                node.children[c - 'a'] = new TrieNode();
//            }
//            node = node.children[c - 'a'];
//        }
//        node.item = word;
//    }
//
//    public boolean search(String word) {
//        return match(word.toCharArray(), 0, root);
//    }
//    
//    private boolean match(char[] chs, int k, TrieNode node) {
//        if (k == chs.length) return !node.item.equals("");   
//        if (chs[k] != '.') {
//            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
//        } else {
//            for (int i = 0; i < node.children.length; i++) {
//                if (node.children[i] != null) {
//                    if (match(chs, k + 1, node.children[i])) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * @return
	 */
//    Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
//    // Adds a word into the data structure.
//    public void addWord(String word) {
//        int index = word.length();
//        if(!map.containsKey(index)){
//            List<String> list = new ArrayList<String>();
//            list.add(word);
//            map.put(index, list);
//        }else{
//            map.get(index).add(word);
//        }
//        
//    }
//
//    // Returns if the word is in the data structure. A word could
//    // contain the dot character '.' to represent any one letter.
//    public boolean search(String word) {
//        int index = word.length();
//        if(!map.containsKey(index)){
//            return false;
//        }
//        List<String> list = map.get(index);
//        if(isWords(word)){
//            return list.contains(word);
//        }
//        for(String s : list){
//            if(isSame(s, word)){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    boolean isWords(String s){
//        for(int i = 0; i < s.length(); i++){
//            if(!Character.isLetter(s.charAt(i))){
//                return false;
//            }
//        }
//        return true;
//    }
//    
//    boolean isSame(String a, String search){
//        if(a.length() != search.length()){
//            return false;
//        }
//        for(int i = 0; i < a.length(); i++){
//            if(search.charAt(i) != '.' && search.charAt(i) != a.charAt(i)){
//                return false;
//            }
//        }
//        return true;
//    }
    
	public static void main(String[] args) {
		AddAndSearchWordDataStructureDesign aaswdsd = new AddAndSearchWordDataStructureDesign();
		aaswdsd.addWord("bad");
		aaswdsd.addWord("dad");
		aaswdsd.addWord("mad");
		System.out.println(aaswdsd.search("pad"));
		System.out.println(aaswdsd.search("bad"));
		System.out.println(aaswdsd.search(".ad"));
		System.out.println(aaswdsd.search("b.."));
	}

}

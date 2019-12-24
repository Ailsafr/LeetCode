package solution.design;

/**
 * @author By RuiCUI
 * 2019-12-24
 * Medium
 * Question 208:Implement Trie (Prefix Tree).
 * Implement a trie with insert, search, and startsWith methods.
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
class TrieNode {
    public char val;
    public boolean isWord; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
public class ImplementTriePrefixTree {
	
	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
	/**
	 * 我自己写的方法
	 * @param capacity
	 * @return
	 */
	/** Initialize your data structure here. */
	private TrieNode root;
    public ImplementTriePrefixTree() {
    	root = new TrieNode();
        root.val = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
    
    /**
	 * 答案
	 */
//    private ImplementTriePrefixTree[] links;
//
//    private final int R = 26;
//
//    private boolean isEnd;
//
//    public ImplementTriePrefixTree() {
//        links = new ImplementTriePrefixTree[R];
//    }
//
//    public boolean containsKey(char ch) {
//        return links[ch -'a'] != null;
//    }
//    public ImplementTriePrefixTree get(char ch) {
//        return links[ch -'a'];
//    }
//    public void put(char ch, ImplementTriePrefixTree node) {
//        links[ch -'a'] = node;
//    }
//    public void setEnd() {
//        isEnd = true;
//    }
//    public boolean isEnd() {
//        return isEnd;
//    }
    
	public static void main(String[] args) {
		ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
	}

}
//class Trie {
//    private ImplementTriePrefixTree root;
//
//    public Trie() {
//        root = new ImplementTriePrefixTree();
//    }
//
//    // Inserts a word into the trie.
//    public void insert(String word) {
//    	ImplementTriePrefixTree node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char currentChar = word.charAt(i);
//            if (!node.containsKey(currentChar)) {
//                node.put(currentChar, new ImplementTriePrefixTree());
//            }
//            node = node.get(currentChar);
//        }
//        node.setEnd();
//    }
//    
// // search a prefix or whole key in trie and
//    // returns the node where search ends
//    private ImplementTriePrefixTree searchPrefix(String word) {
//    	ImplementTriePrefixTree node = root;
//        for (int i = 0; i < word.length(); i++) {
//           char curLetter = word.charAt(i);
//           if (node.containsKey(curLetter)) {
//               node = node.get(curLetter);
//           } else {
//               return null;
//           }
//        }
//        return node;
//    }
//
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//    	ImplementTriePrefixTree node = searchPrefix(word);
//       return node != null && node.isEnd();
//    }
//    
// // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix) {
//    	ImplementTriePrefixTree node = searchPrefix(prefix);
//        return node != null;
//    }
//}

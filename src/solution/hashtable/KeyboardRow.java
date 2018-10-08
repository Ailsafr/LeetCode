package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author By RuiCUI
 * 2018-10-08
 * Easy
 * Question 500:Keyboard Row.
 * Given a List of words, 
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * American keyboard
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * 1.You may use one character in the keyboard more than once.
 * 2.You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param words
	 * @return
	 */
	public static String[] findWords(String[] words) {
		Map<Character,Integer> map = getMap();
		List<String> list = new ArrayList<String>();
		int len = words.length;
		for(int i=0;i<len;i++){
			String str = words[i];
			int n = str.length();
			if(n<=1){
				list.add(str);
			}else{
				str = str.toLowerCase();
				int num = map.get(str.charAt(0));
				int j = 1;
				for(j=1;j<n;j++){
					char c = str.charAt(j);
					if(map.get(c)!=num){
						break;
					}
				}
				if(j==n){
					list.add(words[i]);
				}
			}
		}
		return list.toArray(new String[list.size()]);
    }
	
	private static Map<Character,Integer> getMap(){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('q', 1);
		map.put('w', 1);
		map.put('e', 1);
		map.put('r', 1);
		map.put('t', 1);
		map.put('y', 1);
		map.put('u', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('p', 1);
		map.put('a', 2);
		map.put('s', 2);
		map.put('d', 2);
		map.put('f', 2);
		map.put('g', 2);
		map.put('h', 2);
		map.put('j', 2);
		map.put('k', 2);
		map.put('l', 2);
		map.put('z', 3);
		map.put('x', 3);
		map.put('c', 3);
		map.put('v', 3);
		map.put('b', 3);
		map.put('n', 3);
		map.put('m', 3);
		return map;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案,用了匹配,更简便
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param words
	 * @return
	 */
	public String[] findWords1(String[] words) {
	    return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param words
	 * @return
	 */
	public String[] findWords2(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag. 
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param words
	 * @return
	 */
	public String[] findWords3(String[] words) {
		String[] base = {"qwertyuiop","asdfghjkl","zxcvbnm"};
		List<String> list = new ArrayList<String>();
		for (String string : words) {
			for (String basStr : base) {
				boolean find = true;
				for (char c : string.toCharArray()) {
					String low = String.valueOf(c).toLowerCase();
					if (!basStr.contains(low)){
						find = false;
						break;
					}
				}
				if (find) list.add(string);
			}
		}
		String[] res = new String[list.size()];
		for (int i = 0; i < res.length; i++) res[i] = list.get(i);
		return res;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param words
	 * @return
	 */
	public String[] findWords4(String[] words) {
		List<String> a=new ArrayList<>();;
	    for(int i=0;i<words.length;i++){
		    boolean flag=false;
		    if(words[i].toLowerCase().matches("[qwertyuiop]+")) {flag=true;};
		    if(words[i].toLowerCase().matches("[asdfghjkl]+")) {flag=true;};
		    if(words[i].toLowerCase().matches("[zxcvbnm]+")) {flag=true;};
		    if(flag) a.add(words[i]);
	    }
		return a.toArray(new String[a.size()]);
	}
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		String[] ss = findWords(words);
		System.out.println(findWords(words));
	}

}

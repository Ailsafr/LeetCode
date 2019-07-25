package solution.string;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-07-25
 * Medium
 * Question 71:Simplify Path.
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. 
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. 
 * The last directory name (if it exists) must not end with a trailing /. 
 * Also, the canonical path must be the shortest string representing the absolute path.
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c".
 */
public class SimplifyPath {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param path
	 * @return
	 */
	public static String simplifyPath(String path) {
		String result = "";
		if(path==null||path.length()==0){
			return "/";
		}
		LinkedList<String> list = new LinkedList<String>();
		String[] array = path.split("/");
		for(String str:array){
			if(!"".equals(str)&&!".".equals(str)){
				if("..".equals(str)){
					if(!list.isEmpty()){
						list.removeLast();
					}
				}else{
					list.add(str);
				}
			}
		}
		if(list.isEmpty()){
			return "/";
		}
		for(String str:list){
			result += "/" + str;
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param path
	 * @return
	 */
	public String simplifyPath1(String path) {
	    Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) res = "/" + dir + res;
	    return res.isEmpty() ? "/" : res;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param path
	 * @return
	 */
	public String simplifyPath2(String path) {
		String[] dir = path.split("/");
		String[] stack = new String[dir.length];
		int ptr = 0;
		for(int i = 0; i < dir.length; i++){
			if(dir[i].equals(".") || dir[i].equals("")){
				continue;
			}else if(dir[i].equals("..")){
				if(ptr > 0) ptr--;
			}else{
				stack[ptr] = dir[i];
				ptr++;
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < ptr; i++){
			result.append("/");
			result.append(stack[i]);
		}
		return result.length() == 0 ? "/" : result.toString();
	}
	
	public static void main(String[] args) {
		String path =  "/a//b////c/d//././/..";
		System.out.println(simplifyPath(path));
	}

}

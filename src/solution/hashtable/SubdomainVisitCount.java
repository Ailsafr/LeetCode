package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2019-02-02
 * Easy
 * Question 811:Subdomain Visit Count.
 * A website domain like "discuss.leetcode.com" consists of various subdomains. 
 * At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". 
 * When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. 
 * An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, 
 * (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 * Example 1:
 * Input: 
 * ["9001 discuss.leetcode.com"]
 * Output: 
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation: 
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. 
 * So they will all be visited 9001 times.
 * Example 2:
 * Input: 
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output: 
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation: 
 * We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, 
 * we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 * Notes:
 * 1.The length of cpdomains will not exceed 100. 
 * 2.The length of each domain name will not exceed 100.
 * 3.Each address will have either 1 or 2 "." characters.
 * 4.The input count in any count-paired domain will not exceed 10000.
 * 5.The answer output can be returned in any order.
 */
public class SubdomainVisitCount {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param cpdomains
	 * @return
	 */
	public static List<String> subdomainVisits(String[] cpdomains) {
		List<String> result = new ArrayList<String>();
		if(cpdomains==null||cpdomains.length==0){
			return result;
		}
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String str:cpdomains){
			String[] strs = str.split(" ");
			int num = Integer.parseInt(strs[0]);
			str = strs[1];
			int first = str.indexOf(".");
			int second = str.lastIndexOf(".");
			map.put(str, map.getOrDefault(str, 0)+num);
			if(first==second){
				map.put(str.substring(first+1), map.getOrDefault(str.substring(first+1), 0)+num);
			}else{
				map.put(str.substring(first+1), map.getOrDefault(str.substring(first+1), 0)+num);
				map.put(str.substring(second+1), map.getOrDefault(str.substring(second+1), 0)+num);
			}
		}
		for(String key:map.keySet()){
			result.add(map.get(key) + " " + key);
		}
		return result;
	}
	
	/**
	 * 答案--Hash Map[Accepted]
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param cpdomains
	 * @return
	 */
	public List<String> subdomainVisits1(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }
        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
	
	public static void main(String[] args) {
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		System.out.println(subdomainVisits(cpdomains));
	}

}

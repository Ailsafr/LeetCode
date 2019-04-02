package solution.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author By RuiCUI
 * 2019-04-02
 * Easy
 * Question 929:Unique Email Addresses.
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * If you add periods ('.') between some characters in the local name part of an email address, 
 * mail sent there will be forwarded to the same address without dots in the local name.  
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address. (Note that this rule does not apply for domain names.)
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. 
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com. (Again, this rule does not apply for domain names.)
 * It is possible to use both of these rules at the same time.
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
 * Example 1:
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * Note:
 * 1. 1 <= emails[i].length <= 100
 * 2. 1 <= emails.length <= 100
 * 3. Each emails[i] contains exactly one '@' character.
 */
public class UniqueEmailAddresses {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param emails
	 * @return
	 */
	public static int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<String>();
		for(String str:emails){
			String localName = str.split("@")[0];
			String domainName = str.split("@")[1];
			String tmp = localName.split("\\+")[0];
			tmp = tmp.replaceAll("\\.", "");
			set.add(tmp+domainName);
		}
		return set.size();
	}
	
	/**
	 * 答案--Canonical Form
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param emails
	 * @return
	 */
	public int numUniqueEmails1(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll(".", "");
            seen.add(local + rest);
        }

        return seen.size();
    }
	
	public static void main(String[] args) {
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}

}

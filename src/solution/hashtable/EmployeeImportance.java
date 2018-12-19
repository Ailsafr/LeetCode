package solution.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author By RuiCUI
 * 2018-12-19
 * Easy
 * Question 690:Employee Importance.
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. 
 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. 
 * Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.
 * Example 1:
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. 
 * So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * Note:
 * 1.One employee has at most one direct leader and may have several subordinates.
 * 2.The maximum number of employees won't exceed 2000.
 */
public class EmployeeImportance {
	
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
	
	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) where n is the number of employees.
	 * 空间复杂度：O(n) where n is the number of employees.
	 * @param employees
	 * @param id
	 * @return
	 */
	static int result = 0;
	public static int getImportance(List<Employee> employees, int id) {
		if(employees==null){
			return result;
		}
		int len = employees.size();
		if(len==0){
			return 0;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Map<Integer,List<Integer>> mapE = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<len;i++){
			Employee e = employees.get(i);
			map.put(e.id, e.importance);
			mapE.put(e.id, e.subordinates);
		}
		helper(id,map,mapE);
		return result;
    }
	private static void helper(int id, Map<Integer,Integer> map, Map<Integer,List<Integer>> mapE){
		List<Integer> list = mapE.get(id);
		result += map.get(id);
		if(list==null||list.size()==0){
			return;
		}
		int len = list.size();
		for(int i=0;i<len;i++){
			helper(list.get(i),map,mapE);
		}
	}
	
	/**
	 * 答案1--Depth-First Search[Accepted]
	 * 时间复杂度：O(n) where n is the number of employees.
	 * 空间复杂度：O(n) where n is the number of employees.
	 * @param employees
	 * @param id
	 * @return
	 */
	Map<Integer, Employee> emap;
    public int getImportance1(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
	
	public static void main(String[] args) {
		EmployeeImportance e = new EmployeeImportance();
		List<Employee> list = new ArrayList<Employee>();
		Employee e1 = e.new Employee();
		e1.id = 1;
		e1.importance = 5;
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		l1.add(3);
		list.add(e1);
		e1.subordinates = l1;
		Employee e2 = e.new Employee();
		e2.id = 2;
		e2.importance = 3;
		List<Integer> l2 = new ArrayList<Integer>();
		e2.subordinates = l2;
		list.add(e2);
		Employee e3 = e.new Employee();
		e3.id = 3;
		e3.importance = 3;
		List<Integer> l3 = new ArrayList<Integer>();
		e3.subordinates = l3;
		list.add(e3);
		int id = 1;
		System.out.println(getImportance(list,id));
	}

}

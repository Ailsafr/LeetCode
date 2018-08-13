package solution.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author By RuiCUI
 * 2018-08-13
 * Easy
 * Question 412:Fizz Buzz.
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * Example:
 * n = 15,
 * Return:
 * [
	    "1",
	    "2",
	    "Fizz",
	    "4",
	    "Buzz",
	    "Fizz",
	    "7",
	    "8",
	    "Fizz",
	    "Buzz",
	    "11",
	    "Fizz",
	    "13",
	    "14",
	    "FizzBuzz"
 * ]
 */
public class FizzBuzz {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<String>();
		for(int i=1;i<=n;i++){
			if(i%15==0){
				result.add("FizzBuzz");
			}else if(i%5==0){
				result.add("Buzz");
			}else if(i%3==0){
				result.add("Fizz");
			}else{
				result.add(i+"");
			}
		}
		return result;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public List<String> fizzBuzz1(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案,跟我的思路一样
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public List<String> fizzBuzz2(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param n
	 * @return
	 */
	public List<String> fizzBuzz3(int n) {
        
        List<String> ls = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=n;i++){
            sb.setLength(0);
            if(i%3==0){
                sb.append("Fizz");
            }
            if(i%5==0){
                sb.append("Buzz");
            }
            if(sb.length()==0){
                sb.append(String.valueOf(i));
            }
            ls.add(sb.toString());
        }
        return ls;
    }
	
	public static void main(String[] args) {
		int n = 15;
		System.out.println(fizzBuzz(n));
	}

}

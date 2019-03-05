package solution.greedy;

/**
 * @author By RuiCUI
 * 2019-03-05
 * Easy
 * Question 860:Lemonade Change.
 * At a lemonade stand, each lemonade costs $5. 
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
 * You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 * Note that you don't have any change in hand at first.
 * Return true if and only if you can provide every customer with correct change.
 * Example 1:
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation: 
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 * Input: [10,10]
 * Output: false
 * Example 4:
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation: 
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 * Note:
 * 1. 0 <= bills.length <= 10000
 * 2. bills[i] will be either 5, 10, or 20.
 */
public class LemonadeChange {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n) 
	 * 空间复杂度：O(1)
	 * @param bills
	 * @return
	 */
	public static boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;
		for(int n:bills){
			if(n==5){
				five += 1;
			}else if(n==10){
				if(five>0){
					five -= 1;
					ten += 1;
				}else{
					return false;
				}
			}else{
				if(ten>0&&five>0){
					ten -= 1;
					five -= 1;
				}else if(five>2){
					five -= 3;
				}else{
					return false;
				}
			}
		}
		return true;
    }
	
	/**
	 * 答案--Simulation
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param bills
	 * @return
	 */
	public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] bills = {5,5,10,10,20};
		System.out.println(lemonadeChange(bills));
	}

}

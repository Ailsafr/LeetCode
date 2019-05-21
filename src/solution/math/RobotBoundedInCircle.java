package solution.math;

/**
 * @author By RuiCUI
 * 2019-05-21
 * Easy
 * Question 1041:Robot Bounded In Circle.
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 * Example 1:
 * Input: "GGLLGG"
 * Output: true
 * Explanation: 
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 * Input: "GG"
 * Output: false
 * Explanation: 
 * The robot moves north indefinitely.
 * Example 3:
 * Input: "GL"
 * Output: true
 * Explanation: 
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 * Note:
 * 1. 1 <= instructions.length <= 100
 * 2. instructions[i] is in {'G', 'L', 'R'}.
 * Hint:
 * 1. Calculate the final vector of how the robot travels after executing all instructions once - it consists of a change in position plus a change in direction.
 * 2. The robot stays in the circle iff (looking at the final vector) it changes direction (ie. doesn't stay pointing north), or it moves 0.
 */
public class RobotBoundedInCircle {

	/**
	 * 我自己写的方法
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param instructions
	 * @return
	 */
	public static boolean isRobotBounded(String instructions) {
		int direction = 0;
		 // N, E, S, W
		 int[] start = {0,0};
		 int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
		 int i = 0;
		 for(int epoch=0;epoch<4;epoch++)
		 {
			 while(i<instructions.length())
			 {
				char c =  instructions.charAt(i);
				if(c=='L') {
					direction = (4+direction-1)%4;
				}else if (c=='R') {
					direction = (direction+1)%4;
				}else {
					start[0] += moves[direction][0];
					start[1] += moves[direction][1];
				}
				i++;
			 }
			 i=0;
		 }
		 int dist = Math.abs(start[0]) + Math.abs(start[1]);
		 if(dist>0) return false;
		 
		 return true;
    }
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param instructions
	 * @return
	 */
	public boolean isRobotBounded1(String instructions) {
		 int direction = 0;
		 // N, E, S, W
		 int[] start = {0,0};
		 int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
		 int i = 0;
		 for(int epoch=0;epoch<4;epoch++)
		 {
			 while(i<instructions.length())
			 {
				char c =  instructions.charAt(i);
				if(c=='L') {
					direction = (4+direction-1)%4;
				}else if (c=='R') {
					direction = (direction+1)%4;
				}else {
					start[0] += moves[direction][0];
					start[1] += moves[direction][1];
				}
				i++;
			 }
			 i=0;
		 }
		 int dist = Math.abs(start[0]) + Math.abs(start[1]);
		 if(dist>0) return false;
		 
		 return true;
	}
	
	/**
	 * 官网没有solution,这是其他人的答案
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param instructions
	 * @return
	 */
	public boolean isRobotBounded2(String instructions) {
	    if(instructions == null)
	        return false;
	    int dir = 0; //N-0, W-3, S-2, E-1
        int x=0;
        int y=0;

        for(char ch : instructions.toCharArray()){
            switch(ch){
                case 'G':
                    switch(dir){
                        case 0:
                            y++;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y--;
                            break;
                        case 3:
                            x--;
                            break;
                    }
                    break;
                case 'L':
                    dir = (dir -1 +4)%4;
                    break;
                case 'R':
                    dir = (dir+1)%4;
                    break;

                default:
                    return false;
            }
        }
        if(x==0 && y==0)
            return true;
        else if(dir!=0)
            return true;
        return false;
    }
	
	public static void main(String[] args) {
		String instructions = "GL";
		System.out.println(isRobotBounded(instructions));
	}

}

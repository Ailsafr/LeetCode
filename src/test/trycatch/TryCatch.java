package test.trycatch;


/**
 * @author By RuiCUI
 * 2018-03-29
 * 最近遇到了循环嵌套try catch的问题：
 * 1.若内层的try catch已经捕获，是否外层就捕获不到了，如果需要外层也捕获到，throw一个新的异常是否就可以了。
 * 2.catch异常的类型是否影响catch的结果。
 * 实验结果：
 * 1.inside方法里catch到的异常，将不会出现在main方法里，如果在inside方法里的catch里加入throw语句抛出新异常，main方法将catch到此异常。
 * 2.catch异常的类型影响catch的结果，只能捕获到指定的异常，如果是其他类型的异常，不走catch方法。
 */
public class TryCatch {

	private static void inside() throws Exception{
		int a = 0;
		int b = 0;
		try{
			int c = a/b;
		}catch(Exception e){
			System.out.println("inside方法里的catch");
			//throw new Exception();
		}finally{
			System.out.println("inside方法里的finally");
		}
	}
	
	private static void testType(){
		int a = 0;
		int b = 0;
		try{
			int c = a/b;
		}catch(ArithmeticException e){
			System.out.println("testType方法里的catch");
		}finally{
			System.out.println("testType方法里的finally");
		}
	}
	
	public static void main(String[] args) {
		try{
			//inside();
			testType();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("main方法里的catch");
		}finally{
			System.out.println("main方法里的finally");
		}
	}

}

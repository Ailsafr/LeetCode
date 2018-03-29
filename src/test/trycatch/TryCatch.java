package test.trycatch;


/**
 * @author By RuiCUI
 * 2018-03-29
 * ���������ѭ��Ƕ��try catch�����⣺
 * 1.���ڲ��try catch�Ѿ������Ƿ����Ͳ��񲻵��ˣ������Ҫ���Ҳ���񵽣�throwһ���µ��쳣�Ƿ�Ϳ����ˡ�
 * 2.catch�쳣�������Ƿ�Ӱ��catch�Ľ����
 * ʵ������
 * 1.inside������catch�����쳣�������������main����������inside�������catch�����throw����׳����쳣��main������catch�����쳣��
 * 2.catch�쳣������Ӱ��catch�Ľ����ֻ�ܲ���ָ�����쳣��������������͵��쳣������catch������
 */
public class TryCatch {

	private static void inside() throws Exception{
		int a = 0;
		int b = 0;
		try{
			int c = a/b;
		}catch(Exception e){
			System.out.println("inside�������catch");
			//throw new Exception();
		}finally{
			System.out.println("inside�������finally");
		}
	}
	
	private static void testType(){
		int a = 0;
		int b = 0;
		try{
			int c = a/b;
		}catch(ArithmeticException e){
			System.out.println("testType�������catch");
		}finally{
			System.out.println("testType�������finally");
		}
	}
	
	public static void main(String[] args) {
		try{
			//inside();
			testType();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("main�������catch");
		}finally{
			System.out.println("main�������finally");
		}
	}

}

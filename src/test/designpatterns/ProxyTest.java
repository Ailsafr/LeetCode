package test.designpatterns;

/*
 * ��̬����ģʽ
 * ����ģʽ��ĳһ�������ṩһ��������󣬲��ɴ��������ƶ�ԭ��������á�ͨ�׵���������ģʽ�������������г������н顣
 * ������մ�������ʱ�������з���Ļ��� ���Է�Ϊ���֣���̬������̬������̬�������ɳ���Ա�������ض������Զ�����Դ���룬�ڶ�����롣�ڳ���Ա����֮ǰ��������.class�ļ����Ѿ��������ˡ���̬�������ڳ�������ʱͨ��������ƶ�̬�����ġ�
 * ��̬����ģʽ���ŵ㣺���������ڷ��Ͽ���ԭ�������¶�Ŀ�������й�����չ��
 * ��̬����ģʽ��ȱ�㣺���ǵ�Ϊÿһ�����񶼵ô��������࣬������̫�󣬲��׹���ͬʱ�ӿ�һ�������ı䣬������Ҳ����Ӧ�޸ġ�
 */
public class ProxyTest { 
	
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		buyHouse.buyHouse();
		System.out.println("==========================");
		BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
		buyHouseProxy.buyHouse();
	}
	
}

//������ӿ�
interface BuyHouse{
	void buyHouse();
}

//ʵ�ַ���ӿ�
class BuyHouseImpl implements BuyHouse{
	@Override
	public void buyHouse(){
		System.out.println("��");
	}
}

//������
class BuyHouseProxy implements BuyHouse{
	private BuyHouse buyHouse;
	public BuyHouseProxy(final BuyHouse buyHouse){
		this.buyHouse = buyHouse;
	}
	@Override
	public void buyHouse(){
		System.out.println("��ǰ׼��");
		buyHouse.buyHouse();
		System.out.println("�򷿺�װ��");
	}
}

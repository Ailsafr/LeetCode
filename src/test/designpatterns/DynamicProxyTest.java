package test.designpatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * ��̬����ģʽ
 * �ڶ�̬���������ǲ�����Ҫ���ֶ��Ĵ��������࣬����ֻ��Ҫ��дһ����̬�������Ϳ����ˡ������Ĵ��������JDK������ʱΪ���Ƕ�̬����������
 * ע��Proxy.newProxyInstance()������������������
 * ClassLoader loader:ָ����ǰĿ�����ʹ�õ��������,��ȡ�������ķ����ǹ̶���
 * Class<?>[] interfaces:ָ��Ŀ�����ʵ�ֵĽӿڵ�����,ʹ�÷��ͷ�ʽȷ������
 * InvocationHandler:ָ����̬��������ִ��Ŀ�����ķ���ʱ,�ᴥ���¼��������ķ���
 */
public class DynamicProxyTest {
	
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new Class[]{BuyHouse.class}, new DynamicProxyHandler(buyHouse));
		proxyBuyHouse.buyHouse();
	}

}

//��̬������
class DynamicProxyHandler implements InvocationHandler{

	private Object object;
	
	public DynamicProxyHandler(final Object object){
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��ǰ׼��");
		Object result = method.invoke(object, args);
		System.out.println("�򷿺�װ��");
		return result;
	}
	
}
package test.designpatterns;

/*
 * 静态代理模式
 * 代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。通俗的来讲代理模式就是我们生活中常见的中介。
 * 如果按照代理创建的时期来进行分类的话， 可以分为两种：静态代理、动态代理。静态代理是由程序员创建或特定工具自动生成源代码，在对其编译。在程序员运行之前，代理类.class文件就已经被创建了。动态代理是在程序运行时通过反射机制动态创建的。
 * 静态代理模式的优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
 * 静态代理模式的缺点：我们得为每一个服务都得创建代理类，工作量太大，不易管理。同时接口一旦发生改变，代理类也得相应修改。
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

//服务类接口
interface BuyHouse{
	void buyHouse();
}

//实现服务接口
class BuyHouseImpl implements BuyHouse{
	@Override
	public void buyHouse(){
		System.out.println("买房");
	}
}

//代理类
class BuyHouseProxy implements BuyHouse{
	private BuyHouse buyHouse;
	public BuyHouseProxy(final BuyHouse buyHouse){
		this.buyHouse = buyHouse;
	}
	@Override
	public void buyHouse(){
		System.out.println("买房前准备");
		buyHouse.buyHouse();
		System.out.println("买房后装修");
	}
}

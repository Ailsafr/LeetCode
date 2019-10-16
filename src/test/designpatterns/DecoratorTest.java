package test.designpatterns;

/*
 * װ��ģʽ
 * װ����ģʽ��Decorator Pattern��������һ�����еĶ�������µĹ��ܣ�ͬʱ�ֲ��ı���ṹ���������͵����ģʽ���ڽṹ��ģʽ��������Ϊ���е����һ����װ��
 * ����ģʽ������һ��װ���࣬������װԭ�е��࣬���ڱ����෽��ǩ�������Ե�ǰ���£��ṩ�˶���Ĺ��ܡ�
 * �ŵ㣺װ����ͱ�װ������Զ�����չ�������໥��ϣ�װ��ģʽ�Ǽ̳е�һ�����ģʽ��װ��ģʽ���Զ�̬��չһ��ʵ����Ĺ��ܡ�
 * ȱ�㣺���װ�αȽϸ��ӡ�
 * ʹ�ó����� 1����չһ����Ĺ��ܡ� 2����̬���ӹ��ܣ���̬������
 * ����ͨ�������ʵ������ʾװ����ģʽ���÷������У����ǽ���һ����״װ���ϲ�ͬ����ɫ��ͬʱ�ֲ��ı���״�ࡣ
 */
public class DecoratorTest {

	public static void main(String[] args) {
		
		Shape circle = new Circle();
		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();
		
		System.out.println("\nCircle of red border");
		redCircle.draw();
		
		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
	
}

interface Shape {
	void draw();
}

class Rectangle implements Shape {
	
	@Override
	public void  draw() {
		System.out.println("Shape: Rectangle");
	}
}

class Circle implements Shape {
	
	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}

abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;
	
	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	
	public void draw() {
		decoratedShape.draw();
	}
}

class RedShapeDecorator extends ShapeDecorator {
	
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}
	
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}

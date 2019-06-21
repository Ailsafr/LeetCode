package test.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假如有若干个Person对象存在一个List当中，对她们进行排序，分别按照名字，年龄，id进行排序（要有正序与倒序两种排序方式）。
 * 假如年龄或者姓名重复，按照id的正序进行排序。
 */
public class StrategyTest {
	
	public static void main(String[] args){
		Person p1 = new Person(1,"zhangsan",15);
		Person p2 = new Person(2,"lisi",16);
		Person p3 = new Person(3,"wangwu",17);
		Person p4 = new Person(4,"zhaoliu",18);
		Person p5 = new Person(5,"zhangsan",20);
		Person p6 = new Person(6,"lisi",15);
		Person p7 = new Person(7,"wangwu",22);
		Person p8 = new Person(8,"zhaoliu",28);
		Person p9 = new Person(9,"zhangsan",30);
		Person p10 = new Person(10,"zhangsan",15);
		List<Object> list = new ArrayList<Object>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		list.add(p9);
		list.add(p10);
		
		IdSort idSort = new IdSort();
		Environment environment = new Environment(idSort);
		list = environment.sort(list, false);
		
		NameSort nameSort = new NameSort();
		environment.setStrategy(nameSort);
		list = environment.sort(list, true);
		
		AgeSort ageSort = new AgeSort();
		environment.setStrategy(ageSort);
		list = environment.sort(list, false);
		
		for(int i=0;i<list.size();i++){
			Person p = (Person) list.get(i);
			System.out.println(p.getAge()+":"+p.getId());
		}
	}
}

interface SortStrategy{
	public List<Object> compare(List<Object> list, boolean asc);
}

class IdSort implements SortStrategy{
	@Override
	public List<Object> compare(List<Object> list, boolean asc) {
		Object[] array = list.toArray();
		int len = array.length;
		while(len>1){
			for(int i=0;i<len-1;i++){
				Person p1 = (Person) array[i];
				Person p2 = (Person) array[i+1];
				if((p1.getId()>p2.getId()&&asc)||(p1.getId()<p2.getId()&&!asc)){
					Object temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			len--;
		}
		return Arrays.asList(array);
	}
}

class NameSort implements SortStrategy{
	@Override
	public List<Object> compare(List<Object> list, boolean asc) {
		Object[] array = list.toArray();
		int len = array.length;
		while(len>1){
			for(int i=0;i<len-1;i++){
				Person p1 = (Person) array[i];
				Person p2 = (Person) array[i+1];
				if((p1.getName().compareTo(p2.getName())>0&&asc)||(p1.getName().compareTo(p2.getName())<0&&!asc)){
					Object temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}else if(p1.getName().compareTo(p2.getName())==0){
					if(p1.getId()>p2.getId()){
						Object temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
			}
			len--;
		}
		return Arrays.asList(array);
	}
}

class AgeSort implements SortStrategy{
	@Override
	public List<Object> compare(List<Object> list, boolean asc) {
		Object[] array = list.toArray();
		int len = array.length;
		while(len>1){
			for(int i=0;i<len-1;i++){
				Person p1 = (Person) array[i];
				Person p2 = (Person) array[i+1];
				if((p1.getAge()>p2.getAge()&&asc)||(p1.getAge()<p2.getAge()&&!asc)){
					Object temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}else if(p1.getAge()==p2.getAge()){
					if(p1.getId()>p2.getId()){
						Object temp = array[i];
						array[i] = array[i+1];
						array[i+1] = temp;
					}
				}
			}
			len--;
		}
		return Arrays.asList(array);
	}
}

class Environment{
	
	private SortStrategy strategy;
	
	public Environment(SortStrategy strategy){
		this.strategy = strategy;
	}

	public SortStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
	public List<Object> sort(List<Object> list, boolean asc){
		return strategy.compare(list, asc);
	}
	
}

class Person{
	
	private int id;
	private String name;
	private int age;
	
	public Person(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
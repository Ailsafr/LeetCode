package test.designpatterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 策略模式
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
		List<Person> list = new ArrayList<Person>();
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
		
		IdAscSort idAscSort = new IdAscSort();
		Environment environment = new Environment(idAscSort);
		environment.sort(list);
		
		IdDescSort idDescSort = new IdDescSort();
		environment.setStrategy(idDescSort);
		environment.sort(list);
		
		NameAscSort nameAscSort = new NameAscSort();
		environment.setStrategy(nameAscSort);
		environment.sort(list);
		
		NameDescSort nameDescSort = new NameDescSort();
		environment.setStrategy(nameDescSort);
		environment.sort(list);
		
		AgeAscSort ageAscSort = new AgeAscSort();
		environment.setStrategy(ageAscSort);
		environment.sort(list);
		
		AgeDescSort ageDescSort = new AgeDescSort();
		environment.setStrategy(ageDescSort);
		environment.sort(list);
		
		for(int i=0;i<list.size();i++){
			Person p = (Person) list.get(i);
			System.out.println(p.getId() + ":" + p.getName() + "(" + p.getAge() + ")");
		}
	}
}

interface SortStrategy{
	public void compare(List<Person> list);
}

class IdAscSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list,this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getId() - o2.getId();
	}
}

class IdDescSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list,this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o2.getId() - o1.getId();
	}
}

class NameAscSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list, this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getName()==o2.getName()){
			return o1.getId() - o2.getId();
		}
		return o1.getName().compareTo(o2.getName());
	}
	
}

class NameDescSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list, this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getName()==o2.getName()){
			return o1.getId() - o2.getId();
		}
		return o2.getName().compareTo(o1.getName());
	}
	
}

class AgeAscSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list, this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getAge()==o2.getAge()){
			return o1.getId() - o2.getId();
		}
		return o1.getAge() - o2.getAge();
	}
}

class AgeDescSort implements SortStrategy, Comparator<Person>{
	@Override
	public void compare(List<Person> list) {
		Collections.sort(list, this);
	}

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getAge()==o2.getAge()){
			return o1.getId() - o2.getId();
		}
		return o2.getAge() - o1.getAge();
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
	
	public void sort(List<Person> list){
		strategy.compare(list);
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
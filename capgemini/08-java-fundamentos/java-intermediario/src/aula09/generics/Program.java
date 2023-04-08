package aula09.generics;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();
	public static void main(String[] args) {
		Toy t1 = new Toy("ball");
		Toy t2 = new Toy("car");
		Clothes c1 = new Clothes("shorts");
		Clothes c2 = new Clothes("t-shirt");
		
		BoxOfObjects<Object_> b = new BoxOfObjects<>();
		b.addObject(t1);
		b.addObject(c1);
		b.addObject(t2);
		b.addObject(c2);
		
		System.out.printf("%s\n", b);
	}

}

interface Object_ {
	
}

class BoxOfObjects<T> {
	private List<T> content = new ArrayList<T>();
	
	public void addObject(T object) {
		this.content.add(object);
	}
	
	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		for (T t : this.content) {
			sb.append(String.format("%s ", t));
		}
		
		return sb.toString();
	}
}

class Toy implements Object_{
	private String type;
	
	public Toy(String type) {
		this.type = type;

	}
	
	@Override
	public String toString() {	
		return this.type;
	}
}

class Clothes implements Object_{
	private String type;
	
	public Clothes(String type) {
		this.type = type;
	}

	@Override
	public String toString() {	
		return this.type;
	}
}

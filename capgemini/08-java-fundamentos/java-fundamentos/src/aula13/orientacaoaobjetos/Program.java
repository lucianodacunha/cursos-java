package aula13.orientacaoaobjetos;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();
	public static void main(String[] args) {
		Person p = new Person(
				faker.funnyName().name(), faker.number().numberBetween(18, 80));
		
		Person e = new Employee(
				faker.funnyName().name(), faker.number().numberBetween(18, 80),
				faker.number().randomDouble(2, 1200, 10000));			

		printPerson(p);
		printPerson(e);
		
	}
	
	static void printPerson(Person p) {
		System.out.printf("%s\n", p);		
	}

}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
	}

}

class Employee extends Person {
	private double salary;
	
	public Employee(String name, int age, Double salary) {
		super(name, age);
		this.salary = salary;		
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	@Override
	public String toString() {	
		return String.format("%s, Salary: %.2f", 
				super.toString(), this.getSalary());
	}
	
}
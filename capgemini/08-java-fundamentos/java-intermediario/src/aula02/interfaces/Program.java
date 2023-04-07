package aula02.interfaces;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();

	public static void main(String[] args) {
		Authenticable s = new Student(
				faker.name().firstName(), 
				faker.number().numberBetween(18, 80),
				faker.educator().course(), "1234");
		ERP erp = new ERP();
		erp.setPasswd("1234");

		boolean status = erp.login(s);
		System.out.printf("%s\n", s);
		System.out.println("Login: " + status);
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

interface Authenticable {
	boolean login(String passwd);
}

class ERP {
	private String passwd;

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean login(Authenticable authenticable) {
		return authenticable.login(this.passwd);
	}
}

class Student extends Person implements Authenticable {
	private String course;
	private String passwd;

	public Student(String name, int age, String course, String passwd) {
		super(name, age);
		this.course = course;
		this.passwd = passwd;
	}

	public String getCourse() {
		return this.course;
	}

	@Override
	public String toString() {
		return String.format("%s, Course: %s", super.toString(), this.getCourse());
	}

	@Override
	public boolean login(String passwd) {
		return passwd == this.passwd;
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
		return String.format("%s, Salary: %.2f", super.toString(), this.getSalary());
	}

}
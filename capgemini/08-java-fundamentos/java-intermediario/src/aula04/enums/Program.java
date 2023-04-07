package aula04.enums;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();

	public static void main(String[] args) {
		Student s = new Student(faker.name().firstName(), faker.number().numberBetween(18, 80),
				faker.educator().course(), "1234");
		System.out.printf("%s\n", s);
		
		ERP erp = new ERP();
		erp.setPasswd("1234");
		boolean status = erp.login(s);
		System.out.println("Login: " + status);

		double randGrade = faker.number().randomDouble(2, 0, 10);
		System.out.printf("Grade = %.2f\n", randGrade);
		s.calcStatus(randGrade);
		System.out.printf("Status: %s\n", s);

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

enum Status {
	APROVADO("Aprovado"), REPROVADO("Reprovado");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
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
	private Status status;
	private double grade;

	public Student(String name, int age, String course, String passwd) {
		super(name, age);
		this.course = course;
		this.passwd = passwd;
	}

	public String getCourse() {
		return this.course;
	}
	
	public void calcStatus(double grade) {
		if (grade >= 7.0) {
			this.status = Status.APROVADO;
		} else {
			this.status = status.REPROVADO;
		}
	}
	
	public Status getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(
				"%s, Course: %s", super.toString(), this.getCourse()));
		if (this.status != null) {
			sb.append(String.format(", %s.", this.getStatus()));
		}
		
		return sb.toString();
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
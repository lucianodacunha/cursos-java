package aula07.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		int n = faker.number().numberBetween(1, 10);
		List<Student> s = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			s.add(new Student(
						faker.name().firstName(), 
						faker.number().numberBetween(18, 80),
						faker.educator().course(), "1234"));
			s.get(i).setGrades(
					new double[] {
							faker.number().randomDouble(2, 4, 10),
							faker.number().randomDouble(2, 4, 10),
							faker.number().randomDouble(2, 4, 10),
							faker.number().randomDouble(2, 4, 10)
					});
			s.get(i).calcStatus();
		}
		
		System.out.printf("Students: %d\n", s.size());
		s.forEach(student -> {System.out.println(student);});
	
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
	private double[] grades;

	public Student(String name, int age, String course, String passwd) {
		super(name, age);
		this.course = course;
		this.passwd = passwd;
	}

	public String getCourse() {
		return this.course;
	}
	
	public void calcStatus() {
		double average = 0.0;
		
		for(int i = 0; i < this.getGrades().length; i++) {
			average += (this.getGrades()[i] / this.getGrades().length);			
		}

		if (average >= 7.0) {
			this.status = Status.APROVADO;
		} else {
			this.status = Status.REPROVADO;
		}
	}
	
	public double[] getGrades() {		
		return this.grades;
	}
	
	public void setGrades(double[] grades) {
		this.grades = grades;
	}	
	
	public Status getStatus() {
		if (this.status == null)
			this.calcStatus();
		return this.status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(
				"%s, Course: %s", super.toString(), this.getCourse()));
		if (this.status != null) {
			for (int i = 0; i < this.getGrades().length; i++) {
				sb.append(String.format("\nNota %d: %.2f", (i + 1), this.getGrades()[i]));
			}
			sb.append(String.format("\nStatus: %s.", this.getStatus()));
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
package io.github.lucianodacunha.main.cap03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();

	public static void main(String[] args) {		

		Course course = new Course(faker.job().title(), faker.funnyName().name());

		System.out.println("> Creating classes");
		for (int i = 0; i < 5; i++) {
			course.addClass(get_Class());
		}
		
		System.out.println("> Printing course");
		System.out.println(course);
		
		System.out.println("Adding new class\n");
		course.addClass(get_Class());
		
		System.out.println("> Printing course");
		System.out.println(course);
		
		System.out.println("> Testing unmodifiableList classes list");
		List<_Class> newClassesList = new ArrayList<_Class>();
		List<_Class> classesList = course.getClasses();
		classesList = newClassesList;
		
		System.out.println("> Printing course");
		System.out.println(course);
		
	}
	
	static _Class get_Class() {
		return new _Class(faker.educator().course(), (int) (120 + (Math.random() * 180)));
	}

}

class Course {
	private String name;
	private String instructor;
	private List<_Class> _classes = new ArrayList<_Class>();

	public Course(String name, String instructor) {
		super();
		this.name = name;
		this.instructor = instructor;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}
	
	public void addClass(_Class _class) {
		this._classes.add(_class);
	}

	public List<_Class> getClasses() {
		return Collections.unmodifiableList(this._classes);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name: %s\n", this.getName()));
		sb.append(String.format("Instructor: %s\n", this.getInstructor()));
		sb.append("Courses: \n");
		for(_Class c : this.getClasses()) {
			sb.append(c + "\n");
		}		
		
		return sb.toString(); 
	}
}

class _Class implements Comparable<_Class> {
	private static int serial = 1;
	private int id;
	private String name;
	private int duration;

	@Override
	public int compareTo(_Class otherCourse) {
		return this.getName().compareTo(otherCourse.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public _Class(String name, int duration) {
		super();
		this.id = _Class.serial;
		this.name = name;
		this.duration = duration;
		_Class.serial++;
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Name: %s, Duration: %d", 
				this.getId(), this.getName(), this.getDuration());
	}
}
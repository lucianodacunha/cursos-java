package io.github.lucianodacunha.main.cap02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.github.javafaker.Faker;

public class Program {
	private static final Faker faker = new Faker();
	private static int id = 0;

	public static void main(String[] args) {
		
		List<Course> c = new ArrayList<Course>();
		
		System.out.println("> Adding courses");
		for (int i = 0; i < 5; i++) {
			c.add(getCourse());
		}
		
		System.out.println("> Listing courses");
		c.forEach(course -> {System.out.println(course);});
		
		System.out.println("> Sorting courses with Collections, by name");
		Collections.sort(c);
		
		System.out.println("> Listing courses");
		c.forEach(course -> {System.out.println(course);});
		
		System.out.println("> Sorting courses with Comparator, by duration");
		c.sort(Comparator.comparing(Course::getDuration));

		System.out.println("> Listing courses");
		c.forEach(course -> {System.out.println(course);});
		
		System.out.println("> Sorting courses with Collections and Comparator");
		Collections.sort(c, Comparator.comparing(Course::getDuration));
		
		System.out.println("> Listing courses");
		c.forEach(course -> {System.out.println(course);});
		
	}
	
	static Course getCourse() {
		id++;		
		return new Course(
				id,
				faker.educator().course(), 
				(int)(120 + (Math.random() * 280))
				);	
	}

}

class Course implements Comparable<Course>{
	private int id;
	private String name;
	private int duration;

	@Override
	public int compareTo(Course otherCourse) {
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

	public Course(int id, String name, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Name: %s, Duration: %d", 
				this.getId(), this.getName(), this.getDuration());
	}
}

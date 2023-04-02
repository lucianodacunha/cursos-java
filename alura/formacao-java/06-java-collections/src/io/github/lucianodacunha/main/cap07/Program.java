package io.github.lucianodacunha.main.cap07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.javafaker.Faker;

/**
 * Equals e hashCode
 * 
 * @author luciano
 *
 */
public class Program {
	private static final Faker faker = new Faker();

	public static void main(String[] args) {
		Course c = getCourse(5, 5);
		System.out.println(c);	 
		
		Student student = getStudent();
		Student stdTemp = null;
		
		for (Student s : c.getStudents()) {
			stdTemp = s;
		}
		
		System.out.printf("%s contains %s: %s\n",
				c.getName(), student.getName(), 
				c.getStudents().contains(student));

		System.out.printf("%s contains %s: %s\n",
				c.getName(), stdTemp.getName(), 
				c.getStudents().contains(stdTemp));		
		
		try {
			String name = null;
			Student stdNull = new Student(name);			
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}
	
	static Course getCourse(int courses, int students) {
		Course c = new Course(faker.job().title(), faker.funnyName().name());
		c.addClasses(get_Class(courses));
		c.enrollments(getStudents(5));
		
		return c;
	}

	static List<_Class> get_Class(int n) {
		List<_Class> classes = new ArrayList<_Class>();
		
		for(int i = 0; i < n; i++) {
			_Class _class = new _Class(
					faker.educator().course(), 
					(int) (120 + (Math.random() * 180)));
			
			classes.add(_class);
		}

		return classes;
	}
	
	static Student getStudent() {
		return new Student(faker.funnyName().name());
	}
	
	static Set<Student> getStudents(int n) {
		Set<Student> students = new HashSet<Student>();
		
		for (int i = 0; i < 5; i++) {
			Student s = new Student(faker.funnyName().name());
			students.add(s);
		}
		
		return students;
	}

}

class Course {
	private String name;
	private String instructor;
	private List<_Class> _classes = new ArrayList<_Class>();
	private Set<Student> students = new HashSet<Student>();

	public Course(String name, String instructor) {
		super();
		this.name = name;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void addClass(_Class _class) {
		this._classes.add(_class);
	}
	
	public void addClasses(List<_Class> _classes) {
		for (_Class c : _classes)
			this._classes.add(c);
	}
	

	public List<_Class> getClasses() {
		return Collections.unmodifiableList(this._classes);
	}
	
	public void enrollments(Set<Student> students) {
		for (Student s : students)
			this.students.add(s);
	}
	
	public Set<Student> getStudents(){
		return Collections.unmodifiableSet(this.students);
	}

	public int getTotalDuration() {
		int totalDuration = 0;

		for (_Class c : this.getClasses())
			totalDuration += c.getDuration();

		return totalDuration;
	}
	
	public boolean isEnrollment(Student student) {
		return this.getStudents().contains(student);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Course: %s\n", this.getName()));
		sb.append(String.format("Instructor: %s\n", this.getInstructor()));

		sb.append("Classes: \n");
		for (_Class c : this.getClasses()) {
			sb.append(c + "\n");
		}

		sb.append(String.format("Total Duration: %d\n", this.getTotalDuration()));
		
		sb.append("Students: \n");
		for (Student s : this.getStudents()) {
			sb.append(s + "\n");
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
		return String.format("Id: %d, Name: %s, Duration: %d", this.getId(), this.getName(), this.getDuration());
	}
}

class Student {

	private static int serial = 1;
	private int id;
	private String name;

	public Student(String name) {
		if (name == null)
			throw new NullPointerException(
					"Student's name cannot be null");
		this.id = serial;
		this.name = name;
		Student.serial++;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Name: %s", this.getId(), this.getName());
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
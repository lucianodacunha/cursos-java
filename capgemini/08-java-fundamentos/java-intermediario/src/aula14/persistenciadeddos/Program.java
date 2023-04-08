package aula14.persistenciadeddos;

import java.sql.SQLException;

import com.github.javafaker.Faker;

public class Program {

	private static final Faker faker = new Faker();

	public static void main(String[] args) throws SQLException {
		StudentController sc = new StudentController();		
		
		Student student = sc.getById(10);
		System.out.println(student);
		String newCourse = faker.educator().course();
		System.out.println("Alterando course para : " + newCourse);
		student.setCourse(newCourse);
		update(sc, student);
		System.out.println(sc.getById(10));
	}
	
	static void remove(StudentController sc, int id) {
		sc.removeById(id);
	}
	
	static void getAll(StudentController sc) {
		System.out.println("Listando estudantes: ");
		sc.getAll().forEach(student -> {System.out.println(student);});		
	}
	
	static void insert(StudentController sc) {
		Student newStudent = new Student(
				faker.funnyName().name(), 
				faker.educator().course(), 
				faker.number().randomDouble(2, 0, 10));
		
		System.out.println("Gravando novo estudante: ");
		sc.save(newStudent);		
	}
	
	static Student getById(StudentController sc, int id) {
		return sc.getById(id);
	}
	
	static void update(StudentController sc, Student student) {
		sc.update(student);
	}
}
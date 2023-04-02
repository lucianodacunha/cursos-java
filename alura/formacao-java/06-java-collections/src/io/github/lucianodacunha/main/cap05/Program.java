package io.github.lucianodacunha.main.cap05;

import java.util.HashSet;
import java.util.Set;

import com.github.javafaker.Faker;

/**
 * O poder dos sets
 * @author luciano
 *
 */
public class Program {

	private static final Faker faker = new Faker(); 
	
	public static void main(String[] args) {
		
		Set<String> students = new HashSet<String>();
		String student = null;

		for (int i = 0; i < 5; i++) {
			student = faker.funnyName().name();
			students.add(student);
		}

		System.out.println("Last student created: " + student);
		System.out.println("> Adding last student again");
		students.add(student);

		for (String s: students) {
			System.out.println(s);
		}
	}
}

package io.github.lucianodacunha.main.cap01;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


import com.github.javafaker.Faker;

public class Program {
	public static void main(String[] args) {
		
		List<String> cursos = new ArrayList<String>();
		Faker faker = new Faker();
		
		// add cursos
		System.out.println("> Adicionando elementos");
		for (int i = 0; i < 5; i++)
			cursos.add(faker.educator().course() + " :" + i);
		
		System.out.println("> Imprimindo com toString");
		System.out.println(cursos);

		// removendo
		int elemento = (int)(1 + (Math.random() * (cursos.size() - 1)));
		System.out.printf("> Removendo o elemento %d\n", elemento);
		cursos.remove(elemento);		
		System.out.println(cursos);
		
		// acessando e percorrendo
		System.out.println("> Imprimindo com for");
		for(int i = 0; i < cursos.size(); i++)
			System.out.printf("%d: %s\n", i, cursos.get(i));
		
		System.out.println("> Imprimindo com enhanced for");
		for(String curso: cursos)
			System.out.printf("%s\n", curso);
		
		System.out.println("> Imprimindo com .forEach");
		cursos.forEach(curso -> {System.out.println(curso);});

		// ordenando
		System.out.println("> Ordenando com Collections");
		Collections.sort(cursos);
		cursos.forEach(curso -> {System.out.println(curso);});
		
	}

}

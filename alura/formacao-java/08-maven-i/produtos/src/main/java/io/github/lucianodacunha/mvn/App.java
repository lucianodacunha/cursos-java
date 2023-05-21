package io.github.lucianodacunha.mvn;

import com.github.javafaker.Faker;

public class App 
{
	private static final Faker faker = new Faker();

    public static void main( String[] args ){
    	
        Product p1 = new Product(
        		faker.commerce().productName(), 
        		faker.number().randomDouble(2, 10, 1000));
        
        System.out.println(p1);
    }
}

package aula13.trabalhandocomdatas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Program {
	public static void main(String[] args) throws ParseException {
		testDate();
		testCalendar();
	}

	static void testDate() throws ParseException {
		// Date
		// cria uma data informando um long
		Date d0 = new Date(0L);
		// cria uma data considerando o momento atual
		Date d1 = new Date();

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		// imprime no formato padrão de Date
		System.out.println("d0: " + d0);
		System.out.println("d1: " + d1);

		// imprime formatado com SimpleDateFormat
		System.out.println("d0: " + sdf1.format(d0));
		System.out.println("d1: " + sdf1.format(d1));

		System.out.println("d0: " + sdf2.format(d0));
		System.out.println("d1: " + sdf2.format(d1));

		// cria um Date a partir de um texto
		System.out.println(sdf1.parse("01/04/2023"));
		System.out.println(sdf2.parse("01/04/2023 11:30:00"));

		// cria um Date a partir do long que representa o tempo atual
		System.out.println(new Date(System.currentTimeMillis()));

		// cria um Date a partir de um objeto Instant, com timezone
		System.out.println(Date.from(Instant.parse("2023-04-01T11:33:00Z")));
		;
	}

	static void testCalendar() throws ParseException{

		Calendar c = Calendar.getInstance();
		System.out.println("Data no formato Calendar: " + c);
		
		// retorna um Date
		System.out.println("Data no formato Date: " + c.getTime());
		
		// retorna elementos do calendar
		System.out.printf("Elementos de Calendar: %d, %d, %d\n", 
				c.get(Calendar.YEAR), (c.get(Calendar.MONTH) + 1), c.get(Calendar.DAY_OF_MONTH));
		
		// altera elementos do calendar
		c.set(2021, Calendar.JANUARY, 1);
		System.out.println("Data Alterada: " + c.getTime());
		
		// parse de Calendar -> Date -> texto
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d1 = Calendar.getInstance().getTime();
		System.out.println("Data criada com Calendar: " + d1);
		System.out.println("Data formatada: " + sdf.format(d1));
		System.out.println("Data formatada: " + sdf2.format(d1));
	}

}
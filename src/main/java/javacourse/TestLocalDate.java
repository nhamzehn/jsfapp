package javacourse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestLocalDate {

	public static void main(String[] args) {

		LocalDate date1 = LocalDate.now();
		LocalTime time1 = LocalTime.now();
		LocalDateTime dateTime1 = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		String stringDate = "2022-08-08";
		LocalDate date2 = LocalDate.parse(stringDate);

		System.out.println("LocalDate:              " + date1);
		System.out.println("LocalTime:              " + time1);
		System.out.println("LocalDateTime:          " + dateTime1);
		System.out.println("----------------------------------------------------");

		System.out.println("Date after format:      " + formatter.format(dateTime1));
		System.out.println("Convert string to date: " + date2);
		System.out.println("----------------------------------------------------");

		System.out.println("FormatStyle.FULL:       " + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date2));
		System.out.println("FormatStyle.LONG:       " + DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(date2));
		System.out.println("FormatStyle.MEDIUM:     " + DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date2));
		System.out.println("FormatStyle.SHORT:      " + DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(date2));
		System.out.println("----------------------------------------------------");

		formatter = DateTimeFormatter.ofPattern("hh:mm:ss a"); // HH -> 24, hh -> 12, : -> we can replace it with any character
		System.out.println("Time after format:      " + formatter.format(time1));
		System.out.println("----------------------------------------------------");
		
		System.out.println("Is " + formatter.format(time1) + " before mid night: " + time1.isBefore(LocalTime.MIDNIGHT));
		System.out.println("Is " + formatter.format(time1) + " after noon:       " + time1.isAfter(LocalTime.NOON));
		System.out.println("----------------------------------------------------");

	}

}

package test.functional;

import java.text.ParseException;


public class MainFunctional {

	public static void main(String[] args) {
		
		try {
			FunctionalTests.clientAppointments();
			System.out.println("\nAppointments functional tests passed!\n");
		}
		catch(ParseException e) {
			System.out.println("Date error in clientAppontments functional tests");
		}
		
		FunctionalTests.foodGroups();
		
		System.out.println("\nAll functional tests passed!\n");

	}

}

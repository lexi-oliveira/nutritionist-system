package test.functional;

import java.text.ParseException;


public class MainFunctional {

	public static void main(String[] args) {
		
		try {
			FunctionalTests.clientAppointments();
			
		}
		catch(ParseException e) {
			System.out.println("Date error in Appointment unitary tests");
		}

	}

}

package test.unitary;

import java.text.ParseException;

public class MainUnitary {

	public static void main(String[] args) {
		
		System.out.println("Inicio testes unitarios:\n");
		
		UnitaryFood.allUnitaryTests();
		System.out.println("All Food unitary tests passed!\n");
		
		try {
			UnitaryAppointment.allUnitaryTests();
			System.out.println("All Appointment unitary tests passed!\n");
		}
		catch(ParseException e) {
			System.out.println("Date error in Appointment unitary tests");
		}
		
		try {
			UnitaryClient.allUnitaryTests();
			System.out.println("All Client unitary tests passed!\n");
		}
		catch(ParseException e) {
			System.out.println("Date error in Appointment unitary tests");
		}
		
		System.out.println("Termino: ");

	}

}

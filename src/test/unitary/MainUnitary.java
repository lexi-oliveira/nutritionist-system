package test.unitary;

import java.text.ParseException;

public class MainUnitary {

	public static void main(String[] args) {
		
		System.out.println("Inicio testes unitarios:\n");
		
		UnitaryFood.allUnitaryTests();
		System.out.println("All food unitary tests passed!\n");
		
		try {
			UnitaryAppointment.allUnitaryTests();
			System.out.println("All appointment unitary tests passed!\n");
		}
		catch(ParseException e) {
			System.out.println("Date error");
		}
		
		System.out.println("Termino");

	}

}

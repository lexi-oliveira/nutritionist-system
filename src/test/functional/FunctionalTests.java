package test.functional;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Appointment;
import entities.Client;

public class FunctionalTests {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");  // for the client
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");  // for the appointment 
	
	public static void clientAppointments() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf1.parse("25/06/2018"));
		
		Appointment app1 = new Appointment(sdf2.parse("10/02/2015 09:21"), 65.0, 20.0, "Indisposta", "Sem chocolate");
		Appointment app2 = new Appointment(sdf2.parse("01/01/2016 15:00"), 70.2, 23.0, "Animada", "Sem cafe");
		Appointment app3 = new Appointment(sdf2.parse("12/08/2017 13:20"), 68.9, 22.0, "Ansiosa", "Sem leite");
		Appointment app4 = new Appointment(sdf2.parse("07/03/2018 08:42"), 67.1, 21.0, "Animada", "Sem carboidrato");
		Appointment app5 = new Appointment(sdf2.parse("25/06/2019 17:30"), 64.5, 19.5, "Indisposta", "Sem leite");
		
		client.addAppointment(app1);
		client.addAppointment(app2);
		client.addAppointment(app3);
		client.addAppointment(app4);
		client.addAppointment(app5);
		
		System.out.println("\nExpected five appointments in descending order of dates: ");
		client.showAppointmens();
		
		client.removeAppointment(sdf2.parse("25/06/2019 17:30"));
		client.removeAppointment(sdf2.parse("10/02/2015 09:21"));
		
		System.out.println("Expected three appointments - first will be 07/03/2018 08:42: ");
		client.showAppointmens();
		System.out.println("Last appointment expected above: 01/01/2016 15:00 ");
		
	}
}

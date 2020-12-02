package test.unitary;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Client;

public class UnitaryClient {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  // static for all objects to have the same and unique date format
	
	public static void constructors() throws ParseException {
		Client client = new Client();
		assert client.getName() == null : "Client constructor initialization error";
		assert client.getAddress() == null : "Client constructor initialization error";
		assert client.getPhone() == null : "Client constructor initialization error";
		assert client.getEmail() == null : "Client constructor initialization error";
		assert client.getBirthDate() == null : "Client constructor initialization error";
		
		client = new Client("Sonia", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert client.getName().equals("Sonia") : "Client constructor initialization error: name";
		assert client.getAddress().equals("Rua Claudio Soares") : "Client constructor initialization error: address";
		assert client.getPhone().equals("31 99324-2321") : "Client constructor initialization error: phone";
		assert client.getEmail().equals("sonia.soares@gmail.com") : "Client constructor initialization error: email";
		assert sdf.format(client.getBirthDate()).equals("25/06/2018") : "Client constructor initialization error: birth date";
 	}
	
	public static void getName() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert client.getName().equals("Sonia Soares Souza") : "Error in Client getName()";
	}
	
	public static void setName() {
		Client client = new Client();
		client.setName("Sonia Soares Souza");
		assert client.getName().equals("Sonia Soares Souza") : "Error in Client setName()";
	}
	
	public static void getAddress() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert client.getAddress().equals("Rua Claudio Soares") : "Error in Client getAddress()";
	}
	
	public static void setAddress() {
		Client client = new Client();
		client.setAddress("Rua Claudio Soares");
		assert client.getAddress().equals("Rua Claudio Soares") : "Error in Client setAddress()";
	}
	
	public static void getPhone() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert client.getPhone().equals("31 99324-2321") : "Error in Client getPhone()";
	}
	
	public static void setPhone() {
		Client client = new Client();
		client.setPhone("31 99324-2321");
		assert client.getPhone().equals("31 99324-2321") : "Error in Client setPhone()";
	}
	
	public static void getEmail() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert client.getEmail().equals("sonia.soares@gmail.com") : "Error in Client getEmail()";
	}
	
	public static void setEmail() {
		Client client = new Client();
		client.setEmail("sonia.soares@gmail.com");
		assert client.getEmail().equals("sonia.soares@gmail.com") : "Error in Client setEmail()";
	}
	
	public static void getBirthDate() throws ParseException {
		Client client = new Client("Sonia Soares Souza", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf.parse("25/06/2018"));
		assert sdf.format(client.getBirthDate()).equals("25/06/2018") : "Error in Client getBirhDate()";
	}
	
	public static void setBirthDate() throws ParseException {
		Client client = new Client();
		client.setBirthDate(sdf.parse("25/06/2018"));
		assert sdf.format(client.getBirthDate()).equals("25/06/2018") : "Error in Client setBirhDate()";
	}
	
	public static void allUnitaryTests() throws ParseException{
		UnitaryClient.constructors();
		UnitaryClient.getName();
		UnitaryClient.setName();
		UnitaryClient.getAddress();
		UnitaryClient.setAddress();
		UnitaryClient.getPhone();
		UnitaryClient.setPhone();
		UnitaryClient.getEmail();
		UnitaryClient.setEmail();
		UnitaryClient.getBirthDate();
		UnitaryClient.setBirthDate();
	}
}

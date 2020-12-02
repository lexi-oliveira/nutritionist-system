package test.unitary;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Appointment;

public class UnitaryAppointment {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");  // static for all objects to have the same and unique date format
	
	public static void constructors() throws ParseException { // unitary tests of Appointment constructors
		Appointment appointment = new Appointment();
		assert appointment.getDate() == null : "Appointment constructor initialization error";
		assert appointment.getWeightPatient() == null : "Appointment constructor initialization error";
		assert appointment.getBodyFatPercentage() == null : "Appointment constructor initialization error"; 
		assert appointment.getPhysicalSensation() == null : "Appointment constructor initialization error";
		assert appointment.getDietaryRestrictions() == null : "Appointment constructor initialization error";
		appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert sdf.format(appointment.getDate()).equals("25/06/2018 15:42") : "Appointment constructor initialization error: date";
		assert appointment.getWeightPatient() == 65.0 : "Appointment constructor initialization error: weightPatient";
		assert appointment.getBodyFatPercentage() == 20.0 : "Appointment constructor initialization error: bodyFatPercentage"; 
		assert appointment.getPhysicalSensation().equals("Indisposto") : "Appointment constructor initialization error: physicalSensation";
		assert appointment.getDietaryRestrictions().equals("Sem chocolate") : "Appointment constructor initialization error: dietaryRestrictions";
	}
	
	public static void getDate() throws ParseException {
		Appointment appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert sdf.format(appointment.getDate()).equals("25/06/2018 15:42") : "Error in Appointment getDate()";
	}
	
	public static void setDate() throws ParseException {
		Appointment appointment = new Appointment();
		appointment.setDate(sdf.parse("25/06/2018 15:42"));
		assert sdf.format(appointment.getDate()).equals("25/06/2018 15:42") : "Error in Appointment setDate()";
	}
	
	public static void getWeightPatient() throws ParseException {
		Appointment appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert appointment.getWeightPatient() == 65.0 : "Error in Appointment getWeightPatient()";
	}
	
	public static void setWeightPatient() {
		Appointment appointment = new Appointment();
		appointment.setWeightPatient(65.0);
		assert appointment.getWeightPatient() == 65.0 : "Error in Appointment setWeightPatient()";
	}
	
	public static void getBodyFatPercentage() throws ParseException {
		Appointment appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert appointment.getBodyFatPercentage() == 20.0 : "Error in Appointment getBodyFatPercentage()";
	}
	
	public static void setBodyFatPercentage() {
		Appointment appointment = new Appointment();
		appointment.setBodyFatPercentage(20.0);
		assert appointment.getBodyFatPercentage() == 20.0 : "Error in Appointment setBodyFatPercentage()";
	}
	
	public static void getPhysicalSensation() throws ParseException {
		Appointment appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert appointment.getPhysicalSensation().equals("Indisposto") : "Error in Appointment getPhysicalSensation()";
	}
	
	public static void setPhysicalSensation() {
		Appointment appointment = new Appointment();
		appointment.setPhysicalSensation("Indisposto");
		assert appointment.getPhysicalSensation().equals("Indisposto") : "Error in Appointment setPhysicalSensation()";
	}
	
	public static void getDietaryRestrictions() throws ParseException {
		Appointment appointment = new Appointment(sdf.parse("25/06/2018 15:42"), 65.0, 20.0, "Indisposto", "Sem chocolate");
		assert appointment.getDietaryRestrictions().equals("Sem chocolate") : "Error in Appointment getDietaryRestrictions()";
	}
	
	public static void setDietaryRestrictions() {
		Appointment appointment = new Appointment();
		appointment.setDietaryRestrictions("Sem chocolate");
		assert appointment.getDietaryRestrictions().equals("Sem chocolate") : "Error in Appointment setDietaryRestrictions()";
	}
	
	public static void allUnitaryTests() throws ParseException {
		UnitaryAppointment.constructors();
		UnitaryAppointment.getDate();
		UnitaryAppointment.setDate();
		UnitaryAppointment.getWeightPatient();
		UnitaryAppointment.setWeightPatient();
		UnitaryAppointment.getBodyFatPercentage();
		UnitaryAppointment.setBodyFatPercentage();
		UnitaryAppointment.getPhysicalSensation();
		UnitaryAppointment.setPhysicalSensation();
		UnitaryAppointment.getDietaryRestrictions();
		UnitaryAppointment.setDietaryRestrictions();
	}
}

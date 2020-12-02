package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // static for all objects to have the same date format
	
	private Date date;
	private Double weightPatient;
	private Double bodyFatPercentage;
	private String physicalSensation;
	private String dietaryRestrictions;	
	
	public Appointment() {
	}

	public Appointment(Date date, Double weightPatient, Double bodyFatPercentage, String physicalSensation,
			String dietaryRestrictions) {
		this.date = date;
		this.weightPatient = weightPatient;
		this.bodyFatPercentage = bodyFatPercentage;
		this.physicalSensation = physicalSensation;
		this.dietaryRestrictions = dietaryRestrictions;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getWeightPatient() {
		return weightPatient;
	}

	public void setWeightPatient(Double weightPatient) {
		this.weightPatient = weightPatient;
	}

	public Double getBodyFatPercentage() {
		return bodyFatPercentage;
	}

	public void setBodyFatPercentage(Double bodyFatPercentage) {
		this.bodyFatPercentage = bodyFatPercentage;
	}

	public String getPhysicalSensation() {
		return physicalSensation;
	}

	public void setPhysicalSensation(String physicalSensation) {
		this.physicalSensation = physicalSensation;
	}

	public String getDietaryRestrictions() {
		return dietaryRestrictions;
	}

	public void setDietaryRestrictions(String dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data e horario da consulta: ");
		sb.append(sdf.format(date) + "\n");
		sb.append("Peso do paciente: ");
		sb.append(weightPatient + "\n");
		sb.append("Porcentagem de gordura corporal: ");
		sb.append(String.format("%.2f",bodyFatPercentage) + "%\n");
		sb.append("Sensacao fisica: ");
		sb.append(physicalSensation + "\n");
		sb.append("Restricoes alimentares: ");
		sb.append(dietaryRestrictions + "\n");
		return sb.toString();
	}
}

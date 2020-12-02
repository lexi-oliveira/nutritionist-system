package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
	
	private String name;
	private String address;
	private String phone;
	private String email;
	private Date birthDate;
	
	private List<Appointment> appointments = new ArrayList<>();
	
	public Client() {
	}

	public Client(String name, String address, String phone, String email, Date birthDate) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Appointment> getAppointmens() {
		return appointments;
	}
	
	public void addAppointment(Appointment newAppointment) {
		appointments.add(0, newAppointment);
	}
	
	public boolean removeAppointment(Date appointmentDate) {
		for(Appointment app : appointments) {
			if(app.getDate() == appointmentDate) {
				appointments.remove(app);
				return true;
			}
		}
		return false;
	}
	
	public void showAppointmens() {
		System.out.println("CONSULTAS REALIZADAS: ");
		for(Appointment app : appointments) {
			System.out.println(app + "\n\n");
		}
	}
}

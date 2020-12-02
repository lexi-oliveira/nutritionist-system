package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Appointment;
import entities.Client;
import entities.Food;
import entities.FoodGroups;
import entities.Group;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");  // for the client
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");  // for the appointment
		
		int choose = 1;
		
		List<Client> clients = new ArrayList<>();
		
		try {
			clients.add(new Client("Sonia", "Rua Claudio Soares", "31 99324-2321", "sonia.soares@gmail.com", sdf1.parse("25/06/1998")));
			clients.add(new Client("Roberta", "Rua Benetino Silva", "31 99324-2221", "roberta@gmail.com", sdf1.parse("13/01/2002")));
			clients.add(new Client("Camila", "Rua Souza Costa", "31 99623-2983", "camila@gmail.com", sdf1.parse("17/12/1987")));
			
			clients.get(0).addAppointment(new Appointment(sdf2.parse("01/09/2010 09:21"), 55.0, 10.0, "Indisposta", "Sem chocolate"));
			clients.get(0).addAppointment(new Appointment(sdf2.parse("02/08/2011 09:21"), 63.0, 20.0, "Indisposta", "Sem cafe"));
			clients.get(0).addAppointment(new Appointment(sdf2.parse("12/07/2012 09:21"), 65.0, 22.0, "Indisposta", "Sem leite"));
			
			clients.get(1).addAppointment(new Appointment(sdf2.parse("13/06/2013 09:21"), 67.0, 24.0, "Indisposta", "Sem amido"));
			clients.get(1).addAppointment(new Appointment(sdf2.parse("14/05/2014 09:21"), 65.0, 20.0, "Indisposta", "Sem acucar"));
			clients.get(1).addAppointment(new Appointment(sdf2.parse("15/04/2015 09:21"), 63.0, 10.0, "Indisposta", "Sem cha"));
			
			clients.get(2).addAppointment(new Appointment(sdf2.parse("16/03/2016 09:21"), 80.0, 30.0, "Indisposta", "Sem chocolate"));
			clients.get(2).addAppointment(new Appointment(sdf2.parse("17/02/2017 09:21"), 75.0, 30.0, "Indisposta", "Sem refrigerante"));
			clients.get(2).addAppointment(new Appointment(sdf2.parse("18/01/2018 09:21"), 70.0, 20.0, "Indisposta", "Sem biscoitos"));
		}catch (ParseException e) {
			System.out.println("\nErro nas datas dos clientes previamente cadastrados!\n");
		}
		
		FoodGroups.addFood(new Food("Acucar", 50.0, Group.valueOf("GROUP1")));
		FoodGroups.addFood(new Food("Arroz", 50.0, Group.valueOf("GROUP1")));
		FoodGroups.addFood(new Food("Noz", 100.0, Group.valueOf("GROUP1")));
		FoodGroups.addFood(new Food("Maca", 200.0, Group.valueOf("GROUP1")));
		FoodGroups.addFood(new Food("Chocolate", 200.0, Group.valueOf("GROUP1")));
		
		FoodGroups.addFood(new Food("Salsa", 50.0, Group.valueOf("GROUP2")));
		FoodGroups.addFood(new Food("Pepino", 50.0, Group.valueOf("GROUP2")));
		FoodGroups.addFood(new Food("Tomate", 100.0, Group.valueOf("GROUP2")));
		FoodGroups.addFood(new Food("Pera", 200.0, Group.valueOf("GROUP2")));
		FoodGroups.addFood(new Food("Cebola", 200.0, Group.valueOf("GROUP2")));
		
		FoodGroups.addFood(new Food("Mamao", 50.0, Group.valueOf("GROUP3")));
		FoodGroups.addFood(new Food("Melao", 50.0, Group.valueOf("GROUP3")));
		FoodGroups.addFood(new Food("Melancia", 100.0, Group.valueOf("GROUP3")));
		FoodGroups.addFood(new Food("Carne", 200.0, Group.valueOf("GROUP3")));
		FoodGroups.addFood(new Food("Caju", 200.0, Group.valueOf("GROUP3")));
		
		do {
			try {
				
				System.out.println("\n ---- SISTEMA NUTRICIONAL ---\n");
				menuOutput();
				choose = sc.nextInt();
				
				switch(choose) {
				
				case 1:{
					System.out.println("\n ---- CLIENTES CADASTRADOS NO SISTEMA ---\n");
					Collections.sort(clients);
					for (Client client : clients) {
						System.out.println(client);
					}
					break;
				}
				case 2:{
					sc.nextLine();
					System.out.println("\n ---- CADASTRO DE CLIENTE ---\n");
					System.out.print("Digite o nome: ");
					String name = sc.nextLine();
					System.out.print("Digite o endereço: ");
					String address = sc.nextLine();
					System.out.print("Digite o telefone: ");
					String phone = sc.nextLine();
					System.out.print("Digite o email: ");
					String email = sc.nextLine();
					System.out.print("Digite a data de nascimento no formato dd/mm/aaaa:");
					Date birthDate = sdf1.parse(sc.nextLine());
					
					clients.add(new Client(name, address, phone, email, birthDate));
					
					System.out.println("\nCLIENTE CADASTRADO!\n");
					
					break;
				}
				case 3: {
					sc.nextLine();
					System.out.println("\n --- REMOVER UM CLIENTE --- \n");
					
					System.out.println("CLIENTES QUE CONSTAM NO SISTEMA: ");
					Collections.sort(clients);
					
					for(Client client : clients) {
						System.out.println("  - " + client.getName());	
					}
					System.out.println();
					
					System.out.print("Digite o nome completo do cliente: ");
					String name = sc.nextLine();
					
					Client c = new Client();
					
					for(Client client : clients) {
						if (name.equals(client.getName())) {
							c = client;
						}
					}
					
					if (c.getName() != null) {
						clients.remove(c);
						System.out.println("\nCLIENTE REMOVIDO COM SUCESSO!\n");
					}else {
						System.out.println("\nCLIENTE NAO ENCONTRADO!\n");
					}
					
					break;
										
				}
				case 4: {
					sc.nextLine();
					System.out.println("\n --- EXIBIR CONSULTAS REGISTRADAS DE UM CLIENTE --- \n");
					
					System.out.println("CLIENTES QUE CONSTAM NO SISTEMA: ");
					Collections.sort(clients);
					
					for(Client client : clients) {
						System.out.println("  - " + client.getName());
						
					}
					
					System.out.print("\nDigite o nome completo do cliente: ");
					String name = sc.nextLine();
					
					Client c = new Client();
					
					for(Client client : clients) {
						if (name.equals(client.getName())) {
							c = client;
						}
					}
					
					if (c.getName() != null) {
						if (c.getAppointmens().isEmpty()) {
							System.out.println("\nCLIENTE NAO POSSUI CONSULTAS CADASTRADAS!");
						}else {
							c.showAppointmens();
							System.out.print("\nDeseja remover alguma consulta?\nDigite 'S' para sim: ");
							char option = sc.next().toUpperCase().charAt(0);
							if(option == 'S') {
								sc.nextLine();
								System.out.print("Digite a data e horario da consulta a ser removida no formato dd/mm/aaaa hh:mm : ");
								if (c.removeAppointment(sdf2.parse(sc.nextLine()))) {
									System.out.println("\nCONSULTA REMOVIDA!\n");
								} else {
									System.out.println("\nNAO FOI POSSIVEL ENCONTRAR A CONSULTA INFORMADA!\n");
								}
							}
						}
						
					}else {
						System.out.println("\nCLIENTE INFORMADO NAO CONSTA NO SISTEMA!\n");
					}
						
					
					break;
					
				}
				case 5: {
					sc.nextLine();
					System.out.println("\n --- REGISTRAR UMA NOVA CONSULTA --- \n");
					
					System.out.println("CLIENTES QUE CONSTAM NO SISTEMA: ");
					Collections.sort(clients);
					
					for(Client client : clients) {
						System.out.println("  - " + client.getName());	
					}
					System.out.println();
					
					System.out.print("Digite o nome completo do cliente: ");
					String name = sc.nextLine();
					
					Client c = new Client();
					
					for(Client client : clients) {
						if (name.equals(client.getName())) {
							c = client;
						}
					}
					
					if (c.getName() != null) {
							
						System.out.print("Digite a data e horario da consulta a ser registrada no formato dd/mm/aaaa hh:mm : ");
						String date = sc.nextLine();
						System.out.print("Digite o peso: ");
						double weight = sc.nextDouble();
						System.out.print("Digite a porcentagem de gordura corporal: ");
						double bodyFat = sc.nextDouble();
						sc.nextLine();
						System.out.print("Digite a sensacao fisica do paciente: ");
						String phySen = sc.nextLine();
						System.out.print("Digite as restricoes alimentares atribuidas ao paciente: ");
						String dieRes = sc.nextLine();
						
						c.addAppointment(new Appointment(sdf2.parse(date), weight, bodyFat, phySen, dieRes));
						
						System.out.println("\nCONSULTA RESGISTRADA!\n");
						
					}else {
						System.out.println("\nCLIENTE INFORMADO NAO CONSTA NO SISTEMA!\n");
					}
					break;
										
				}
				
				case 6: {
					sc.nextLine();
					System.out.println("\n --- DETERMINAR TODAS COMBINACOES DE ALIMENTOS REGISTRADOS SOB UM LIMITE DE CONSUMO CALORICO --- \n");
					
					System.out.print("Digite o limite calorico: ");
					double limit = sc.nextDouble();
					
					FoodGroups.showCombinations(FoodGroups.caloricCombinations(limit));
					
					break;
				}
				case 7: {
					System.out.println("\n --- EXIBIR TODOS ALIMENTOS REGISTRADOS NO SITEMA --- \n");
					FoodGroups.showFoodGroups();
					break;
					
				}
				case 8: {
					sc.nextLine();
					System.out.println("\n --- CADASTRAR UM ALIMENTO NO SISTEMA --- \n");
					
					System.out.print("Digite o nome do alimento: ");
					String name = sc.nextLine();
					System.out.print("Digite o valor calorico do alimento: ");
					double cal = sc.nextDouble();
					sc.nextLine();
					System.out.println("Digite o grupo a que ele pertence: ");
					System.out.print("		GROUP1\n		GROUP2\n		GROUP3:");
					String group = sc.nextLine().toUpperCase();
					
					FoodGroups.addFood(new Food(name, cal, Group.valueOf(group)));
					
					System.out.println("\n ALIMENTO ADICIONADO AO GRUPO!");
					FoodGroups.showFoodGroups();
					
					break;
										
				}
				case 9: {
					sc.nextLine();
					System.out.println("\n --- REMOVER ALIMENTO DO SISTEMA --- \n");
					
					FoodGroups.showFoodGroups();
					
					System.out.print("\nDigite o nome do alimento a ser removido: ");
					String name = sc.nextLine();
					System.out.println("Digite o grupo a qual ele pertence: ");
					System.out.print("		GROUP1\n		GROUP2\n		GROUP3:");
					String group = sc.nextLine().toUpperCase();
					
					if(FoodGroups.removeFood(name, Group.valueOf(group))) {
						System.out.println("\n ALIMENTO REMOVIDO DO GRUPO!");
						FoodGroups.showFoodGroups();
					}else {
						System.out.println("\n NAO FOI POSSIVEL ENCONTRAR O ALIMENTO!");
					}
					
					break;
					
				}
				default: {
					System.out.println("\n OPCAO INVALIDA!");
					break;
				}
				case 0:{
					System.out.println("\n ---VOCE SAIU DO SISTEMA. ATE LOGO!---");
					break;
				}
				
				}
				
			}catch (InputMismatchException e) {
				System.out.println("\nENTRADA INVALIDA!");
				sc.nextLine();
			}catch (ParseException e) {
				System.out.println("\nDATA INVALIDA! OPERACAO NAO REALIZADA!");
			}catch(IllegalArgumentException e){
				System.out.println("\nGRUPO INVALIDO! ALIMENTO NAO REGISTRADO!");
			}
			
		}while(choose != 0);
		
		
		sc.close();

	}
	
	public static void menuOutput() {
		System.out.println("Escolha uma opcao:");
		System.out.println("1 - Exibir dados dos clientes cadastrados");
		System.out.println("2 - Cadastrar um cliente");
		System.out.println("3 - Remover um cliente");
		System.out.println("4 - Exibir consultas registradas de um cliente");
		System.out.println("5 - Registrar uma nova consulta");
		System.out.println("6 - Determinar todas as combinacoes de alimentos sob um limite calorico");
		System.out.println("7 - Exibir todos alimentos registrados no sistema");
		System.out.println("8 - Cadastrar alimento no sistema");
		System.out.println("9 - Remover alimento do sistema");
		System.out.println("0 - Encerrar o sistema");
		System.out.print("Digite o numero correspondente a opcao escolhida: ");
	}

}

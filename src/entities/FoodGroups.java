package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodGroups {
	private static List<Food> group1 = new ArrayList<>();
	private static List<Food> group2 = new ArrayList<>();
	private static List<Food> group3 = new ArrayList<>();
	
	public static List<Food> getGroup1(){
		return group1;
	}
	
	public static List<Food> getGroup2(){
		return group2;
	}
	
	public static List<Food> getGroup3(){
		return group3;
	}
	
	public static void addFood(Food newFood) {
		if (newFood.getGroupIdentifier() == Group.GROUP1) {
			group1.add(newFood);
			Collections.sort(group1);
		}
		else if (newFood.getGroupIdentifier() == Group.GROUP2) {
			group2.add(newFood);
			Collections.sort(group2);
		}
		else {
			group3.add(newFood);
			Collections.sort(group3);
		}
	}
	
	public static boolean removeFood(String name, Group gp) {
		if(gp == Group.GROUP1) {
			for(Food food : group1) {
				if (food.getName().equals(name)) {
					group1.remove(food);
					return true;
				}
			}
			return false;
		} else if (gp == Group.GROUP2) {
			for(Food food : group2) {
				if (food.getName().equals(name)) {
					group2.remove(food);
					return true;
				}
			}
			return false;
		} else {
			for(Food food : group3) {
				if (food.getName().equals(name)) {
					group3.remove(food);
					return true;
				}
			}
			return false;
		}
	}
	
	public static void showFoodGroups() { // formatting for output
		System.out.print("\nGRUPOS ALIMENTARES: \n");
		
		System.out.print("GRUPO 1: ");
		for(Food food : group1) {
			System.out.print(food + " | ");
		}
		System.out.println();
		
		System.out.print("GRUPO 2: ");
		for(Food food : group2) {
			System.out.print(food + " | ");
		}
		System.out.println();
		
		System.out.print("GRUPO 3: ");
		for(Food food : group3) {
			System.out.print(food + " | ");
		}
		System.out.println();
	}
	
	public static List<Food> combinationGroups(List<Food> first, List<Food> second, List<Food> third, Double  caloricLimit) { //verification of available foods within the calorie limit
		List<Food> combinations = new ArrayList<>();
		for(int i = 0; i < first.size(); i++) {
			for(int j = 0; j < second.size(); j++) {
				if (first.get(i).getCaloricAmount() + second.get(j).getCaloricAmount() > caloricLimit) {
					j = second.size();
				}
				else {
					for(int k = 0; k < third.size(); k++) {
						if(first.get(i).getCaloricAmount() + second.get(j).getCaloricAmount() 
								+ third.get(k).getCaloricAmount() <= caloricLimit) {
							combinations.add(first.get(i));
							combinations.add(second.get(j));
							combinations.add(third.get(k));
						}
						else {
							k = third.size();
						}
					}
				}
			}
		}
		
		return combinations;
	}
	
	public static List<Food> caloricCombinations(Double caloricLimit){ // implies that will start comparing from the largest to the smallest food group
		
		if(group1.size() >= group2.size() && group1.size() >= group3.size()) {
			if(group2.size() >= group3.size()) {
				return combinationGroups(group1, group2, group3, caloricLimit);
			}
			else {
				return combinationGroups(group1, group3, group2, caloricLimit);
			}
		}
		else if(group2.size() >= group3.size()) {
			if(group1.size() >= group3.size()) {
				return combinationGroups(group2, group1, group3, caloricLimit);
			}
			else {
				return combinationGroups(group2, group3, group1, caloricLimit);
			}
		}
		else {
			if(group1.size() >= group2.size()) {
				return combinationGroups(group3, group1, group2, caloricLimit);
			}
			else {
				return combinationGroups(group3, group2, group1, caloricLimit);
			}
		}
	}
	
	public static void showCombinations(List<Food> combinations) { // formatting for output
		int i = 1, j = 0;
		System.out.println("\nCOMBINACOES POSSIVEIS DE ALIMENTOS PARA ESSA DIETA:\n");
		
		if(combinations.isEmpty()) {
			System.out.println("NAO HA COMBINACOES POSSIVEIS PARA ESSE LIMITE CALORICO!");
		}
		else {
			for (Food food : combinations) {
				if (j == 0) {
					System.out.print((i) + " - " );
				}
				System.out.print(food + " | ");
				j++;
				if (j%3 == 0 && j != 0) {
					i++;
					j = 0;
					System.out.println();
				}
			}
		}
		
	}
}

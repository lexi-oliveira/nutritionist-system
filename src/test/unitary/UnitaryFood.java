package test.unitary;

import entities.Food;
import entities.Group;

public class UnitaryFood {
	
	public static void constructors() { // unitary tests of Food constructors
		Food food = new Food();
		assert food.getName() == null : "Constructor initialization error";
		assert food.getCaloricAmount() == null : "Constructor initialization error";
		assert food.getGroupIdentifier() == null : "Constructor initialization error";
		food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getName() == "Rice" : "Constructor initialization error: name";
		assert food.getCaloricAmount() == 4.184 : "Constructor initialization error: caloric";
		assert food.getGroupIdentifier() == Group.GROUP1 : "Constructor initialization error: group identifier";
	}
	
	public static void getName() { // unitary test of Food getName()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getName() == "Rice" : "Get name error";
	}
	
	public static void setName() { // unitary test of Food setName()
		Food food = new Food();
		food.setName("Rice");
		assert food.getName() == "Rice" : "Set name error";
	}
	
	public static void getCaloricAmount() { // unitary test of Food getCaloricAmount()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getCaloricAmount() ==  4.184 : "Get caloric amount error";
	}
	
	public static void setCaloricAmount() { // unitary test of Food setCaloricAmount()
		Food food = new Food();
		food.setCaloricAmount(4.184);
		assert food.getCaloricAmount() ==  4.184 : "Set caloric amount error";
	}
	
	public static void getGroupIdentifier() { // unitary test of Food getGroupIdentifier()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getGroupIdentifier() == Group.GROUP1 : "Get group identifier error";
	}
	
	public static void setGroupIdentifier() { // unitary test of Food setGroupIdentifier()
		Food food = new Food();
		food.setGroupIdentifier(Group.valueOf("GROUP1"));
		assert food.getGroupIdentifier() == Group.GROUP1 : "Set group identifier error";
	}
	
	public static void to_String() { // unitary test of Food toString()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.toString().equals("Rice, 4.184 cal")  : "Error: toString Food"; // comparison with the output formatting expected
	}
	
	public static void foodAllUnitaryTests() {
		UnitaryFood.constructors();
		UnitaryFood.getName();
		UnitaryFood.setName();
		UnitaryFood.getCaloricAmount();
		UnitaryFood.setCaloricAmount();
		UnitaryFood.getGroupIdentifier();
		UnitaryFood.setGroupIdentifier();
		UnitaryFood.to_String();
	}
}

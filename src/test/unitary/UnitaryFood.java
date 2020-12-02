package test.unitary;

import entities.Food;
import entities.Group;

public class UnitaryFood {
	
	public static void constructors() { // unitary tests of Food constructors
		Food food = new Food();
		assert food.getName() == null : "Food constructor initialization error";
		assert food.getCaloricAmount() == null : "Food constructor initialization error";
		assert food.getGroupIdentifier() == null : "Food constructor initialization error";
		food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getName().equals("Rice")  : "Food constructor initialization error: name";
		assert food.getCaloricAmount() == 4.184 : "Food constructor initialization error: caloric";
		assert food.getGroupIdentifier() == Group.GROUP1 : "Food constructor initialization error: group identifier";
	}
	
	public static void getName() { // unitary test of Food getName()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getName().equals("Rice") : "Error in Food getName()";
	}
	
	public static void setName() { // unitary test of Food setName()
		Food food = new Food();
		food.setName("Rice");
		assert food.getName().equals("Rice") : "Error in Food setName()";
	}
	
	public static void getCaloricAmount() { // unitary test of Food getCaloricAmount()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getCaloricAmount() ==  4.184 : "Error in Food  getCaloric()";
	}
	
	public static void setCaloricAmount() { // unitary test of Food setCaloricAmount()
		Food food = new Food();
		food.setCaloricAmount(4.184);
		assert food.getCaloricAmount() ==  4.184 : "Error in Food setCaloricAmount()";
	}
	
	public static void getGroupIdentifier() { // unitary test of Food getGroupIdentifier()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.getGroupIdentifier() == Group.GROUP1 : "Error in Food getGroupIdentifier()";
	}
	
	public static void setGroupIdentifier() { // unitary test of Food setGroupIdentifier()
		Food food = new Food();
		food.setGroupIdentifier(Group.valueOf("GROUP1"));
		assert food.getGroupIdentifier() == Group.GROUP1 : "Error in Food setGroupIdentifier()";
	}
	
	public static void to_String() { // unitary test of Food toString()
		Food food = new Food("Rice", 4.184, Group.valueOf("GROUP1"));
		assert food.toString().equals("Rice, 4.184 cal")  : "Error in Food toString"; // comparison with the output formatting expected
	}
	
	public static void allUnitaryTests() {
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

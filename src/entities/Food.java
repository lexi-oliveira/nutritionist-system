package entities;

public class Food implements Comparable<Food> {
	
	private String name;
	private Double caloricAmount;
	private Group groupIdentifier;
	
	public Food() { 
	}
	
	public Food(String name, Double caloricAmount, Group groupIdentifier) {
		this.name = name;
		this.caloricAmount = caloricAmount;
		this.groupIdentifier = groupIdentifier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Double getCaloricAmount() {
		return caloricAmount;
	}

	public void setCaloricAmount(Double caloricAmount) {
		this.caloricAmount = caloricAmount;
	}

	public Group getGroupIdentifier() {
		return groupIdentifier;
	}

	public void setGroupIdentifier(Group groupIdentifier) {
		this.groupIdentifier = groupIdentifier;
	}
	
	@Override
    public int compareTo(Food f) {
        return this.getCaloricAmount().compareTo(f.getCaloricAmount());
    }
	
	@Override
	public String toString() {
		return getName()
				+ ", "
				+ getCaloricAmount()
				+ " cal";
	}
}

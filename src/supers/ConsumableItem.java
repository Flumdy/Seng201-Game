package supers;

public class ConsumableItem {
	//variables
	public String name;
	public boolean consumed = false;
	//types are hunger and health
	public String bonusType;
	public int bonusAmount;
	public int cost;
	
	public ConsumableItem() {
	}
/*
	public ConsumableItem(String name, String bonusType, int bonusAmount, int cost) {
		this.name = name;
		this.bonusType = bonusType;
		this.bonusAmount = bonusAmount;
		this.cost = cost;
	}
*/
	//consume method
	public int consume() {
		this.consumed = true;
		//we want to put a check if food has been conumed on update????????
		return this.getBonusAmount();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isConsumed() {
		return consumed;
	}

	public void setConsumed(boolean consumed) {
		this.consumed = consumed;
	}

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}

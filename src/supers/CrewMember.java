package supers;

public class CrewMember {
	//basics
	public String name;
	public String type;
	public int money;
	
	//starting stats
	public int health = 100;
	public int hunger = 100;
	public int tiredness = 100;
	
	//degrading rates
	public int healthdeg;
	public int hungerdeg;
	public int tireddeg;
	
	//abilities
	
	public CrewMember(String name, String type) {
		this.name = name;
		this.type = type;
		//switch for diffrent types of type
		switch(type) {
		case "Scout":
			//Special Atributes here
			break;
		case "Engineer":
			//Special Atributes here
			break;
		case "Captain":
			//Special Atributes here
			break;
		case "Medic":
			//Special Atributes here
			break;
		case "Chef":
			//Special Atributes here
			break;
		case "Security":
			//Special Atributes here
			break;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public int getTiredness() {
		return tiredness;
	}
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	public int getHealthdeg() {
		return healthdeg;
	}
	public void setHealthdeg(int healthdeg) {
		this.healthdeg = healthdeg;
	}
	public int getHungerdeg() {
		return hungerdeg;
	}
	public void setHungerdeg(int hungerdeg) {
		this.hungerdeg = hungerdeg;
	}
	public int getTireddeg() {
		return tireddeg;
	}
	public void setTireddeg(int tireddeg) {
		this.tireddeg = tireddeg;
	}

}

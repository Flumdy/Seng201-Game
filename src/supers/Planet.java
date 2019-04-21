package supers;

import java.util.Random;

public class Planet {
	public String name;
	public double partDropChance;
	public double moneyDropChance;
	public double healthDropChance;
	public double foodDropChance;
	
	public Planet(String name, int partDropMax, int foodDropMax, int healthDropMax, int moneyDropMax) {
		this.name = name;
		Random rand = new Random();
		//these can be changed / need tweaking
		this.partDropChance = rand.nextInt(partDropMax);
		this.foodDropChance = rand.nextInt(foodDropMax);
		this.healthDropChance = rand.nextInt(healthDropMax);
		this.moneyDropChance = rand.nextInt(moneyDropMax);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPartDropChance() {
		return partDropChance;
	}

	public void setPartDropChance(double partDropChance) {
		this.partDropChance = partDropChance;
	}

	public double getMoneyDropChance() {
		return moneyDropChance;
	}

	public void setMoneyDropChance(double moneyDropChance) {
		this.moneyDropChance = moneyDropChance;
	}

	public double getHealthDropChance() {
		return healthDropChance;
	}

	public void setHealthDropChance(double healthDropChance) {
		this.healthDropChance = healthDropChance;
	}

	public double getFoodDropChance() {
		return foodDropChance;
	}

	public void setFoodDropChance(double foodDropChance) {
		this.foodDropChance = foodDropChance;
	}
}

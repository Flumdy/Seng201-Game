package supers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import items.Bandage;
import items.Brownie;
import items.CaffeinePills;
import items.Coffee;
import items.HealthPack;
import items.Liquorice;
import items.PeanutButter;
import items.PotatoesAndCheese;
import items.RoastDinner;
import items.SpacePasta;
import items.SpacePlagueCure;

/**
 * Super class defining planets. <br>
 * Players are able to visit planets where they can find<br>
 * items and spaceship parts, as well as the possibility for<br>
 * a random event to occur.
 *  
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Planet {
	public String name;
	public boolean partPresent;
	public boolean visited = false;
	public double moneyDropChance;
	public double healthDropChance;
	public double foodDropChance;
	public ArrayList<ConsumableItem> foodList;
	public ArrayList<ConsumableItem> medList;
	
	/**
	 * Constructor for planet object.
	 * 
	 * @param name Name of planet.
	 * @param partPresent Whether or not it as a spaceship part to be found.
	 * @param foodDropMax Maximum probability for a food item to be found.
	 * @param healthDropMax Maximum probability for a health item to be found.
	 * @param moneyDropMax Maximum probability for money to be found.
	 */
	public Planet(boolean partPresent, int foodDropMax, int healthDropMax, int moneyDropMax) {
		this.name = generateName();
		Random rand = new Random();
		//these can be changed / need tweaking
		this.partPresent = partPresent;
		this.foodDropChance = rand.nextInt(foodDropMax);
		this.healthDropChance = rand.nextInt(healthDropMax);
		this.moneyDropChance = rand.nextInt(moneyDropMax);
		foodList = new ArrayList<>(Arrays.asList(new Coffee(), new Brownie(), new CaffeinePills(), new Liquorice(),
				new PeanutButter(), new RoastDinner(), new PotatoesAndCheese(), new SpacePasta()));
		medList = new ArrayList<>(Arrays.asList(new Bandage(), new HealthPack(), new SpacePlagueCure()));
	}

	/**
	 * Upon searching planet presents any items found, whether or not <br>
	 * the player found a part, and any events that may have occurred.
	 * 
	 * @param spaceShip Spaceship object for any found items to be added to.
	 */
	public String search(SpaceShip spaceShip) {
		int chance = ThreadLocalRandom.current().nextInt(0, 100);
		String retString = "<html>";
		if(chance < this.foodDropChance) {
			ConsumableItem food = foodList.get(ThreadLocalRandom.current().nextInt(0, foodList.size()));
			retString += "You found some " + food.toString() + ", hope its not too old<br/>";
			spaceShip.addToInventory(food);
		}
		chance = ThreadLocalRandom.current().nextInt(0, 100);
		if(chance < this.healthDropChance) {
			ConsumableItem meds = medList.get(ThreadLocalRandom.current().nextInt(0, medList.size()));
			retString += "You found " + meds.toString() + "<br/>";
			spaceShip.addToInventory(meds);
		}
		chance = ThreadLocalRandom.current().nextInt(0, 100);
		if(chance < this.moneyDropChance) {
			int moneyAdd = ThreadLocalRandom.current().nextInt(0, 50);
			retString += "YOu made $" + moneyAdd + ", finders keepers or losers weepers?<br/>";
			spaceShip.setMoney(spaceShip.getMoney() + moneyAdd);
		}
		if(this.isPartPresent()) {
			retString += "You found a spaceship part! <br/>";
			spaceShip.setTempPartFound(true);
		}
		retString += "</html>";
		return retString;
	}
	
	/**
	 * Method for generating a random name for the planet
	 */
	public String generateName() {
		  
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    return generatedString;
	}
	
	
	
	/**
	 * Get method for name of planet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name of planet.
	 * 
	 * @param name Name of planet.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get method for whether or not there is a part <br>
	 * present on planet.
	 */
	public boolean getpartPresent() {
		return partPresent;
	}

	/**
	 * Set method for whether or not a part is <br>
	 * present on planet.
	 * 
	 * @param partPresent Whether or not part is present.
	 */
	public void setpartPresent(boolean partPresent) {
		this.partPresent = partPresent;
	}

	/**
	 * Get method for chance of money being found on planet.
	 */
	public double getMoneyDropChance() {
		return moneyDropChance;
	}

	/**
	 * Set method for chance of money being found on planet.
	 * 
	 * @param moneyDropChance Chance of money being found on planet.
	 */
	public void setMoneyDropChance(double moneyDropChance) {
		this.moneyDropChance = moneyDropChance;
	}

	/**
	 * Get method for chance of health item being found on planet.
	 */
	public double getHealthDropChance() {
		return healthDropChance;
	}

	/**
	 * Set method for chance of health item being found on planet.
	 * 
	 * @param healthDropChance Chance of health item being found on planet.
	 */
	public void setHealthDropChance(double healthDropChance) {
		this.healthDropChance = healthDropChance;
	}

	/**
	 * Get method for chance of food item being found on planet.
	 */
	public double getFoodDropChance() {
		return foodDropChance;
	}

	/**
	 * Set method for chance of food item being found on planet.
	 * 
	 * @param foodDropChance Chance of food item being found on planet.
	 */
	public void setFoodDropChance(double foodDropChance) {
		this.foodDropChance = foodDropChance;
	}

	/**
	 * Whether or not the planet has been visited.
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Set method for whether or not planet has been visited.
	 * 
	 * @param visited Boolean variable that is true if planet has been <br>
	 * visited, false otherwise.
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", partPresent=" + partPresent + ", visited=" + visited + ", moneyDropChance="
				+ moneyDropChance + ", healthDropChance=" + healthDropChance + ", foodDropChance=" + foodDropChance
				+ "]";
	}

	/**
	 * Whether part is present on planet.
	 */
	public boolean isPartPresent() {
		return partPresent;
	}

	/**
	 * Set method for whether or not part is present on planet.
	 * 
	 * @param partPresent Boolean variable that is true if part is present <br>
	 * on planet, false otherwise.
	 */
	public void setPartPresent(boolean partPresent) {
		this.partPresent = partPresent;
	}
}

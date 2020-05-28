package supers;

import java.util.ArrayList;

import items.Bandage;
import items.Brownie;
import items.SpacePlagueCure;

/**
 * Super class defining the spaceship.
 * The spaceship contains an inventory, a wallet, a list <br>
 * of the crew members, and a cage of the shield strength.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class SpaceShip {
	public int money;
	public int shields;
	public ArrayList<ConsumableItem> inventory = new ArrayList<>();
	public ArrayList<CrewMember> crewList = new ArrayList<>();
	public String name;
	public boolean tempPartFound = false;
	
	public SpaceShip(String name) {
		this.name = name;
		this.money = 40;
		//start with half shields
		this.shields = 50;
		this.inventory.add(new Bandage());
		this.inventory.add(new Brownie());
	}
	
	/**
	 * Get method for retrieving a specific crew <br>
	 * members stats.
	 * 
	 * @param name Name of crew member.
	 */
	public CrewMember getCrewMember(String name){
		for (CrewMember crewMember: this.crewList){
			if(crewMember.getName().equals(name)) {
				return crewMember;
			}
		}
		return null;
	}
	
	/**
	 * Repair the spaceships shields. Bonus if <br>
	 * crew member repairing is an engineer.
	 * 
	 * @param crewMember Crew member performing the repair.
	 */
	public int repair(CrewMember crewMember) {
		//implement special abilites
		if(crewMember.getType().equals("Engineer")) {
			this.setShields(this.getShields() + 40);
		}else {
			this.setShields(this.getShields() + 20);
		}
		return this.shields;
	}
	
	/**
	 * Add crew member to ships crew.
	 * 
	 * @param crewMember Crew member to be added.
	 */
	public void addCrewMember(CrewMember crewMember) {
		this.crewList.add(crewMember);
	}

	/**
	 * Add an item to the inventory.
	 * 
	 * @param item Item to be added to inventory.
	 */
	public void addToInventory(ConsumableItem item) {
		this.inventory.add(item);
	}
	
	/**
	 * Remove item from inventory.
	 * 
	 * @param item Item to be removed from inventory.
	 */
	public void removeFromInventory(ConsumableItem item) {
		//need to remove one instance of the item from invetory
		this.inventory.remove(item);
	}
	
	/**
	 * Removes item from inventory upon consumption.
	 * 
	 * @param itemIndex Index of item to be removed.
	 */
	public ConsumableItem removeFromInventory(int itemIndex) {
		//need to remove one instance of the item from invetory
		ConsumableItem retItem = this.inventory.get(itemIndex);
		this.inventory.remove(itemIndex);
		return retItem;
	}
	
	/**
	 * Take points off shields health.
	 * 
	 * @param damage Damage done to shields.
	 */
	public void takeDamage(int damage) {
		this.shields -= damage;
	}
	
	/**
	 * Repair spaceship shields.
	 * 
	 * @param repairAmount Amount to repair by.
	 */
	public void repairShields(int repairAmount) {
		this.shields += repairAmount;
	}
	
	/**
	 * Get method for amount of money in ships wallet.
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * Set method for amount of money in ships wallet.
	 * 
	 * @param money Money to set wallet amount to.
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * Get method for shield strength of ship.
	 */
	public int getShields() {
		return shields;
	}
	
	/**
	 * Set method for shield strength of ship.
	 * 
	 * @param shields Strength for shields to be set to.
	 */
	public void setShields(int shields) {
		this.shields = shields;
	}
	
	/**
	 * Get method for items in ships inventory.
	 */
	public ArrayList<ConsumableItem> getInventory() {
		return inventory;
	}
	
	/**
	 * Set method for items in ships inventory.
	 * 
	 * @param inventory Array of items to be in ships inventory.
	 */
	public void setInventory(ArrayList<ConsumableItem> inventory) {
		this.inventory = inventory;
	}

	/**
	 * Get method for crew members on ship.
	 */
	public ArrayList<CrewMember> getCrewList() {
		return crewList;
	}

	/**
	 * Set method for crew members on ships crew.
	 * 
	 * @param crewList Array of crew members to be in crew.
	 */
	public void setCrewList(ArrayList<CrewMember> crewList) {
		this.crewList = crewList;
	}

	/**
	 * Get method for name of ship.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name of ship.
	 * 
	 * @param name Name of ship.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Whether or not a temporary part has been found.
	 */
	public boolean isTempPartFound() {
		return tempPartFound;
	}

	/**
	 * Set method for whether or not a temporary part has been found.
	 * 
	 * @param tempPartFound Boolean variable that is true if temporary part <br>
	 * is found, false otherwise.
	 */
	public void setTempPartFound(boolean tempPartFound) {
		this.tempPartFound = tempPartFound;
	}
	
	//basically the player class
	//needs money and inventory
} 

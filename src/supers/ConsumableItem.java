package supers;

/**
 * Super class defining consumable items. <br>
 *Consumable items can be found on any planet and their drop rates are <br>
 *randomly generated. They can also be bought from any store.<br>
 *All items can only be used once before they are consumed,<br>
 *however there is no limit to how many items you can possess <br>
 *at any given time.<br>
 *
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class ConsumableItem {
	//variables
	public String name;
	public boolean consumed = false;
	//types are hunger, health, energy, spaceplaguecure
	public String bonusType;
	public int bonusAmount;
	public int cost;
	
	/**
	 * Constructor for ConsumableItem.
	 */
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
	/**
	 * Get method for name of item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set method for name of item.
	 * 
	 * @param name Name of the item.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns whether or not the item has been used.
	 */
	public boolean isConsumed() {
		return consumed;
	}

	/**
	 * Set method for whether or not the item has been used.
	 * 
	 * @param consumed Boolean variable that is true if it has been used, false otherwise.
	 */
	public void setConsumed(boolean consumed) {
		this.consumed = consumed;
	}

	/**
	 * Get method for bonus type of the item.
	 */
	public String getBonusType() {
		return bonusType;
	}

	/**
	 * Set method for the bonus type of the item.
	 * 
	 * @param bonusType Bonus type of item.
	 */
	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	/**
	 * Get method for bonus amount granted by item.
	 */
	public int getBonusAmount() {
		return bonusAmount;
	}

	/**
	 * Set method for the bonus amount granted by item.
	 * 
	 * @param bonusAmount Amount to be granted.
	 */
	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	/**
	 * Get method for the cost of an item.
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Set method for the cost of an item.
	 * 
	 * @param cost Cost of item.
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	//TODO ass we need to display the cost on only the shoppe
	/**
	 * Prints infromation on item.
	 */
	public String toString() {
		return "($" + this.cost + ") " + name + ", Boosts " + bonusType + " by " + bonusAmount;
	}
}

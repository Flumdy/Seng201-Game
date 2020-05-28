package items;

import supers.ConsumableItem;

/**
 * Brownies are a consumable food item
 * which cost 10 units from any store and 
 * restore 15 points of hunger.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Brownie extends ConsumableItem{
	
	/**
	 * Constructor for brownie item.
	 */
	public Brownie() {
		super.name = "Brownie";
		super.bonusType = "hunger";
		super.bonusAmount = 15;
		super.cost = 10;
	}

}

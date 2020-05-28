package items;

import supers.ConsumableItem;

/**
 * RoastDinner is a consumable food item
 * which cost 70 units from any store 
 * and restore 25 points of hunger.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class RoastDinner extends ConsumableItem{
	
	/**
	 * Constructor for roast dinner item.
	 */
	public RoastDinner() {
		super.name = "Roast Dinner";
		super.bonusType = "hunger";
		super.bonusAmount = 70;
		super.cost = 25;
	}
}

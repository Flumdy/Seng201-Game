package items;

import supers.ConsumableItem;

/**
 * PeanutButter is a consumable food item
 * which cost 5 units from any store 
 * and restore 27 points of hunger.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class PeanutButter extends ConsumableItem{
	
	/**
	 * Constructor for peanutbutter item.
	 */
	public PeanutButter() {
		super.name = "Peanut Butter";
		super.bonusType = "hunger";
		super.bonusAmount = 27;
		super.cost = 5;
	}
}

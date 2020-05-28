package items;

import supers.ConsumableItem;

/**
 * Coffee is a consumable energy item
 * which cost 5 units from any store 
 * and restore 15 points of energy.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Coffee extends ConsumableItem{
	
	/**
	 * Constructor for coffee item.
	 */
	public Coffee() {
		super.name = "Brownie";
		super.bonusType = "energy";
		super.bonusAmount = 15;
		super.cost = 5;
	}

}
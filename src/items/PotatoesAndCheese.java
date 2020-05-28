package items;

import supers.ConsumableItem;

/**
 * PotatoesAndCheese is a consumable food item
 * which cost 6 units from any store 
 * and restore 30 points of health.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class PotatoesAndCheese extends ConsumableItem {
	
	/**
	 * Constructor for potatoes and cheese item.
	 */
	public PotatoesAndCheese() {
		super.name = "Potatoes And Cheese";
		super.bonusType = "hunger";
		super.bonusAmount = 30;
		super.cost = 6;
	}
}

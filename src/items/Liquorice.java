package items;

import supers.ConsumableItem;

/**
 * Liquorice is a consumable food item
 * which cost 2 units from any store 
 * and restore 10 points of hunger.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Liquorice extends ConsumableItem{
	
	/**
	 * Constructor for liquorice item.
	 */
	public Liquorice() {
		super.name = "Liquorice";
		super.bonusType = "hunger";
		super.bonusAmount = 10;
		super.cost = 2;
	}
}

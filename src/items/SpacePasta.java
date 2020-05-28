package items;

import supers.ConsumableItem;

/**
 * SpacePasta is a consumable food item
 * which cost 13 units from any store 
 * and restore 25 points of hunger.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class SpacePasta extends ConsumableItem{

	/**
	 * Constructor for space pasta item.
	 */
	public SpacePasta() {
		super.name = "Space 'Pasta'";
		super.bonusType = "hunger";
		super.bonusAmount = 25;
		super.cost = 13;
	}
}


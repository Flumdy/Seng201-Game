package items;

import supers.ConsumableItem;

/**
 * Bandages are a consumable health item
 * which cost 20 units from any store 
 * and restore 15 points of health.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Bandage extends ConsumableItem{
	
	/**
	 * Constructor for bandage item.
	 */
	public Bandage() {
		super.name = "Bandage";
		super.bonusType = "health";
		super.bonusAmount = 15;
		super.cost = 20;
	}
}

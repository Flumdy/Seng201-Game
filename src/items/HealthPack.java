package items;

import supers.ConsumableItem;

/**
 * HealthPacks are a consumable health item
 * which cost 37 units from any store 
 * and restore 25 points of health.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class HealthPack extends ConsumableItem{
	
	/**
	 * Constructor for health pack item.
	 */
	public HealthPack() {
		super.name = "Health Pack";
		super.bonusType = "health";
		super.bonusAmount = 25;
		super.cost = 37;
	}

}

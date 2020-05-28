package items;

import supers.ConsumableItem;

/**
 * CaffeinePills are a consumable energy item
 * which cost 15 units from any store and 
 * restore 35 points of energy.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class CaffeinePills extends ConsumableItem{
	
	/**
	 * Constructor for caffeine pills item.
	 */
	public CaffeinePills() {
		super.name = "Caffeine pills";
		super.bonusType = "energy";
		super.bonusAmount = 35;
		super.cost = 15;
	}

}
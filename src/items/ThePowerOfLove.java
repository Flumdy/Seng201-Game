package items;

import supers.ConsumableItem;
import java.util.Scanner;

/**
 * ThePowerOfLove is a consumable health item
 * which cost 50 units from any store 
 * and restore 100 points of health.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class ThePowerOfLove extends ConsumableItem{
	
	boolean sold = false;
	
	/**
	 * Constructor for the power of love item.
	 */
	public ThePowerOfLove() {
		super.name = "The Power Of Love";
		super.bonusType = "health";
		super.bonusAmount = 100;
		super.cost = 50;
	}
	
}

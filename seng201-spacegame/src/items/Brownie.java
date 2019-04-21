package items;

import supers.ConsumableItem;

public class Brownie extends ConsumableItem{
	
	public Brownie() {
		super.name = "Brownie";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 15;
		super.cost = 10;
		//special effects ??? lmao
	}

}

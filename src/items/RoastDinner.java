package items;

import supers.ConsumableItem;

public class RoastDinner extends ConsumableItem{
	
	public RoastDinner() {
		super.name = "Roast Dinner";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 70;
		super.cost = 25;
	}
}

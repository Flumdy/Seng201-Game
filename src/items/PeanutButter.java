package items;

import supers.ConsumableItem;

public class PeanutButter extends ConsumableItem{
	
	public PeanutButter() {
		super.name = "Peanut Butter";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 27;
		super.cost = 5;
	}
}

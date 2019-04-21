package items;

import supers.ConsumableItem;

public class PotatoesAndCheese extends ConsumableItem {
	
	public PotatoesAndCheese() {
		super.name = "Potatoes And Cheese";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 30;
		super.cost = 6;
	}
}

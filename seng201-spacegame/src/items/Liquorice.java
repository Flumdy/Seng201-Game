package items;

import supers.ConsumableItem;

public class Liquorice extends ConsumableItem{
	
	public Liquorice() {
		super.name = "Liquorice";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 10;
		super.cost = 2;
	}
}

package items;

import supers.ConsumableItem;

public class SpacePasta extends ConsumableItem{

	public SpacePasta() {
		super.name = "Space 'Pasta'";
		//types are hunger and health
		super.bonusType = "hunger";
		super.bonusAmount = 25;
		super.cost = 13;
	}
}


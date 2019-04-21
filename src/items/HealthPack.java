package items;

import supers.ConsumableItem;

public class HealthPack extends ConsumableItem{
	
	public HealthPack() {
		super.name = "Health Pack";
		//types are hunger and health
		super.bonusType = "health";
		super.bonusAmount = 25;
		super.cost = 37;
		//special effects ??? lmao
	}

}

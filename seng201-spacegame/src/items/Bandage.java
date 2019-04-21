package items;

import supers.ConsumableItem;

public class Bandage extends ConsumableItem{
	
	public Bandage() {
		super.name = "Bandage";
		//types are hunger and health
		super.bonusType = "health";
		super.bonusAmount = 15;
		super.cost = 20;
		//special effects ??? lmao
	}
}

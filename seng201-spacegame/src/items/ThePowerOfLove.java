package items;

import supers.ConsumableItem;

public class ThePowerOfLove extends ConsumableItem{
	
	public ThePowerOfLove() {
		super.name = "The Power Of Love";
		//types are hunger and health
		super.bonusType = "health";
		super.bonusAmount = 100;
		super.cost = 150;
		//special effects ??? lmao
	}
}

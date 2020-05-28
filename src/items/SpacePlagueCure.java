package items;

import supers.ConsumableItem;

/**
 * SpacePlagueCure is a consumable item
 * which cures the space plague with no additional bonus effects.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class SpacePlagueCure extends ConsumableItem{

	/**
	 * Constructor for space plague item.
	 */
	public SpacePlagueCure() {
		super.bonusType = "spaceplaguecure";
		super.name = "Space Plague Cure";
	}

	/**
	 * Overrides 'toString' method from ConsumableItems superclass to include a description.
	 */
	@Override
	public String toString() {
		return this.name + ", cures the space plague";
	}
}
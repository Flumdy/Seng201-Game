package supers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import items.Bandage;
import items.Brownie;
import items.CaffeinePills;
import items.Coffee;
import items.HealthPack;
import items.Liquorice;
import items.PeanutButter;
import items.PotatoesAndCheese;
import items.RoastDinner;
import items.SpacePasta;
import items.SpacePlagueCure;
import items.ThePowerOfLove;
import main.GameEnviroment;

/**
 * Super class defining the shop . <br>
 * Players are able to visit the shop for health, food, or energy items. <br>
 * These items can be added to a cart before being purchased. <br>
 * The items are then added to your ships inventory.
 *  
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class Shop {
	public ArrayList<ConsumableItem> inventory;
	public ArrayList<ConsumableItem> possibleItems;
	public ArrayList<ConsumableItem> cart;
	
	/**
	 * Initialize shop and its contents.
	 */
	public Shop() {
		possibleItems = new ArrayList<>(Arrays.asList(new Coffee(), new Brownie(), new CaffeinePills(), new Liquorice(),
				new PeanutButter(), new RoastDinner(), new PotatoesAndCheese(), new SpacePasta(),
				new Bandage(), new HealthPack(), new SpacePlagueCure()));
		inventory = new ArrayList<>();
		cart = new ArrayList<ConsumableItem>();
		for(int i = 0; i <= 4; i++) {
			int tempRand = ThreadLocalRandom.current().nextInt(0, this.possibleItems.size());
			inventory.add(possibleItems.get(tempRand));
		}
		inventory.add(new ThePowerOfLove());
		System.out.println(inventory);
	}
	
	/**
	 * Add two new items to the shop each day.
	 */
	public void newItems() {
		//add two new random items each day
		inventory.add(possibleItems.get(ThreadLocalRandom.current().nextInt(0, this.possibleItems.size())));
		inventory.add(possibleItems.get(ThreadLocalRandom.current().nextInt(0, this.possibleItems.size())));
	}
	
	/**
	 * Remove items from cart and add them back to store inventory.
	 */
	public void returnItems() {
		for(ConsumableItem item : cart) {
			this.inventory.add(item);
			this.cart.remove(item);
		}
	}
	
	/**
	 * Add item to cart if it can be afforded.
	 * 
	 * @param item Item to be added to cart.
	 * @param game Game object with which players wallet can be accessed.
	 * @param cartCost Cost of items currently in cart.
	 */
	public int addToCart(ConsumableItem item, GameEnviroment game, int cartCost) {
		if(cartCost + item.getCost() < game.getSpaceShip().getMoney()) {
			this.inventory.remove(item);
			this.cart.add(item);
			return item.getCost();
		}
		return 0;
	}
	
	/**
	 * Purchase items which are added to player inventory and <br>
	 * total of cart cost is taken from players wallet.
	 * 
	 * @param game Game object with which players wallet and inventory can be updated.
	 */
	public void checkOut(GameEnviroment game) {
		for(ConsumableItem item : cart) {
			game.getSpaceShip().setMoney(game.getSpaceShip().getMoney() - item.getCost());
			game.getSpaceShip().inventory.add(item);
		}
		this.cart.clear();
	}
	
	/**
	 * Prints information on shop inventory
	 */
	public String toString() {
		return "Shop [inventory=" + inventory + "]";
	}

	/**
	 * Get method for items available in shop.
	 */
	public ArrayList<ConsumableItem> getInventory() {
		return inventory;
	}

	/**
	 * Set method for items available in shop.
	 * 
	 * @param inventory Array of items that are available in shop.
	 */
	public void setInventory(ArrayList<ConsumableItem> inventory) {
		this.inventory = inventory;
	}

	/**
	 * Get method for possible items shop can stock.
	 */
	public ArrayList<ConsumableItem> getPossibleItems() {
		return possibleItems;
	}

	/**
	 * Set method for possible items shop can stock.
	 * 
	 * @param possibleItems Array of items possible for the shop to stock.
	 */
	public void setPossibleItems(ArrayList<ConsumableItem> possibleItems) {
		this.possibleItems = possibleItems;
	}

	/**
	 * Get method for items in cart.
	 */
	public ArrayList<ConsumableItem> getCart() {
		return cart;
	}

	/**
	 * Set method for updating items in cart.
	 * 
	 * @param cart Array of items in the cart.
	 */
	public void setCart(ArrayList<ConsumableItem> cart) {
		this.cart = cart;
	}
	
}

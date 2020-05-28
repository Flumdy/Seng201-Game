package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import items.RoastDinner;
import supers.ConsumableItem;
import supers.CrewMember;
import supers.Planet;
import supers.Shop;
import supers.SpaceShip;

/**
 * Main class through which all game info is stored and shared.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class GameEnviroment {
	int gameDays = 0;
	int currentDay = 0;
	int shipPieces;
	int shipPiecesFound = 0;
	int planetCount;
	int crewMemeberCount = 0;
	boolean allFound = false;
	public CrewMember currentCrewMember;
	SpaceShip spaceShip;
	Planet currentPlanet;
	Shop shop;
	public ArrayList<Planet> planets = new ArrayList<Planet>();
	
	/**
	 * Initiate all preliminary game attributes. <br>
	 * Ship parts, planets, crew members, and shop. 
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public void init(GameEnviroment game) {
		//this is for selecting characters and length
		shipPieces = Math.round((gameDays*2)/3);
		//here we need to create a new spaceship object
		//need to init planets
		planetCount = gameDays;
		shop = new Shop();
		for(int j = 0; j < planetCount; j++) {
			//now we generate the correct amount of planets
			//name, part present,  int foodDropMax, int healthDropMax, int moneyDropMax
			if(j < game.shipPieces) {
				Planet planet = new Planet(true, randomPcChance(70), randomPcChance(50), randomPcChance(60));
				planets.add(planet);
			}else {
				Planet planet = new Planet(false, randomPcChance(70), randomPcChance(50), randomPcChance(60));
				planets.add(planet);
			}
		}
		game.currentPlanet = game.planets.get(ThreadLocalRandom.current().nextInt(0, game.planets.size()));
		this.currentCrewMember = this.spaceShip.getCrewList().get(0);
		//adding extra items to inventory for chefs
		for(CrewMember crewMember : game.getSpaceShip().getCrewList()) {
			if(crewMember.getType().equals("Chef")) {
				game.getSpaceShip().getInventory().add(new RoastDinner());
			}else if(crewMember.getType().equals("Captain")) {
				for(CrewMember crewMember2 : game.getSpaceShip().getCrewList()) {
					crewMember2.setTiredness(120);
				}
			}
		}
	}
	
	/**
	 * Consume an item to gain its effects and remove <br>
	 * it from players inventory.
	 * 
	 * @param consumItm Item to be consumed.
	 * @param game Game object with which game information can be accessed.
	 */
	public void useItem(ConsumableItem consumItm, GameEnviroment game) {
		game.getCurrentCrewMember().consme(consumItm);
		game.getCurrentCrewMember().setActionsLeft(game.getCurrentCrewMember().getActionsLeft() - 1);
		for(ConsumableItem consumItemIter: game.spaceShip.getInventory()) {
			if(consumItemIter == consumItm) {
				//remove and break
				game.spaceShip.inventory.remove(consumItemIter);
				break;
			}
		}
	}
	
	/**
	 * Performs selected action for a character to take. <br>
	 * Sleep: Reduces tiredness <br>
	 * Repair: Restores spaceships shields <br>
	 * Search: Search planet for items and parts <br>
	 * 
	 * @param action
	 * @param game Game object with which game information can be accessed.
	 */
	public String charActions(String action, GameEnviroment game) {
		String retString = "";
		if(game.getCurrentCrewMember().getActionsLeft() > 0) {
			if(action.equals("Sleep")) {
				//numbers need adjustment
				int howTired = game.getCurrentCrewMember().sleep();
				game.getCurrentCrewMember().setActionsLeft(game.getCurrentCrewMember().getActionsLeft() - 1);
				retString += "Crew Member " + game.getCurrentCrewMember().getName() + " has slept and is now " + howTired + " Tired";
			}else if(action.equals("Repair")) {
				//need to implement speacial abilities in crewMember class
				int howFixed = game.spaceShip.repair(game.getCurrentCrewMember());
				game.getCurrentCrewMember().setActionsLeft(game.getCurrentCrewMember().getActionsLeft() - 1);
				retString += "Repaired shields to " + howFixed;
			}else if(action.equals("Search")) {
				if(game.currentPlanet.isVisited() != true) {
					//searches the planet for shit
					retString += game.currentPlanet.search(game.spaceShip);
					game.currentPlanet.setVisited(true);
					game.getCurrentCrewMember().setActionsLeft(game.getCurrentCrewMember().getActionsLeft() - 1);
					if(game.getSpaceShip().isTempPartFound()) {
						game.shipPiecesFound += 1;
						game.getSpaceShip().setTempPartFound(false);
					}
					if(game.shipPiecesFound == game.shipPieces) {
						retString += "You found all the bits!";
						return "won";
					}
				}else {
					retString += "Already Visited";
				}
		}
		}else {
			retString = "No actions left for this crew member";
		}
		return retString;
	//end
	}
	
	//passing crew member names a string, could change to type crew memeber but uuuuuuuuuuuuuuuuuuh ceebs
	
	/**
	 * Allows player to travel to a new planet after selecting <br>
	 * two crew members with available actions.
	 * 
	 * @param crew1 First crew member selected.
	 * @param crew2 Second crew member selected.
	 * @param game Game object with which game information can be accessed.
	 */
	public String pilot(String crew1, String crew2, GameEnviroment game) {
		game.currentPlanet = game.planets.get(ThreadLocalRandom.current().nextInt(0, game.planets.size()));
		game.planets.remove(game.currentPlanet);
		game.getCurrentPlanet().setVisited(false);
		String retStr = "<html>You moved to a new Planet<br/>";
		if(ThreadLocalRandom.current().nextInt(0, 20) > ThreadLocalRandom.current().nextInt(0, 1)) {
			game.spaceShip.setShields(game.spaceShip.getShields() - (40 * (1 - game.spaceShip.getShields()/100)));
			retStr += "Your ship got took some heat in an asteriod belt <br/> Your shields are now at " + game.spaceShip.getShields();
		}
		game.spaceShip.getCrewMember(crew1).setActionsLeft(game.spaceShip.getCrewMember(crew1).getActionsLeft() - 1);
		game.spaceShip.getCrewMember(crew2).setActionsLeft(game.spaceShip.getCrewMember(crew2).getActionsLeft() - 1);
		return retStr + "</html>";
	}

	/**
	 * 
	 * 
	 * @param min
	 */
	public int randomPcChance(int min) {
		//generates a random pc chance
		int range = (100 - min) + 1;
		return (int)(Math.random() * range) + min;
	}
	
	/**
	 * Check if there is a security crew member <br>
	 * on board. If so, reduce chance of a pirate attack.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public int checkSecurity(GameEnviroment game) {
		//for each security we have less likelyhood of a pirate attack
		int retInt = 9;
		for(CrewMember crewMember : game.getSpaceShip().getCrewList()) {
			if(crewMember.getType().equals("Security")) {
				retInt -= 1;
			}
		}
		return retInt;
	}
	
	/**
	 * 
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public String checkRandomEvents(GameEnviroment game) {

		//need to make it less likely for the space plague lmao
		
		String retString = "<html>Overnight, ";
		int chanceRandInt = ThreadLocalRandom.current().nextInt(0, 14);
		if(chanceRandInt < 5) {
			//nothing happens
			retString += "nothing happened";
		}else if(chanceRandInt < checkSecurity(game) && game.spaceShip.getInventory().size() > 0) {
			//spacePirates
			int randItem = ThreadLocalRandom.current().nextInt(0, game.spaceShip.getInventory().size());
			ConsumableItem item = game.spaceShip.removeFromInventory(randItem);
			retString += "Space Pirates attacked you! <br/> They stole a " + item.getName() + " from you ";
		}else if (chanceRandInt == 10){
			//double spaceplague
			int randomCrew = ThreadLocalRandom.current().nextInt(0, crewMemeberCount-1);
			if(game.spaceShip.crewList.get(randomCrew).getType().equals("Medic") == false) {
				game.spaceShip.crewList.get(randomCrew).setHasSpacePlague(true);
				game.spaceShip.crewList.get(randomCrew).setHealthdeg(game.spaceShip.crewList.get(randomCrew).getHealthdeg() + 0.2);
				retString += game.spaceShip.crewList.get(randomCrew).getName() + " contracted space plague <br/> Buy the cure or they will die!!!! ";
			}
			if(game.spaceShip.crewList.get(randomCrew + 1).equals("Medic") == false) {
				game.spaceShip.crewList.get(randomCrew + 1).setHasSpacePlague(true);
				game.spaceShip.crewList.get(randomCrew + 1).setHealthdeg(game.spaceShip.crewList.get(randomCrew + 1).getHealthdeg() + 0.2);
				retString += game.spaceShip.crewList.get(randomCrew + 1).getName() + " contracted space plague <br/> Buy the cure or they will die!!!! ";
			}
		}else if (chanceRandInt < 12) {
			//spacePlaguye
			int randomCrew = ThreadLocalRandom.current().nextInt(0, crewMemeberCount-1);
			if(game.spaceShip.crewList.get(randomCrew).getType().equals("Medic") == false) {
				game.spaceShip.crewList.get(randomCrew).setHasSpacePlague(true);
				game.spaceShip.crewList.get(randomCrew).setHealthdeg(game.spaceShip.crewList.get(randomCrew).getHealthdeg() + 0.2);
				retString += game.spaceShip.crewList.get(randomCrew).getName() + " contracted space plague <br/> Buy the cure or they will die!!!! ";
			}
		}else {
			// all 3
			if(game.spaceShip.getInventory().size() > 0) {
				int randItem = ThreadLocalRandom.current().nextInt(0, game.spaceShip.getInventory().size());
				ConsumableItem item = game.spaceShip.removeFromInventory(randItem);
				retString += "Space Pirates attacked you! <br/> They stole a " + item.getName() + " from you<br/>";
			}
			int randomCrew = ThreadLocalRandom.current().nextInt(0, crewMemeberCount-1);
			game.spaceShip.crewList.get(randomCrew).setHasSpacePlague(true);
			game.spaceShip.crewList.get(randomCrew).setHealthdeg(game.spaceShip.crewList.get(randomCrew).getHealthdeg() + 0.2);
			retString += "<br/>" + game.spaceShip.crewList.get(randomCrew).getName() + " contracted space plague <br/> Buy the cure or they will die!!!! <br/>";
			retString += "You got fucked up my dude";
		}
		return retString;
	}

	/**
	 * Moves game into next day and processes overnight events.
	 * 
	 * @param game Game object with which game information can be accessed.
	 */
	public String nextDay(GameEnviroment game) {
		//moves the game to the next day
		ArrayList<CrewMember> tempDeadList = new ArrayList<>();
		if(this.currentDay < this.gameDays) {
			//check ship death
			String retStr = this.checkRandomEvents(game);
			for(CrewMember crewMember: game.spaceShip.crewList) {
				crewMember.setActionsLeft(2);
				//how are we doing the degrading of health and shit
				crewMember.setTiredness(crewMember.getTiredness() - (int)Math.round(crewMember.getTireddeg() * 30));
				crewMember.setHunger(crewMember.getHunger() - (int)Math.round(crewMember.getHungerdeg() * 30));
				//damage statements
				if(crewMember.getHunger() <= 0) {
					crewMember.setHunger(0);
					crewMember.setHealth(crewMember.getHealth() - (int)Math.round(crewMember.getHealthdeg() * 20));
				}
				if(crewMember.getTiredness() <= 0) {
					crewMember.setTiredness(0);
					crewMember.setHealth(crewMember.getHealth() - (int)Math.round(crewMember.getHealthdeg() * 15));
				}
				if(crewMember.hasSpacePlague) {
					crewMember.setHealth(crewMember.getHealth() - (int)Math.round(crewMember.getHealthdeg() * 25));
				}
				if(crewMember.getHealth() <= 0) {
					//he ded
					retStr += "<br/>The crew member " + crewMember.getName() + " has died :/ ";
					//workaround concurrent modificatoin exception
					tempDeadList.add(crewMember);
				}
			}
			for(CrewMember crewMember : tempDeadList) {
				if(this.getSpaceShip().getCrewList().contains(crewMember)) {
					this.getSpaceShip().getCrewList().remove(crewMember);
				}
			}
			this.currentDay++;
			System.out.println(retStr);
			if(this.getSpaceShip().getShields() <= 0 || this.getSpaceShip().getCrewList().size() <= 0) {
				//ded
				return "end";
			}
			return retStr + "</html>";
		}else {
			//game done
			return "end";
		}
		
	}
	
	/**
	 * Get method for number of days in the game.
	 */
	public int getGameDays() {
		return gameDays;
	}

	/**
	 * Set method for number of days in the game.
	 * 
	 * @param gameDays Number of days entered by player.
	 */
	public void setGameDays(int gameDays) {
		this.gameDays = gameDays;
	}
	
	/**
	 * Get method for current day in the game.
	 */
	public int getCurrentDay() {
		return currentDay;
	}

	/**
	 * Get method for the number of ship pieces to be found.
	 */
	public int getShipPieces() {
		return shipPieces;
	}

	/**
	 * Set method for number of ship parts that will need to <br>
	 * found to win the game.
	 * 
	 * @param shipPieces Ship parts required for the game.
	 */
	public void setShipPieces(int shipPieces) {
		this.shipPieces = shipPieces;
	}

	/**
	 * Get method for number of ship parts found so far.
	 */
	public int getShipPiecesFound() {
		return shipPiecesFound;
	}

	/**
	 * Sets number of ship parts found so far.
	 * 
	 * @param shipPiecesFound Number of ship parts found.
	 */
	public void setShipPiecesFound(int shipPiecesFound) {
		this.shipPiecesFound = shipPiecesFound;
	}

	/**
	 * Get method for number of planets in the game.
	 */
	public int getPlanetCount() {
		return planetCount;
	}

	/**
	 * Set method for number of planets in the game.
	 * 
	 * @param planetCount Number of planets to be in the game.
	 */
	public void setPlanetCount(int planetCount) {
		this.planetCount = planetCount;
	}

	/**
	 * Get method for number of crew members.
	 */
	public int getCrewMemeberCount() {
		return crewMemeberCount;
	}

	/**
	 * Set method for number of crew members.
	 * 
	 * @param crewMemeberCount Number of crew members selected by player.
	 */
	public void setCrewMemeberCount(int crewMemeberCount) {
		this.crewMemeberCount = crewMemeberCount;
		System.out.println(this.crewMemeberCount);
	}

	/**
	 * Checks if all ship parts have been found.
	 */
	public boolean isAllFound() {
		return allFound;
	}

	/**
	 * Set method for whether or not all ship parts have been found.
	 * 
	 * @param allFound True if all parts found, false otherwise.
	 */
	public void setAllFound(boolean allFound) {
		this.allFound = allFound;
	}

	/**
	 * Get method for spaceship object.
	 */
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	/**
	 * Set method for spaceship object.
	 * 
	 * @param spaceShip Spaceship object.
	 */
	public void setSpaceShip(SpaceShip spaceShip) {
		this.spaceShip = spaceShip;
	}

	/**
	 * Get method for planet player is currently at.
	 */
	public Planet getCurrentPlanet() {
		return currentPlanet;
	}

	/**
	 * Set method for planet player is currently at.
	 * 
	 * @param currentPlanet Planet player is at.
	 */
	public void setCurrentPlanet(Planet currentPlanet) {
		this.currentPlanet = currentPlanet;
	}

	/**
	 * Get method for array list of all planets in the game.
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	/**
	 * Set method for planets that are to be in the game.
	 * 
	 * @param planets Planets that are to be visitable in the game.
	 */
	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}

	/**
	 * Get method for current crew member.
	 */
	public CrewMember getCurrentCrewMember() {
		return currentCrewMember;
	}

	/**
	 * Set method for changing the current crew member.
	 * 
	 * @param currentCrewMember Crew member to be set as current.
	 */
	public void setCurrentCrewMember(CrewMember currentCrewMember) {
		this.currentCrewMember = currentCrewMember;
	}

	/**
	 * Get method for shop object.
	 */
	public Shop getShop() {
		return shop;
	}

	/**
	 * Set method for shop object.
	 * 
	 * @param shop Shop object to be set.
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
}

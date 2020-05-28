package supers;

/**
 * Super class defining crew members. <br>
 * A crew member can be one of 6 types, each has their <br>
 * own stats and bonus effects that effect gameplay.
 * 
 * @author Michael Freeman (mjf145)
 * @author Finn McCartney (fwm16)
 */
public class CrewMember {
	//basics
	public String name;
	public String type;
	public int actionsLeft = 2;
	
	//starting stats
	public int health = 100;
	public int hunger = 100;
	public int tiredness = 100;
	
	//degrading rates
	public double healthdeg = 0.5;
	public double hungerdeg = 0.5;
	public double tireddeg = 0.5;
	
	public boolean hasSpacePlague = false;
	
	//abilities
	/**
	 * Creates a new crew member to be added to the game.
	 * 
	 * @param name Name of crew member.
	 * @param type Type of crew member.
	 */
	public CrewMember(String name, String type) {
		this.name = name;
		this.type = type;
		//switch for diffrent types of type
		switch(type) {
		case "Scout":
			//Scout lasts longer (lower degrade and higher tiredness)
			this.tireddeg = 0.2;
			this.tiredness = 120;
			break;
		case "Engineer":
			//Special Atributes here
			//should be better at repairing the ship 
			//implemented in spaceSHip.repair()
			break;
		case "Captain":
			//Special Atributes here
			//boosts energy for all by 20 implemented at init in GameEnviroment
			break;
		case "Medic":
			//Special Atributes here
			//can heal faster?
			this.healthdeg = 0.2;
			//cant get spaceplague (implemented in GameEnviroment.checkRandomEvents()
			break;
		case "Chef":
			//Special Atributes here
			this.hungerdeg = 0.2;
			//start with one extra food item, implemeted in GameEvniroment.init
			break;
		case "Security":
			//Special Atributes here
			//bigger health and
			//reduces chances of pirate attack implemented in gameEnviroment.checkrandomevents & checksecurity
			this.health = 120;
			break;
		default:
			this.type = null;
			break;
		}
	}
	
	/**
	 * Consumes item for a crew member and adjusts their<br>
	 * stats accordingly.
	 * 
	 * @param item Item to be consumed.
	 */
	public void consme(ConsumableItem item) {
		//special abilities?????????
		if(item.getBonusType().equals("hunger")) {
			this.setHunger(this.getHunger() + item.getBonusAmount());
		}else if(item.getBonusType().equals("health")) {
			this.setHealth(this.getHealth() + item.getBonusAmount());
		}else if(item.getBonusType().equals("energy")) {
			this.setTiredness(this.getTiredness() + item.getBonusAmount());
		}else if(item.getBonusType().equals("spaceplaguecure")) {
			this.setHasSpacePlague(false);
			System.out.println("Youve been cured");
		}
	}
	
	/**
	 * Crew member goes to sleep and tirdness is reduced.
	 */
	public int sleep() {
		int addedTired = (int) Math.round(40 * this.tireddeg);
		if(this.tiredness + addedTired <= 100) {
			this.tiredness += addedTired;
		}else {
			this.tiredness = 100;
		}
		return this.tiredness;
	}
	
	/**
	 * Get method for name of crew member.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set method for name of crew member.
	 * 
	 * @param name Name of crew member.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get method for type of crew member.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Set method for type of crew member.
	 * 
	 * @param type Type of crew member.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Get method for health of crew member.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Set method for health of crew member.
	 * 
	 * @param health Health of crew member.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Get method for hunger of crew member.
	 */
	public int getHunger() {
		return hunger;
	}
	
	/**
	 * Set method for hunger of crew member.
	 * 
	 * @param hunger Hunger of crew member.
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	/**
	 * Get method for tiredness of crew member.
	 */
	public int getTiredness() {
		return tiredness;
	}
	
	/**
	 * Set method for tiredness of crew member.
	 * 
	 * @param tiredness Tiredness of crew member.
	 */
	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}
	
	/**
	 * Get method for rate of health degradation.
	 */
	public double getHealthdeg() {
		return healthdeg;
	}
	
	/**
	 * Set method for rate of health degradation
	 * 
	 * @param d Rate of health degradation.
	 */
	public void setHealthdeg(double d) {
		this.healthdeg = d;
	}
	
	/**
	 * Get method for rate of hunger degradation.
	 */
	public double getHungerdeg() {
		return hungerdeg;
	}
	
	/**
	 * Set method for  rate of hunger degradation.
	 * 
	 * @param d Rate of hunger degradation.
	 */
	public void setHungerdeg(double d) {
		this.hungerdeg = d;
	}
	
	/**
	 * Get method for rate of tiredness degradation.
	 */
	public double getTireddeg() {
		return tireddeg;
	}
	
	/**
	 * Set method for rate of tiredness degradation.
	 * 
	 * @param d Rate of tiredness degradation.
	 */
	public void setTireddeg(double d) {
		this.tireddeg = d;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}

	/**
	 * Get method for actions available to crew member.
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}

	/**
	 * Set method for number of actions available to crew member.
	 * 
	 * @param actionsLeft Actions available.
	 */
	public void setActionsLeft(int actionsLeft) {
		this.actionsLeft = actionsLeft;
	}

	/**
	 * Boolean representing if crew member has <br>
	 * space plague or not.
	 */
	public boolean isHasSpacePlague() {
		return hasSpacePlague;
	}

	/**
	 * Returns whether crew member has space plague or not.
	 * 
	 * @param hasSpacePlague Boolean variable that is true if crew member <br>
	 * has space plague, false otherwise.
	 */
	public void setHasSpacePlague(boolean hasSpacePlague) {
		this.hasSpacePlague = hasSpacePlague;
	}

}

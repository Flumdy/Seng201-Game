package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import items.Bandage;
import items.Brownie;
import supers.ConsumableItem;
import supers.CrewMember;
import supers.SpaceShip;

public class SpaceShipTest {
	public static SpaceShip spaceShip;
	public static CrewMember crewMember1;
	public static ArrayList<CrewMember> tempCrewList;
	public static ArrayList<ConsumableItem> consumItemList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		spaceShip = new SpaceShip("name");
		crewMember1 = new CrewMember("name", "Scout");
		tempCrewList = new ArrayList(Arrays.asList(crewMember1));
		consumItemList = spaceShip.getInventory();
		spaceShip.addCrewMember(crewMember1);
	}
	
	@Before
	public void setUp() throws Exception{
		spaceShip.setShields(50);
	}
	
	@After
	public void tearDown() throws Exception{
		spaceShip.setShields(50);
	}
	
	@Test
	public void testGetCrewMember() {
		CrewMember crewMember = spaceShip.getCrewMember("name");
		assertEquals(crewMember, crewMember1);
	}

	@Test
	public void testRepair() {
		spaceShip.repair(crewMember1);
		assertEquals(70, spaceShip.shields);
		CrewMember crewMemberEng = new CrewMember("EngCrewMember", "Engineer");
		spaceShip.addCrewMember(crewMemberEng);
		spaceShip.setShields(50);
		spaceShip.repair(crewMemberEng);
		assertEquals(90, spaceShip.shields);
	}

	@Test
	public void testAddCrewMember() {
		CrewMember crewMemberDavid = new CrewMember("david", "Captain");
		tempCrewList.add(crewMemberDavid);
		spaceShip.addCrewMember(crewMemberDavid);
		assertEquals(spaceShip.crewList, tempCrewList);
	}

	@Test
	public void testAddToInventory() {
		ConsumableItem itemTemp = new ConsumableItem();
		consumItemList.add(itemTemp);
		spaceShip.addToInventory(itemTemp);
		assertEquals(spaceShip.inventory, consumItemList);
	}

	@Test
	public void testRemoveFromInventoryConsumableItem() {
		ConsumableItem itemTemp = new ConsumableItem();
		consumItemList.remove(itemTemp);
		spaceShip.removeFromInventory(itemTemp);
		assertEquals(spaceShip.inventory, consumItemList);
	}

	@Test
	public void testRemoveFromInventoryInt() {
		consumItemList.remove(0);
		spaceShip.removeFromInventory(0);
		assertEquals(spaceShip.inventory, consumItemList);
	}

	@Test
	public void testTakeDamage() {
		spaceShip.takeDamage(10);
		assertEquals(40, spaceShip.shields);
		
	}

	@Test
	public void testRepairShields() {
		spaceShip.repairShields(20);
		assertEquals(70, spaceShip.shields);
	}

}

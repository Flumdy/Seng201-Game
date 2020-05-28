package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import items.Bandage;
import items.Brownie;
import items.Coffee;
import items.SpacePasta;
import supers.CrewMember;

public class CrewMemberTest {

	public static CrewMember crewMember;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		crewMember = new CrewMember("david", "Scout");
	}
	
	@Before
	public void setUp() {
		crewMember.setHunger(10);
		crewMember.setHealth(10);
		crewMember.setTiredness(10);
	}
	
	@Test
	public void testCrewMember() {
		CrewMember crewMember1 = new CrewMember("BASS", "Captain");
		CrewMember crewMember2 = new CrewMember("Treble", "wrong");
		assertNull(crewMember2.type);
		assertEquals(crewMember1.type, "Captain");
		assertEquals(crewMember1.name, "BASS");
		assertEquals(crewMember2.name, "Treble");
	}

	@Test
	public void testConsme() {
		SpacePasta spacePasta = new SpacePasta();
		crewMember.consme(spacePasta);
		assertEquals(crewMember.hunger, spacePasta.getBonusAmount() + 10);
		Bandage bandage = new Bandage();
		crewMember.consme(bandage);
		assertEquals(crewMember.health, bandage.getBonusAmount() + 10);
		Coffee coffee = new Coffee();
		crewMember.consme(coffee);
		assertEquals(crewMember.tiredness, coffee.getBonusAmount() + 10);
	}

	@Test
	public void testSleep() {
		crewMember.sleep();
		assertEquals(crewMember.getTiredness(), (10 + Math.round(40 * crewMember.getTireddeg())));
	}

	@Test
	public void testSetActionsLeft() {
		crewMember.setActionsLeft(1);
		assertEquals(crewMember.getActionsLeft(), 1);
	}

	@Test
	public void testIsHasSpacePlague() {
		crewMember.setHasSpacePlague(true);
		assertEquals(crewMember.isHasSpacePlague(), true);
	}

}

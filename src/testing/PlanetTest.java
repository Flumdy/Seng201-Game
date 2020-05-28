package testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import supers.Planet;
import supers.SpaceShip;

public class PlanetTest {
	
	@Test
	public void testPlanet() {
		Planet planet = new Planet(true, 10, 100, 50);
		assertTrue(planet.foodDropChance < 10);
		assertTrue(planet.healthDropChance < 100);
		assertTrue(planet.moneyDropChance < 50);
	}

	@Test
	public void testSearch() {
		SpaceShip spaceShip = new SpaceShip("SPACESHIP");
		Planet planet = new Planet(false, 10, 10, 10);
		assertEquals(planet.search(spaceShip), "<html></html>");
		planet.setpartPresent(true);
		assertNotNull(planet.search(spaceShip));
	}

	@Test
	public void testIsVisited() {
		Planet planet = new Planet(false, 10, 10, 10);
		assertFalse(planet.isVisited());
	}

	@Test
	public void testIsPartPresent() {
		Planet planet = new Planet(true, 10, 10, 10);
		assertTrue(planet.isPartPresent());
	}

}

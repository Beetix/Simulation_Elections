package tp1.unitTest;


import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tp1.Civilite;
import tp1.HommePolitique;

/**
 * @author francoise.perrin
 *
 */


public class HommePolitiqueTest {

	private HommePolitique h1, h3, h2;


	@Before
	public void init() throws Exception {
		h1 = new HommePolitique(Civilite.FEMME,"nom1","parti1");
		h3 =new HommePolitique(Civilite.HOMME,"nom3","parti3");
	}

	@After
	public void finish() throws Exception {
		h1 = h2 = h3 = null;
	}

	@Test
	public void HommePolitique() {
		assertNotNull("L'instance est créée", h1);
		assertNotNull("L'instance est créée", h3);
	}

	@Test
	public void getCivilite() {
		assertEquals("Est ce que civilite est correct", Civilite.FEMME, h1.getCivilite());
	}

	@Test(expected=IllegalArgumentException.class)
	public void setCivilite() {
		h1.setCivilite(Civilite.HOMME);
		assertEquals("Est ce que civilite est correct", Civilite.HOMME, h1.getCivilite());
		h3.setNom(null);
	}

	@Test
	public void getNom() {
		assertEquals("Est ce que nom est correct", "nom1", h1.getNom());
	}

	@Test(expected=IllegalArgumentException.class)
	public void setNom() {		
		h1.setNom("nom2");
		assertEquals("Est ce que nom est correct", "nom2", h1.getNom());
		h3.setNom(null);
	}

	@Test
	public void getParti() {
		assertEquals("Est ce que parti est correct", "parti1", h1.getParti());
	}

	@Test
	public void setParti() {
		h1.setParti("parti2");
		assertEquals("Est ce que parti est correct", "parti2", h1.getParti());
	}

	@Test
	public void egalegal() {
		assertNotSame("Est ce que h1 == h3", h1, h3);
		h1 = h3;
		assertSame("Est ce que h1 == h3", h1, h3);	
	}
	
	@Test
	public void equals() {	
		h2 = new HommePolitique(Civilite.FEMME,"nom3", "parti3");
		assertFalse("Est ce que h2 not equals h3 ?", h2.equals(h3));
		h2.setCivilite(Civilite.HOMME);
		assertEquals("Est ce que h2 equals h3 ?", h2, h3);
	}
	
	@Test
	public void testclone() {		
		h2 = (HommePolitique) h1.clone();
		assertTrue("Est ce que h2 equals h1 après clone", h2.equals(h1));
		assertNotSame("Est ce que h2 == h1", h2, h1);
	}
	@Test
	public void ToString() {		
		System.out.println("Test toString() " + h1);
		assertEquals("Test toString() ", h1.toString(),"[civilité = FEMME, nom = nom1, parti = parti1]");
	}
	@Test
	public void compareTo() {		
		//System.out.println("Test compareTo() " + h1.compareTo(h3));
		assertTrue("Test compareTo() " , (h1.compareTo(h3)<0));
		assertFalse("Test compareTo() " , (h1.compareTo(h3)>=0));
	}
}

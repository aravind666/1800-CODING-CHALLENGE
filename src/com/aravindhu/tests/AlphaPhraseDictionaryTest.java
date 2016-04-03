/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.tests;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aravindhu.app.entities.AlphaPhraseDictionary;
import com.google.common.collect.Sets;

public class AlphaPhraseDictionaryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSetOfPossiblePhrasesForNumber() {
		String number = "2";
		AlphaPhraseDictionary alphaPhraseDictionary = new AlphaPhraseDictionary();
		Set<String> expectedSetOfPossiblePhrases = Sets.newHashSet("A", "B", "C");
		Set<String> actualSetOfPossiblePhrases = alphaPhraseDictionary.getSetOfPossiblePhrasesForNumber(number);
		System.out.println(actualSetOfPossiblePhrases);
		Assert.assertArrayEquals(expectedSetOfPossiblePhrases.toArray(), actualSetOfPossiblePhrases.toArray());
	}

	@Test
	public void testCheckWhetherDigitHasReplacements() {
		String number = "2";
		AlphaPhraseDictionary alphaPhraseDictionary = new AlphaPhraseDictionary();
		Assert.assertTrue(alphaPhraseDictionary.checkWhetherDigitHasReplacements(number));
	}

	@Test
	public void testCheckIfDigitDoesNotHaveReplacements() {
		String number = "$";
		AlphaPhraseDictionary alphaPhraseDictionary = new AlphaPhraseDictionary();
		Assert.assertFalse(alphaPhraseDictionary.checkWhetherDigitHasReplacements(number));
	}

}

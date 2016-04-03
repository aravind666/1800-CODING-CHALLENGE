/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aravindhu.app.helpers.GenericHelper;

public class GenericHelperTest {

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
	public void testConvertListOfStringstoString() {
		List<String> inputList = Arrays.asList("a", "b", "c");
		String expectedString = "abc";
		String actualString = GenericHelper.convertListOfStringstoString(inputList);
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testReplaceDotWithHyphen() {
		String input = "ab.c";
		String expected = "ab-c";
		String actual = GenericHelper.replaceDotWithHyphen(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testReplaceSpacewithHyphen() {
		String input = "a b c";
		String expected = "a-b-c";
		String actual = GenericHelper.replaceSpacewithHyphen(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testReplaceAllPunctuationFromString() {
		String input = "1,3,$,124";
		String expected = "13124";
		String actual = GenericHelper.removeEveryPunctuation(input);
		Assert.assertEquals(expected, actual);
	}

}

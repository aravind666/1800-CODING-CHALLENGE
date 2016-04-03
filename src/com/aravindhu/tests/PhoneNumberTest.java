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

import com.aravindhu.app.values.PhoneNumber;

public class PhoneNumberTest {

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
	public void testGetListOfNumbersWithin() {
		String number = "26588409";
		PhoneNumber phoneNumber = new PhoneNumber(number);
		List<String> expectedListOfNumbers = Arrays.asList("2", "6", "5", "8", "8", "4", "0", "9");
		List<String> actualListOfNumbers = phoneNumber.getListOfNumbersWithin();
		Assert.assertArrayEquals(expectedListOfNumbers.toArray(), actualListOfNumbers.toArray());
	}

}

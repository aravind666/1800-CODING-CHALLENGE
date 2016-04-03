/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aravindhu.app.entities.PhoneDirectory;
import com.aravindhu.app.values.PhoneNumber;

public class PhoneDirectoryTest {

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
	public void testgetListOfNumbersInDirectory() {
		PhoneDirectory phoneDirectory = new PhoneDirectory();
		List<String> expectedListOfNumbers = Arrays.asList("26588409", "9535572239", "23452366");
		List<PhoneNumber> ListOfNumbers = phoneDirectory.getListOfNumbersInDirectory();
		List<String> actualListOfNumbers = new ArrayList<String>();
		for (Iterator<PhoneNumber> iterator = ListOfNumbers.iterator(); iterator.hasNext();) {
			PhoneNumber phoneNumber = (PhoneNumber) iterator.next();
			actualListOfNumbers.add(phoneNumber.getNumber());
		}
		Assert.assertArrayEquals(expectedListOfNumbers.toArray(), actualListOfNumbers.toArray());
	}

}

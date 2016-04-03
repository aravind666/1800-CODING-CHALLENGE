/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.app.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aravindhu.app.helpers.ConfigHelper;
import com.aravindhu.app.values.PhoneNumber;

import java.lang.String;

public class PhoneDirectory {

	private String directoryPath = ConfigHelper.PHONE_DIRECTORY_PATH;

	public List<PhoneNumber> getListOfNumbersInDirectory() {
		List<PhoneNumber> listOfNumbers = new ArrayList<PhoneNumber>();
		// Construct BufferedReader from FileReader
		try {
			File directoryInput = new File(directoryPath);
			BufferedReader br = new BufferedReader(new FileReader(directoryInput));
			String line = null;
			while ((line = br.readLine()) != null) {
				PhoneNumber number = new PhoneNumber(line);
				listOfNumbers.add(number);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfNumbers;
	}

}

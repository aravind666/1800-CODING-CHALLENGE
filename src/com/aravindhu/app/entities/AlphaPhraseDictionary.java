/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.app.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.aravindhu.app.helpers.ConfigHelper;
import com.google.common.collect.Sets;

public class AlphaPhraseDictionary {

	private String dictionaryPath = ConfigHelper.DICTIONARY_PATH;
	private Properties dictionaryData = new Properties();

	public AlphaPhraseDictionary() {
		setDictionaryData();
	}

	public Set<String> getSetOfPossiblePhrasesForNumber(String number) {
		String phrase = dictionaryData.getProperty(number);
		Set<String> possiblePhrasesForNumber;
		if (phrase == null) {
			possiblePhrasesForNumber = Sets.newHashSet(number);
		} else {
			possiblePhrasesForNumber = Sets.newHashSet(phrase.toUpperCase().split("\\s*,\\s*"));
		}
		return possiblePhrasesForNumber;
	}

	private void setDictionaryData() {
		try {
			File file = new File(dictionaryPath);
			FileInputStream fileInput;
			fileInput = new FileInputStream(file);
			dictionaryData.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkWhetherDigitHasReplacements(String number) {
		String phrase = dictionaryData.getProperty(number);
		if (phrase == null) {
			return false;
		} else {
			return true;
		}
	}

}

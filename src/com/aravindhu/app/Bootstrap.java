/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.aravindhu.app.entities.PhoneDirectory;
import com.aravindhu.app.helpers.PhoneNumberHelper;
import com.aravindhu.app.values.PhoneNumber;

public class Bootstrap {

	public static void main(String[] args) {
		
		PhoneDirectory phoneDirectory = new PhoneDirectory();
		List<PhoneNumber> listOfNumbersInDirectory = phoneDirectory.getListOfNumbersInDirectory();
		List<PhoneNumber> listOfIgnoredNumbers = new ArrayList<PhoneNumber>();
		for (Iterator<PhoneNumber> iterator = listOfNumbersInDirectory.iterator(); iterator.hasNext();) {
			PhoneNumber phoneNumber = (PhoneNumber) iterator.next();
			PhoneNumberHelper.setCanHaveReplacementsFlagForNumber(phoneNumber);
			if (phoneNumber.getCanHaveReplacements()) {
				List<String> listOfPossiblePhrases = PhoneNumberHelper
						.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
				Bootstrap.displayList(listOfPossiblePhrases, phoneNumber.getNumber());
			} else {
				listOfIgnoredNumbers.add(phoneNumber);
			}
		}
		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Completed Processing all phone numbers in the directory");
		System.out.println("-------------------------------------------------------------------");
		
		if(listOfIgnoredNumbers.size() > 0 ) {
			
			System.out.println("Below are the numbers ignored ");
			System.out.println("Reason : - These numbers have consecutive digits which does not have replacements in dictionary");
			System.out.println("-------------------------------------------------------------------");
			for (Iterator<PhoneNumber> iterator = listOfIgnoredNumbers.iterator(); iterator.hasNext();) {
				PhoneNumber phoneNumber = (PhoneNumber) iterator.next();
				System.out.println(phoneNumber.getNumber());
			}
		}
		System.exit(0);
	}

	private static void displayList(List<String> combinations, String number) {
		System.out.println("--------------------------------------");
		System.out.println("Possible Phrases of : " + number);
		System.out.println("--------------------------------------");
		for (Iterator<String> iterator = combinations.iterator(); iterator.hasNext();) {
			String alphaPhrase = (String) iterator.next();
			System.out.println(alphaPhrase);
		}

	}

}

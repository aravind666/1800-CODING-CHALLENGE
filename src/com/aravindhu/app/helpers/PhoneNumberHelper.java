/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.app.helpers;

import java.util.*;

import com.aravindhu.app.entities.AlphaPhraseDictionary;
import com.aravindhu.app.values.PhoneNumber;
import com.google.common.collect.Sets;

public class PhoneNumberHelper {

	public static List<Set<String>> getListOfPossiblePhrasesForEachNumber(PhoneNumber phoneNumber) {
		List<Set<String>> listOfPossiblePhrasesForEachNumber = new ArrayList<Set<String>>();
		List<String> listOfNumbersWithIn = phoneNumber.getListOfNumbersWithin();
		AlphaPhraseDictionary alphaPhraseDictionary = new AlphaPhraseDictionary();

		for (Iterator<String> iterator = listOfNumbersWithIn.iterator(); iterator.hasNext();) {
			String number = (String) iterator.next();
			Set<String> listOfPossibleAlternatesForNumber = alphaPhraseDictionary
					.getSetOfPossiblePhrasesForNumber(number);
			listOfPossiblePhrasesForEachNumber.add(listOfPossibleAlternatesForNumber);
		}

		return listOfPossiblePhrasesForEachNumber;
	}

	public static List<String> getListofPossiblePhrasesForPhoneNumber(PhoneNumber phoneNumber) {
		List<String> listofPossiblePhrasesForNumber = new ArrayList<String>();
		List<Set<String>> listOfPossiblePhrasesForEachNumber = PhoneNumberHelper
				.getListOfPossiblePhrasesForEachNumber(phoneNumber);
		Set<List<String>> combinations = Sets.cartesianProduct(listOfPossiblePhrasesForEachNumber);
		for (Iterator<List<String>> iterator = combinations.iterator(); iterator.hasNext();) {
			List<String> list = (List<String>) iterator.next();
			String alphaPhrase = GenericHelper.convertListOfStringstoString(list);
			String alphaPhraseWithHyphen = GenericHelper
					.replaceDotWithHyphen(GenericHelper.replaceSpacewithHyphen(alphaPhrase));
			listofPossiblePhrasesForNumber.add(alphaPhraseWithHyphen);
		}
		return listofPossiblePhrasesForNumber;
	}

	public static void setCanHaveReplacementsFlagForNumber(PhoneNumber phoneNumber) {
		PhoneNumber numberWithoutPunctuation = new PhoneNumber(GenericHelper.removeEveryPunctuation(phoneNumber.getNumber()));
		List<String> listOfNumbersWithIn = numberWithoutPunctuation.getListOfNumbersWithin();
		AlphaPhraseDictionary alphaPhraseDictionary = new AlphaPhraseDictionary();
		for (int i = 1; i < listOfNumbersWithIn.size(); i++) {
			String currentNumber = listOfNumbersWithIn.get(i);
			String previousNumber = listOfNumbersWithIn.get(i - 1);
			Boolean currentNumberReplacementFlag = alphaPhraseDictionary
					.checkWhetherDigitHasReplacements(currentNumber);
			Boolean previousNumberReplacementFlag = alphaPhraseDictionary
					.checkWhetherDigitHasReplacements(previousNumber);
			if (!currentNumberReplacementFlag && !previousNumberReplacementFlag) {
				phoneNumber.setCanHaveReplacements(false);
			} 
		}

	}

}

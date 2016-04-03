/**
 * Created By Aravind HU <aravind.udayashankara@gmail.com>
 */
package com.aravindhu.app.values;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

	private String phoneNumber;
	private Boolean canHaveReplacements = true;

	public PhoneNumber(String inputPhoneNumber) {
		phoneNumber = inputPhoneNumber;
	}

	public List<String> getListOfNumbersWithin() {
		List<String> phoneNumberList = new ArrayList<String>();
		for (int i = 0; i < phoneNumber.length(); i++) {
			char number = phoneNumber.charAt(i);
			phoneNumberList.add(Character.toString(number));
		}
		return phoneNumberList;
	}

	public String getNumber() {
		return phoneNumber;
	}

	public boolean getCanHaveReplacements() {
		// TODO Auto-generated method stub
		return canHaveReplacements;
	}

	public void setCanHaveReplacements(Boolean value) {
		canHaveReplacements = value;
	}

}

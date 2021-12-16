package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public boolean hasSpecialCharacter(String re, String str) {
		Pattern sPattern = Pattern.compile(re);
		Matcher sMatcher = sPattern.matcher(str);
		if(!sMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	public boolean permittedLength(String str, int length) {
		if(str.length() > length) {
			return false;
		}
		return true;
	}
	
	public boolean lengthValidated(String username, String password, int length) {
		if(permittedLength(username, length) && permittedLength(password, length)) {
			return true;
		}
			
		return false;
	}
	
	private boolean hasWhiteSpace(String str) {
		for (Character c: str.toCharArray()) {
			if (Character.isWhitespace(c)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean whitespaceValidated(String user, String password, String email) {
		if (!hasWhiteSpace(user) && !hasWhiteSpace(password) && !hasWhiteSpace(email)) {
			return true;
		}
		return false;
	}
	
	public boolean emailContainsDomans(String re, String email) {
		Pattern sPattern = Pattern.compile(re);
		Matcher sMatcher = sPattern.matcher(email);
		return sMatcher.matches();
	}
}

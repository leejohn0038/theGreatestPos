package project.actions.receipts_actions;

import java.util.regex.Pattern;

public class FieldRegexLimit {

	public static boolean isValid(String regex, String text) {
		boolean state = Pattern.matches(regex, text) ? true : false;
		return state;
	}
}

package project.actions.receipts_actions;

public class Regex {
	
	private static final String[] REGEX = 
		{
		"\\d{1,4}",
		"\\d{3}\\-\\d{4}\\-\\d{4}", 
		"\\d{1,9}", 
		"\\d{4}/\\d{2}/\\d{2}",
		"\\d{4}-\\d{4}-\\d{4}-\\d{4}"};
	
	public static String[] getRegex() {
		return REGEX;
	}
}

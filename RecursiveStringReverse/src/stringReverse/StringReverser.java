package stringReverse;

public class StringReverser {

	public String reverse(String string) {
		int length = string.length();
		if (length < 2){
			return string;
		}
		
		String firstCharacter = "" + string.charAt(0);
		String lastCharacter = "" + string.charAt(length - 1);
		String middleCharacters = string.substring(1, length - 1);
		return lastCharacter + reverse(middleCharacters) + firstCharacter;
	}

}

package stringReverse;

public class StringReverseMain {

	public static void main(String[] args) {
		
		String originalString = "sdrawkcaB";
		
		String reversedString = new StringReverser().reverse(originalString);
		System.out.println("'" + originalString + "' reverseds is: '" + reversedString + "'");
		
	}

}

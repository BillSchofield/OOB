package quantity;

import static quantity.Units.Gallon;
import static quantity.Units.Quart;

public class QuantityMain {

	public static void main(String[] args) {
		reportEqualityOfAmounts(new Quantity(1f, Gallon), new Quantity(1f, Quart));
		reportEqualityOfAmounts(new Quantity(1f, Gallon), new Quantity(4f, Quart));
	}

	private static void reportEqualityOfAmounts(Quantity quantity1,
			Quantity quantity2) {
		System.out.println(
				quantity1.toString() +
				(quantity1.equals(quantity2) ? " is" : " is not" ) + " equal to "+  
				quantity2.toString()
				);
	}

}

package quantity;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QuantityTests {

	@Test
	public void oneQuartShouldEqualOneQuart() {
		Quantity quantity1 = new Quantity(1f, Units.Quart);
		Quantity quantity2 = new Quantity(1f, Units.Quart);

		assertThat(quantity1, is(quantity2));
	}
	
	@Test
	public void oneQuartShouldNotEqualOneGallon(){
		Quantity quantity1 = new Quantity(1f, Units.Quart);
		Quantity quantity2 = new Quantity(1f, Units.Gallon);

		assertThat(quantity1, is(not(quantity2)));
	}
	
	@Test
	public void oneQuartShouldNotEqualTwoQuarts(){
		Quantity quantity1 = new Quantity(1f, Units.Quart);
		Quantity quantity2 = new Quantity(2f, Units.Quart);

		assertThat(quantity1, is(not(quantity2)));
	}
	
	@Test
	public void fourQuartsShouldEqualOneGallon(){
		Quantity quantity1 = new Quantity(4f, Units.Quart);
		Quantity quantity2 = new Quantity(1f, Units.Gallon);

		assertThat(quantity1, is(quantity2));
	}
	
	@Test
	public void OneGallonShouldEqualFourQuarts(){
		Quantity quantity1 = new Quantity(1f, Units.Gallon);
		Quantity quantity2 = new Quantity(4f, Units.Quart);

		assertThat(quantity1, is(quantity2));
	}
	
	
}

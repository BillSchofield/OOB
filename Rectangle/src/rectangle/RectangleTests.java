package rectangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RectangleTests {

	@Test
	public void areaShouldBeLengthTimesWidthFor5And7(){
		float width = 5;
		float length = 7;
		Rectangle rectangle = new Rectangle(width, length);
		
		assertThat(rectangle.area(), is(length * width));
	}

	@Test
	public void areaShouldBeLengthTimesWidthFor3And5(){
		float width = 3;
		float length = 5;
		Rectangle rectangle = new Rectangle(width, length);
		
		assertThat(rectangle.area(), is(length * width));
	}

	@Test
	public void circumferenceShouldBeTwiceLengthPlusTwiceWidthFor5And7(){
		float width = 5;
		float length = 7;
		Rectangle rectangle = new Rectangle(width, length);
		
		assertThat(rectangle.circumference(), is(length * 2 + width * 2));
	}

	@Test
	public void circumferenceShouldBeTwiceLengthPlusTwiceWidthFor3And5(){
		float width = 3;
		float length = 5;
		Rectangle rectangle = new Rectangle(width, length);
		
		assertThat(rectangle.circumference(), is(length * 2 + width * 2));
	}

}

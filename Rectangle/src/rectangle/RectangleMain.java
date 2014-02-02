package rectangle;

public class RectangleMain {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(10.0f, 20.0f);
		
		System.out.println("The area of the rectangle is: " + rectangle.area());
		System.out.println("The circumference of the rectangle is: " + rectangle.circumference());
	}

}

package rectangle;


public class Rectangle {

	private float width;
	private float length;

	public Rectangle(float width, float length) {
		this.width = width;
		this.length = length;
	}

	public float area() {
		return width * length;
	}

	public float circumference() {
		return width * 2 + length * 2;
	}

}

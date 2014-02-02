package chance;

public class Probability {

	private final float probability;

	public Probability(float probability) {
		this.probability = probability;
	}

	public Probability and(Probability that) {
		return new Probability(this.probability * that.probability);
	}

	public float probability(){
		return probability;
	}

	public int hashCode() {
		final int prime = 31;
		return prime + Float.floatToIntBits(probability);
	}

	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Probability other = (Probability) obj;
		return equals(other);
	}

	public boolean equals(Probability that) {
		return this.probability == that.probability;
	}

	public Probability or(Probability that) {
		return new Probability(this.probability + that.probability);
	}

	public static Probability not(Probability that) {
		return new Probability(1.0f - that.probability);
	}
	
}

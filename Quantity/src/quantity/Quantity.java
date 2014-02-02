package quantity;


public class Quantity {

	private final Float amount;
	private final Units units;
	private UnitConverter unitConverter = new UnitConverter();

	public Quantity(Float amount, Units units) {
		this.amount = amount;
		this.units = units;
	}

	public String toString(){
		return amount + " " + units.toString();
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		return result;
	}

	public boolean equals(Object that) {
		return this.equals((Quantity)that);
	}

	public boolean equals(Quantity that){
		if (this.units.equals(that.units)){
			return this.amount.equals(that.amount);
		}
		return this.equals(unitConverter.convert(that.amount, that.units, this.units));
	}
}

package quantity;

import java.util.HashMap;
import java.util.Map;


public class UnitConverter {
	private static final Quantity INVALID_QUANTITY = new Quantity(0f, Units.Invalid);
	
	private Map<UnitsPair, Float> conversionRates = new HashMap<UnitsPair, Float>();
	
	public UnitConverter(){
		addConversion(Units.Quart, Units.Gallon, 0.25f);
	}

	private void addConversion(Units sourceUnits, Units destinationUnits, float conversionRate) {
		conversionRates.put(new UnitsPair(sourceUnits, destinationUnits), conversionRate);
		conversionRates.put(new UnitsPair(destinationUnits, sourceUnits), 1f/conversionRate);
	}
	
	public class UnitsPair{
		private final Units fromUnits;
		private final Units toUnits;

		public UnitsPair(Units fromUnits, Units toUnits){
			this.fromUnits = fromUnits;
			this.toUnits = toUnits;
		}

		public int hashCode() {
			final int prime = 31;
			int result = prime + ((fromUnits == null) ? 0 : fromUnits.hashCode());
			return prime * result + ((toUnits == null) ? 0 : toUnits.hashCode());
		}

		public boolean equals(Object that) {
			if (this == that) {
				return true;
			}
			if (that == null) {
				return false;
			}
			if (getClass() != that.getClass()) {
				return false;
			}
			UnitsPair other = (UnitsPair) that;
			return fromUnits == other.fromUnits && toUnits == other.toUnits;
		}
	}

	public Quantity convert(Float sourceAmount, Units sourceUnits, Units newUnits) {
		UnitsPair unitsPair = new UnitsPair(sourceUnits, newUnits);
		
		if (conversionRates.containsKey(unitsPair)){
			return new Quantity(sourceAmount * conversionRates.get(unitsPair), newUnits);
		}
		return INVALID_QUANTITY;
	}
}

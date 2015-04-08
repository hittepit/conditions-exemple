package conditions.simple;

import entity.Prestation;

public class HeuresNuitCondition extends SimplePrestationCondition {

	@Override
	public boolean check(Prestation prestation) {
		return prestation.getHeuresNuit() != 0;
	}

}

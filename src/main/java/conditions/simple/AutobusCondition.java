package conditions.simple;

import entity.Prestation;

public class AutobusCondition extends SimplePrestationCondition {

	@Override
	public boolean check(Prestation prestation) {
		return prestation.isAutobus();
	}

}

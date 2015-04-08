package toImplement.condition.simple;

import existing.entity.Prestation;

public class AutobusCondition extends SimplePrestationCondition {

	@Override
	public boolean check(Prestation prestation) {
		return prestation.isAutobus();
	}

}

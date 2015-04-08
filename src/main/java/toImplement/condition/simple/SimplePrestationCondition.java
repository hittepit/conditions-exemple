package toImplement.condition.simple;

import toImplement.condition.PrestationCondition;
import toImplement.mapper.PrestationMapper;

public abstract class SimplePrestationCondition implements PrestationCondition {

	@Override
	public final PrestationMapper getMapper() {
		throw new UnsupportedOperationException();
	}

	@Override
	public PrestationCondition setMapper(PrestationMapper mapper) {
		throw new UnsupportedOperationException();
	}
}

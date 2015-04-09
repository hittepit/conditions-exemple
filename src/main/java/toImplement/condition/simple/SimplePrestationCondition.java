package toImplement.condition.simple;

import existing.mapper.PrestationMapper;
import toImplement.condition.PrestationCondition;

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

package conditions.simple;

import conditions.PrestationCondition;
import mapper.PrestationMapper;

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

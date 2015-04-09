package toImplement.condition.combinaison;

import existing.mapper.PrestationMapper;
import toImplement.condition.PrestationCondition;

public abstract class PrestationConditionCombinaison implements PrestationCondition {
	private PrestationCondition[] conditions;
	
	private PrestationMapper mapper;

	public PrestationConditionCombinaison(PrestationCondition... conditions) {
		this.conditions = conditions;
	}
	
	@Override
	public PrestationCondition setMapper(PrestationMapper mapper) {
		this.mapper = mapper;
		return this;
	}
	
	@Override
	public PrestationMapper getMapper() {
		return mapper;
	}

	public PrestationCondition[] getConditions() {
		return conditions;
	}
}

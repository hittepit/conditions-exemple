package toImplement.condition;

import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

public interface PrestationCondition {
	boolean check(Prestation prestation);
	PrestationMapper getMapper();
	PrestationCondition setMapper(PrestationMapper mapper);
}

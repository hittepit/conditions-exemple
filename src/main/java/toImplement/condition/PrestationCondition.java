package toImplement.condition;

import toImplement.mapper.PrestationMapper;
import existing.entity.Prestation;

public interface PrestationCondition {
	boolean check(Prestation prestation);
	PrestationMapper getMapper();
	PrestationCondition setMapper(PrestationMapper mapper);
}

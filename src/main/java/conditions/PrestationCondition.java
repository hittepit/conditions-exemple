package conditions;

import entity.Prestation;
import mapper.PrestationMapper;

public interface PrestationCondition {
	boolean check(Prestation prestation);
	PrestationMapper getMapper();
	PrestationCondition setMapper(PrestationMapper mapper);
}

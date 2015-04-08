package toImplement.condition.combinaison;

import toImplement.condition.PrestationCondition;
import existing.entity.Prestation;

public class OrPrestationConditionCombinaison extends
		PrestationConditionCombinaison {

	public OrPrestationConditionCombinaison(PrestationCondition... conditions) {
		super(conditions);
	}
	
	@Override
	public boolean check(Prestation prestation) {
		for(PrestationCondition c: getConditions()){
			if(c.check(prestation)){
				return true;
			}
		}
		return false;
	}

}

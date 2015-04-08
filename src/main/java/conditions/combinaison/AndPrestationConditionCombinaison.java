package conditions.combinaison;

import conditions.PrestationCondition;
import entity.Prestation;

public class AndPrestationConditionCombinaison extends PrestationConditionCombinaison {
	public AndPrestationConditionCombinaison(PrestationCondition... conditions) {
		super(conditions);
	}
	
	@Override
	public boolean check(Prestation prestation) {
		for(PrestationCondition c:getConditions()){
			if(! c.check(prestation))
				return false;
		}
		return true;
	}

}

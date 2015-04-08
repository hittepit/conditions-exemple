package toImplement.condition.combinaison;

import toImplement.condition.PrestationCondition;
import existing.entity.Prestation;

public class NotPrestationConditionCombinaison extends
		PrestationConditionCombinaison {

	public NotPrestationConditionCombinaison(PrestationCondition condition) {
		super(new PrestationCondition[]{condition});
	}
	
	@Override
	public boolean check(Prestation prestation) {
		return ! getConditions()[0].check(prestation);
	}

}

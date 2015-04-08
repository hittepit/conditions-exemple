package conditions;

import conditions.combinaison.AndPrestationConditionCombinaison;
import conditions.combinaison.NotPrestationConditionCombinaison;
import conditions.combinaison.OrPrestationConditionCombinaison;

public class Combinaisons {
	private Combinaisons() {}
	
	public static PrestationCondition not(PrestationCondition condition){
		return new NotPrestationConditionCombinaison(condition);
	}
	public static PrestationCondition and(PrestationCondition... conditions){
		return new AndPrestationConditionCombinaison(conditions);
	}
	public static PrestationCondition or(PrestationCondition... conditions){
		return new OrPrestationConditionCombinaison(conditions);
	}
}

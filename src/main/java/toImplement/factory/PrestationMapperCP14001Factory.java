package toImplement.factory;

import java.util.ArrayList;
import java.util.List;

import static toImplement.condition.Combinaisons.*;
import toImplement.condition.PrestationCondition;
import toImplement.condition.simple.AutobusCondition;
import toImplement.condition.simple.HeuresNuitCondition;
import toImplement.mapper.AutobusNuitMapper;
import toImplement.mapper.PrestationMapper;
import toImplement.mapper.PrestationNuitOuBusMapper;
import existing.entity.Prestation;


public class PrestationMapperCP14001Factory extends PrestationMapperFactory{
	private List<PrestationCondition> conditions;
	
//	@PostConstruct
	public void init(){
		conditions = new ArrayList<PrestationCondition>();
		conditions.add(
				or(
						and(new AutobusCondition(), not(new HeuresNuitCondition())),
						and(not(new AutobusCondition()), new HeuresNuitCondition())
				).setMapper(new PrestationNuitOuBusMapper())
		);
		conditions.add(
				and(new AutobusCondition(), new HeuresNuitCondition()).setMapper(new AutobusNuitMapper())
		);
	}
	
	public List<PrestationMapper> getMapper(Prestation prestation){
		List<PrestationMapper> mappers = new ArrayList<PrestationMapper>();
		for(PrestationCondition condition:conditions){
			if(condition.check(prestation)){
				mappers.add(condition.getMapper());
			}
		}
		return mappers;
	}
}

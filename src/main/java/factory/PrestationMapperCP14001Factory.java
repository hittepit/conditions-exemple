package factory;

import java.util.ArrayList;
import java.util.List;

import mapper.AutobusNuitMapper;
import mapper.PrestationMapper;
import mapper.PrestationNuitOuBusMapper;
import conditions.PrestationCondition;
import conditions.simple.AutobusCondition;
import conditions.simple.HeuresNuitCondition;
import entity.Prestation;
import static conditions.Combinaisons.*;


public class PrestationMapperCP14001Factory {
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

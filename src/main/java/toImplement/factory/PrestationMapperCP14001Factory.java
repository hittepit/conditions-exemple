package toImplement.factory;

import static toImplement.condition.Combinaisons.and;
import static toImplement.condition.Combinaisons.not;
import static toImplement.condition.Combinaisons.or;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import toImplement.condition.PrestationCondition;
import toImplement.condition.simple.AutobusCondition;
import toImplement.condition.simple.HeuresNuitCondition;
import toImplement.mapper.AutobusNuitMapper;
import toImplement.mapper.PrestationNuitOuBusMapper;
import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

@Component
public class PrestationMapperCP14001Factory implements PrestationMapperFactory{
	private List<PrestationCondition> conditions;
	
	@PostConstruct
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

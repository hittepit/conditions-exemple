package toimplement.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import existing.entity.Prestation;
import existing.mapper.PrestationMapper;
import toImplement.factory.PrestationMapperCP14001Factory;
import toImplement.mapper.PrestationNuitOuBusMapper;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestPrestationMapperCP14001Factory extends AbstractTestNGSpringContextTests{
	@Autowired
	private PrestationMapperCP14001Factory factory;
	
	@Test(description="mapperFactory must return the correct mapper with autobus and no night prestation")
	public void autobusNoNight(){
		Prestation prestation = new Prestation();
		prestation.setAutobus(true);
		prestation.setHeuresNuit(0.0);
		
		List<PrestationMapper> mappers = factory.getMapper(prestation);
		
		assertThat(mappers).hasSize(1);
		
		assertThat(mappers.get(0)).isInstanceOf(PrestationNuitOuBusMapper.class);
	}
	
	@Test(description="mapperFactory must return the correct mapper with no autobus and night prestation")
	public void noAutobusoNight(){
		Prestation prestation = new Prestation();
		prestation.setAutobus(false);
		prestation.setHeuresNuit(4.0);
		
		List<PrestationMapper> mappers = factory.getMapper(prestation);
		
		assertThat(mappers).hasSize(1);
		
		assertThat(mappers.get(0)).isInstanceOf(PrestationNuitOuBusMapper.class);
	}
}

package toimplement.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import toImplement.factory.PrestationMapperFactory;
import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestStandardPrestationMapper extends AbstractTestNGSpringContextTests{
	
	@Test(description="the factory must return a unique PrestationMapper")
	public void factoryReturnsPrestationMapper(){
		Prestation prestation = new Prestation();
		PrestationMapper expectedMapper = (PrestationMapper) applicationContext.getBean("prestationMapper");
		PrestationMapperFactory factory = (PrestationMapperFactory) applicationContext.getBean("standardPrestationMapperFactory");

		List<PrestationMapper> mappers = factory.getMapper(prestation);
		
		assertThat(mappers).hasSize(1);
		assertThat(mappers.get(0)).isSameAs(expectedMapper);
	}
}

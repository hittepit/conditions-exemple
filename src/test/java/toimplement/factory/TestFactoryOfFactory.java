package toimplement.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import toImplement.factory.PrestationMapperCP14001Factory;
import toImplement.factory.PrestationMapperCP14003Factory;
import toImplement.factory.PrestationMapperFactory;
import toImplement.factory.PrestationMapperFactoryFactory;
import toImplement.factory.StandardPrestationMapperFactory;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestFactoryOfFactory extends AbstractTestNGSpringContextTests{

	@Autowired
	private PrestationMapperFactoryFactory prestationMapperFactoryFactory;
	
	@Test(description="factory must return the correct factory when called with cp 140.01")
	public void correctFactoryWithCP14001(){
		PrestationMapperFactory factory = prestationMapperFactoryFactory.getFactory("140.01");
		assertThat(factory).isInstanceOf(PrestationMapperCP14001Factory.class);
	}
	
	@Test(description="factory must return the correct factory when called with cp 140.03")
	public void correctFactoryWithCP14003(){
		PrestationMapperFactory factory = prestationMapperFactoryFactory.getFactory("140.03");
		assertThat(factory).isInstanceOf(PrestationMapperCP14003Factory.class);
	}
	
	@Test(description="factory must return the standard factory when called with a cp different of 140.01 or 140.03")
	public void baseFactoryWithOtherCP(){
		PrestationMapperFactory factory = prestationMapperFactoryFactory.getFactory("170.00");
		assertThat(factory).isInstanceOf(StandardPrestationMapperFactory.class);
	}
	
}

package toImplement.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PrestationMapperFactoryFactory {
	@Autowired
	private ApplicationContext applicationContext;
	
	public PrestationMapperFactory getFactory(String cp){
		if("140.01".equals(cp)){
			return (PrestationMapperFactory) applicationContext.getBean("prestationMapperCP14001Factory");
		} else if("140.03".equals(cp)){
			return (PrestationMapperFactory) applicationContext.getBean("prestationMapperCP14003Factory");
		} else {
			return (PrestationMapperFactory) applicationContext.getBean("standardPrestationMapperFactory");
		}
	}
}

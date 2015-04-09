package toImplement.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

@Component
public class PrestationMapperCP14003Factory implements PrestationMapperFactory {

	@Override
	public List<PrestationMapper> getMapper(Prestation prestation) {
		// TODO Auto-generated method stub
		return null;
	}

}

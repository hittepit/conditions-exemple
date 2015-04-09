package toImplement.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

@Component("standardPrestationMapperFactory")
public class StandardPrestationMapperFactory implements PrestationMapperFactory{
	@Autowired
	private PrestationMapper prestationMapper;
	
	@Override
	public List<PrestationMapper> getMapper(Prestation prestation) {
		List<PrestationMapper> mappers = new ArrayList<PrestationMapper>();
		mappers.add(prestationMapper);
		return mappers;
	}
}

package factory;

import java.util.ArrayList;
import java.util.List;

import mapper.PrestationMapper;
import entity.Prestation;

public class StandardPrestationMapperFactory extends PrestationMapperFactory{
	@Override
	public List<PrestationMapper> getMapper(Prestation prestation) {
		List<PrestationMapper> mappers = new ArrayList<PrestationMapper>();
		mappers.add(new PrestationMapper());
		return mappers;
	}
}

package factory;

import java.util.List;

import mapper.PrestationMapper;
import entity.Prestation;

public abstract class PrestationMapperFactory {
	public abstract List<PrestationMapper> getMapper(Prestation prestation);
}

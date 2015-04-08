package toImplement.factory;

import java.util.List;

import toImplement.mapper.PrestationMapper;
import existing.entity.Prestation;

public abstract class PrestationMapperFactory {
	public abstract List<PrestationMapper> getMapper(Prestation prestation);
}

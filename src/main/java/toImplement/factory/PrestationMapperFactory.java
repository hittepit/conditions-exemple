package toImplement.factory;

import java.util.List;

import org.springframework.stereotype.Component;

import existing.entity.Prestation;
import existing.mapper.PrestationMapper;

public interface PrestationMapperFactory {
	List<PrestationMapper> getMapper(Prestation prestation);
}

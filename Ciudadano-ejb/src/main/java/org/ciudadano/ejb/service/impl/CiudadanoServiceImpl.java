
package org.ciudadano.ejb.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.ciudadano.dto.CiudadanoDto;
import org.ciudadano.ejb.facade.CiudadanoFacade;
import org.ciudadano.ejb.service.CiudadanoService;
import org.ciudadano.exception.NotFoundValueException;;
import org.ciudadano.model.Ciudadano;
import org.ciudadano.util.CiudadanoCopy;

@Stateless
public class CiudadanoServiceImpl implements CiudadanoService {

    @EJB
    private CiudadanoFacade ciudadanoFacadeImpl;
    private Ciudadano ciudadano = null;
    
    @Override
    public CiudadanoDto create(CiudadanoDto entity) {
        ciudadano = CiudadanoCopy.toCiudadano(entity);
        ciudadano = ciudadanoFacadeImpl.create(ciudadano);
        return CiudadanoCopy.toCiudadanoDto(ciudadano);
    }

    @Override
    public CiudadanoDto find(Integer key) {
        ciudadano = ciudadanoFacadeImpl.find(key);
        if(ciudadano == null)
            throw new NotFoundValueException();
        
        return CiudadanoCopy.toCiudadanoDto(ciudadano);
    }

    @Override
    public List<CiudadanoDto> findAll() {
        List<Ciudadano> ciudadanos = ciudadanoFacadeImpl.findAll();
        if(ciudadanos.isEmpty())
            throw new NotFoundValueException();
        
        List<CiudadanoDto> ciudadanosDto = new ArrayList<>();
        for (Ciudadano ciudadano : ciudadanos) {
            ciudadanosDto.add(CiudadanoCopy.toCiudadanoDto(ciudadano));
        }
        
        return ciudadanosDto;
    }

    @Override
    public CiudadanoDto update(CiudadanoDto entity) {
        ciudadano = CiudadanoCopy.toCiudadano(entity);
        ciudadano = ciudadanoFacadeImpl.update(ciudadano);
        return CiudadanoCopy.toCiudadanoDto(ciudadano);
    }

    @Override
    public void remove(CiudadanoDto entity) {
        ciudadano = CiudadanoCopy.toCiudadano(entity);
        ciudadanoFacadeImpl.remove(ciudadano);
    }

}

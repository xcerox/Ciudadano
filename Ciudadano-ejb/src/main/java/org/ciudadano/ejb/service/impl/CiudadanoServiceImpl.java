
package org.ciudadano.ejb.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;
import org.ciudadano.dto.CiudadanoDto;
import org.ciudadano.ejb.facade.CiudadanoFacade;
import org.ciudadano.ejb.service.CiudadanoService;
import org.ciudadano.helper.MapperHelper;
import org.ciudadano.model.Ciudadano;

@Stateless
public class CiudadanoServiceImpl implements CiudadanoService {

    @EJB
    private CiudadanoFacade ciudadanoFacadeImpl;

    @Override
    public CiudadanoDto create(CiudadanoDto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CiudadanoDto find(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CiudadanoDto> findAll() {
        List<Ciudadano> ciudadanos = ciudadanoFacadeImpl.findAll();
        if(ciudadanos.size() == 0)
            throw new NotFoundException();
        
        List<CiudadanoDto> ciudadanosDto = new ArrayList<>();
        for (Ciudadano ciudadano : ciudadanos) {
            CiudadanoDto ciudadanoDto = new CiudadanoDto();
            MapperHelper.copy(ciudadano, ciudadanoDto);
            ciudadanosDto.add(ciudadanoDto);
        }
        
        return ciudadanosDto;
    }

    @Override
    public CiudadanoDto update(CiudadanoDto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(CiudadanoDto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


package org.ciudadano.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;
import org.ciudadano.dto.CiudadanoDto;
import org.ciudadano.ejb.service.CiudadanoService;
import org.ciudadano.exception.NotFoundValueException;
import org.ciudadano.exception.NotValidException;
import org.ciudadano.util.CiudadanoValidUtil;

@WebService(serviceName = "Ciudadano")
@Stateless()
public class Ciudadano {
    @EJB
    private CiudadanoService ciudadanoService;

    @WebMethod(operationName = "create")
    public CiudadanoDto create(@WebParam(name = "Ciudadano") CiudadanoDto ciudadanoDto) throws NotValidException{
        try{
            if (CiudadanoValidUtil.isValid(ciudadanoDto)) 
                return ciudadanoService.create(ciudadanoDto);
            else 
                 throw new NotValidException();
        }catch(Exception error){
            throw  new NotValidException(error.getMessage());
        } 
    }
    
    @WebMethod(operationName = "update")
    public CiudadanoDto update(@WebParam(name = "Ciudadano") CiudadanoDto ciudadanoDto) throws NotValidException{
        try{
            if (CiudadanoValidUtil.isValid(ciudadanoDto)) 
                return ciudadanoService.update(ciudadanoDto);
            else 
                 throw new NotValidException();
        }catch(Exception error){
            throw  new NotValidException(error.getMessage());
        } 
    }
    
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "id") int id) throws NotFoundValueException, NotValidException{
        CiudadanoDto ciudadanoDto = findById(id);
        ciudadanoService.remove(ciudadanoDto);
        return true;
    }
    
    
    @WebMethod(operationName = "findAll")
    public List<CiudadanoDto> findAll() throws NotFoundValueException{
        List<CiudadanoDto> ciudadanos = ciudadanoService.findAll();
        if(ciudadanos.size() > 0)
            return ciudadanos;
        else
            throw new NotFoundValueException();
    }
    
    @WebMethod(operationName = "findById")
    public CiudadanoDto findById(@WebParam(name = "id") int id) throws NotFoundValueException, NotValidException{
        if(CiudadanoValidUtil.isValidId(id)){
            try{
                CiudadanoDto ciudadanos = ciudadanoService.find(id);
                return ciudadanos;
            }catch(Exception error){
                throw new NotFoundValueException(error.getMessage());
            }
        }else
            throw new NotValidException();

    }
    
}

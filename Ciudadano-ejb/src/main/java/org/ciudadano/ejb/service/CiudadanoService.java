
package org.ciudadano.ejb.service;

import javax.ejb.Local;
import org.ciudadano.dto.CiudadanoDto;

@Local
public interface CiudadanoService extends Service<CiudadanoDto, Integer>{
    
}


package org.ciudadano.facade;

import javax.ejb.Local;
import org.ciudadano.model.Ciudadano;

@Local
public interface CiudadanoFacade extends Facade<Ciudadano, Integer>{
}

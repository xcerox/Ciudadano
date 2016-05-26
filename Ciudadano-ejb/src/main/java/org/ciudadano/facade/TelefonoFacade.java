
package org.ciudadano.facade;

import javax.ejb.Local;
import org.ciudadano.model.Telefono;

@Local
public interface TelefonoFacade extends Facade<Telefono, Integer>{
}

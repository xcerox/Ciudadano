
package org.ciudadano.facade.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ciudadano.facade.AbstractFacade;
import org.ciudadano.facade.TelefonoFacade;
import org.ciudadano.model.Telefono;

public class TelefonoFacadeImpl extends AbstractFacade<Telefono, Integer> implements TelefonoFacade{

    @PersistenceContext(unitName = "mysql")
    private EntityManager manager;

    public TelefonoFacadeImpl() {
        super(Telefono.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }
    
}

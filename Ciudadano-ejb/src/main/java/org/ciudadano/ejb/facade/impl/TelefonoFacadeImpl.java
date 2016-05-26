
package org.ciudadano.ejb.facade.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ciudadano.ejb.facade.AbstractFacade;
import org.ciudadano.ejb.facade.TelefonoFacade;
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

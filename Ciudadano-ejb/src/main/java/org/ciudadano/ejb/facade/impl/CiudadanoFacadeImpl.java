/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ciudadano.ejb.facade.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ciudadano.ejb.facade.AbstractFacade;
import org.ciudadano.ejb.facade.CiudadanoFacade;
import org.ciudadano.model.Ciudadano;

/**
 *
 * @author j.reyes
 */
@Stateless
public class CiudadanoFacadeImpl extends AbstractFacade<Ciudadano,Integer> implements CiudadanoFacade {

    @PersistenceContext(unitName = "mysql")
    private EntityManager manager;

    @Override
    protected EntityManager getEntityManager() {
        return manager;
    }

    public CiudadanoFacadeImpl() {
        super(Ciudadano.class);
    }    
}

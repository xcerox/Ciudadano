
package org.ciudadano.ejb.facade;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractFacade<T,K> {

    private Class<T> entityClass;
    protected abstract EntityManager getEntityManager();
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public T create(T entity) {
        getEntityManager().persist(entity);
        getEntityManager().flush();
        return entity;
    }

    public T update(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
        return entity;
    }

    public void remove(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
    }

    public T find(K id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}

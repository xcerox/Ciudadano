
package org.ciudadano.ejb.service;

import java.util.List;

public interface Service  <E,K> {
    E create(E entity);
    E find(K key);
    List<E> findAll();
    E update (E entity);
    void remove(E entity);
}
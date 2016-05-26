
package org.ciudadano.facade;

import java.util.List;

public interface Facade <E,K> {
    E create(E entity);
    E find(K key);
    List<E> findAll();
    E update (E entity);
    void remove(E entity);
}

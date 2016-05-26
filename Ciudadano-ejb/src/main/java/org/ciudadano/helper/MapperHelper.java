
package org.ciudadano.helper;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

public class MapperHelper {
    private static final DozerBeanMapper mapper = MapperFactory.getInstance();
    
    public static <O,D> void copy(O origen,D Destino) throws MappingException{
        
        mapper.map(origen, Destino);
    }
}

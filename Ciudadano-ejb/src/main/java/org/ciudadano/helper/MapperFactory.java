
package org.ciudadano.helper;

import java.util.ArrayList;
import java.util.List;
import org.ciudadano.exception.NotInstanceException;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

public class MapperFactory {
    
    private static DozerBeanMapper mapper;
    
    private static void init()throws MappingException{
        try {
            List<String> filesConfig = new ArrayList<>();
            filesConfig.add("MappingClass.xml");
            mapper = new DozerBeanMapper();
        } catch (Exception error) {
            throw new MappingException(error.getMessage());
        }

    }
    
    public static DozerBeanMapper getInstance() throws NotInstanceException{
        if(mapper ==null)
            init();
        
        return mapper;
    }
    
}

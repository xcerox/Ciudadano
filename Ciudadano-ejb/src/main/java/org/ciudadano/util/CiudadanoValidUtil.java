
package org.ciudadano.util;

import org.ciudadano.dto.CiudadanoDto;
import org.ciudadano.exception.NotValidException;

public class CiudadanoValidUtil {
    public static boolean isValid(CiudadanoDto ciudadanoDto) throws NotValidException{
        
        StringBuilder MessageExceptions = new StringBuilder("Ciudadano no valido:");
        boolean isValid = true;
        
        if(ValidationUtil.isEmpty(ciudadanoDto.getNombre())){
            isValid = false;
            MessageExceptions.append(" Nombre en blaco,");
        }
        
        if(ValidationUtil.isEmpty(ciudadanoDto.getApellido())){
            isValid = false;
            MessageExceptions.append(" Apellido en blaco,");
        }
         
        if(ValidationUtil.isEmpty(ciudadanoDto.getSexo())){
           isValid = false;
            MessageExceptions.append(" Sexo en blanco,");
        }else{
            if(!ValidationUtil.isValidSexo(ciudadanoDto.getSexo())){
                isValid = false;
                MessageExceptions.append(" Sexo no valido,");
            }
        }
        
        if(ValidationUtil.isEmpty(ciudadanoDto.getFechaNacimiento())){
            isValid = false;
            MessageExceptions.append(" Fecha de nacimiento en blanco,");
        }
        
        if(ValidationUtil.isEmpty(ciudadanoDto.getCorreoElectronico())){
            isValid = false;
            MessageExceptions.append(" Correo en blaco,");
        }else{
            if(!ValidationUtil.isValidEmail(ciudadanoDto.getCorreoElectronico())){
                isValid = false;
                MessageExceptions.append(" Correo no valido,");
            }
        }
        
        if(isValid)
            return isValid;
        
        //Delete Final comma
         MessageExceptions = MessageExceptions.delete(MessageExceptions.length() - 1, MessageExceptions.length());
         throw new NotValidException(MessageExceptions.toString());
    }
    
     public static boolean isValidId(Integer id) throws NotValidException{
         boolean isValid = true;
         if(id <=0 ){
             isValid = false;
              throw new NotValidException("id no valido");
         }
         
         return isValid;
     }
}

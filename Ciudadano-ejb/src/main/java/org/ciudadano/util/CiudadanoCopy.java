
package org.ciudadano.util;

import org.ciudadano.dto.CiudadanoDto;
import org.ciudadano.model.Ciudadano;


public class CiudadanoCopy {
    public static Ciudadano toCiudadano(CiudadanoDto ciudadanoDto){
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(ciudadanoDto.getNombre());
        ciudadano.setApellido(ciudadanoDto.getApellido());
        ciudadano.setId(ciudadanoDto.getId());
        ciudadano.setFechaNacimiento(ciudadanoDto.getFechaNacimiento());
        ciudadano.setDireccion(ciudadanoDto.getDireccion());
        ciudadano.setSexo(ciudadanoDto.getSexo());
        ciudadano.setCorreoElectronico(ciudadanoDto.getCorreoElectronico());
        return ciudadano;
    }
    
    public static CiudadanoDto toCiudadanoDto(Ciudadano ciudadano){
        CiudadanoDto ciudadanoDto = new CiudadanoDto();
        ciudadanoDto.setNombre(ciudadano.getNombre());
        ciudadanoDto.setApellido(ciudadano.getApellido());
        ciudadanoDto.setId(ciudadano.getId());
        ciudadanoDto.setFechaNacimiento(ciudadano.getFechaNacimiento());
        ciudadanoDto.setDireccion(ciudadano.getDireccion());
        ciudadanoDto.setSexo(ciudadano.getSexo());
        ciudadanoDto.setCorreoElectronico(ciudadano.getCorreoElectronico());
        return ciudadanoDto;
    }
}

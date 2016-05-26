/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ciudadano.ejb.service;

import javax.ejb.Local;
import org.ciudadano.dto.CiudadanoDto;

/**
 *
 * @author j.reyes
 */
@Local
public interface CiudadanoService extends Service<CiudadanoDto, Integer>{
    
}

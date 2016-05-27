
package org.ciudadano.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.xml.ws.WebServiceRef;
import org.ciudadano.web.client.Ciudadano;
import org.ciudadano.web.client.CiudadanoDto;
import org.ciudadano.web.client.Ciudadano_Service;

public class CiudadanoController {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Ciudadano/Ciudadano.wsdl")
    private Ciudadano_Service service;

    private CiudadanoDto ciudadanoCurrent;
    private CiudadanoDto newCiudadano;
    
    public CiudadanoController() {
    }
    
    @PostConstruct
    public void init(){
        ciudadanoCurrent = new CiudadanoDto();
        newCiudadano = new CiudadanoDto();
    }

    public CiudadanoDto getCiudadanoCurrent() {
        return ciudadanoCurrent;
    }

    public void setCiudadanoCurrent(CiudadanoDto ciudadanoCurrent) {
        this.ciudadanoCurrent = ciudadanoCurrent;
    }

    public CiudadanoDto getNewCiudadano() {
        return newCiudadano;
    }

    public void setNewCiudadano(CiudadanoDto newCiudadano) {
        this.newCiudadano = newCiudadano;
    }
    
    public void registerNew(ActionEvent event)throws ValidatorException{
        CiudadanoDto ciudadanoCreated = null;
        try{
            Ciudadano port = service.getCiudadanoPort();
            ciudadanoCreated = port.create(newCiudadano);
        }catch(Exception error){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "hiciste click en registrar"));
        }
        
        if(ciudadanoCreated.getId() != null){
            newCiudadano = new CiudadanoDto();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ciudadano registrado"));
        }
    }
    
    public List<CiudadanoDto> getAll(){
        return findAll();
    }

    private List<CiudadanoDto> findAll()throws ValidatorException{
        try{
            Ciudadano port = service.getCiudadanoPort();
            return port.findAll();
        }catch(Exception error){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", error.getMessage()));
        }
    }

}

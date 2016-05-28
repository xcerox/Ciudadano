
package org.ciudadano.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.xml.ws.WebServiceRef;
import org.ciudadano.web.client.Ciudadano;
import org.ciudadano.web.client.CiudadanoDto;
import org.ciudadano.web.client.Ciudadano_Service;

public class CiudadanoController implements Serializable{

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
    
    public void registerNew(ActionEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        CiudadanoDto ciudadanoCreated = null;
        
        try{
            Ciudadano port = service.getCiudadanoPort();
            ciudadanoCreated = port.create(newCiudadano);
        }catch(Exception error){
            throw new RuntimeException(error.getMessage());
        }finally{
            if(ciudadanoCreated != null){
                newCiudadano = new CiudadanoDto();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful",  "Usuario Creado") );
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Successful",  "No se puedo crear el ciudadano"));
            }
        }
    }
    
    public List<CiudadanoDto> getAll(){
        try {
            return findAll();
        } catch (Exception e) {
            return null;
        }
    }

    private List<CiudadanoDto> findAll()throws ValidatorException{
        try{
            Ciudadano port = service.getCiudadanoPort();
            return port.findAll();
        }catch(Exception error){
            throw new RuntimeException(error.getMessage());
        }
    }

    public void deleteCiudadanoCurrent(){
        if(ciudadanoCurrent != null){
            FacesContext context = FacesContext.getCurrentInstance();
            try{
                Ciudadano port = service.getCiudadanoPort();
                port.delete(ciudadanoCurrent.getId());
            }catch(Exception error){
                throw new RuntimeException(error.getMessage());
            }finally{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful",  "ciudadano borrado"));
            }
        }
    }
}

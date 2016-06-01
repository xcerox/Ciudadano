
package org.ciudadano.web.controller;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.xml.ws.WebServiceRef;
import org.ciudadano.web.client.Ciudadano;
import org.ciudadano.web.client.CiudadanoDto;
import org.ciudadano.web.client.Ciudadano_Service;
import org.ciudadano.web.client.TelefonoDto;

public class ControllerNewCiudadano {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Ciudadano/Ciudadano.wsdl")
    private Ciudadano_Service service;
    private CiudadanoDto ciudadano;
    
    public ControllerNewCiudadano() {
    }
    
    @PostConstruct
    public void init(){
        ciudadano = new CiudadanoDto();
        ciudadano.setTelefonos(new ArrayList<TelefonoDto>());
    }

    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public void register(ActionEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        CiudadanoDto ciudadanoCreated = null;
        
        try{
            Ciudadano port = service.getCiudadanoPort();
            ciudadanoCreated = port.create(ciudadano);
        }catch(Exception error){
            throw new RuntimeException(error.getMessage());
        }finally{
            if(ciudadanoCreated != null){
                ciudadano = new CiudadanoDto();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful",  "Usuario Creado") );
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Successful",  "No se puedo crear el ciudadano"));
            }
        }
    }
    
    public void addTelefono(ActionEvent event){
        TelefonoDto editTelefono = new TelefonoDto();
        editTelefono.setTelefono("click para editar");
        ciudadano.getTelefonos().add(editTelefono);
    }
}

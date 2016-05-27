
package org.ciudadano.web.helper.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("empty")
public class EmptyValidatorHelper implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        HtmlInputText htmlInputText = (HtmlInputText) component;
        String label;
                
        if(htmlInputText.getLabel().trim().isEmpty() || htmlInputText.getLabel() == null)
            label = htmlInputText.getId();
        else
            label = htmlInputText.getLabel();
        
        if(value.toString().trim().isEmpty())
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", label + ": Es un campo Obligatorio"));
    }
    
}

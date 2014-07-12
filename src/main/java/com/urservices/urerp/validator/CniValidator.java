/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.validator;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.metier.IEmployeEJBMetierLocal;
import java.text.MessageFormat;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author samuel
 */
@FacesValidator(value = "cniValidator")
public class CniValidator implements Validator{

    
    @EJB
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       Employe employe = iEmployeEJBMetierLocal.findByCni(value.toString());
       
       
        if (employe != null) {
            String message = MessageFormat.format("{0} déjà utilisé", value.toString());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(facesMessage);
        }
    }
}

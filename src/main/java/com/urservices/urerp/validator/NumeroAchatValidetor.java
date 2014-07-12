/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urservices.urerp.validator;

import com.urservices.urerp.entities.Achat;
import com.urservices.urerp.metier.IAchatEJBMetierLocal;
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
@FacesValidator(value = "numeroAchatValidator")
public class NumeroAchatValidetor implements Validator{
    
    @EJB
    private IAchatEJBMetierLocal iAchatEJBMetierLocal;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Achat achat = iAchatEJBMetierLocal.findByNumero(value.toString());
        
        if (achat != null) {
            String message = MessageFormat.format("{0} exite déjà ", value.toString());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(facesMessage);
        }
    }
    
}

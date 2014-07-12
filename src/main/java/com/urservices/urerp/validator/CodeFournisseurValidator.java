/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.validator;

import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.metier.IFournisseurEJBMetierLocal;
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
@FacesValidator(value = "codeFournisseurValidator")
public class CodeFournisseurValidator implements Validator{

    @EJB
    private IFournisseurEJBMetierLocal iFournisseurEJBMetierLocal;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Fournisseur fournisseur = iFournisseurEJBMetierLocal.findByCode(value.toString());
        
        if (fournisseur != null) {
            String message = MessageFormat.format("{0} exite déjà ", value.toString());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(facesMessage);
        }
    }
    
}

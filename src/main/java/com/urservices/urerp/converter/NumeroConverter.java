/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.converter;

import com.urservices.urerp.entities.Fournisseur;
import com.urservices.urerp.metier.IFournisseurEJBMetierLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author samuel
 */
@FacesConverter(value = "numeroConverter")
public class NumeroConverter implements Converter{

    @EJB
    private IFournisseurEJBMetierLocal iFournisseurEJBMetierLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Fournisseur fournisseur = iFournisseurEJBMetierLocal.findById(Long.valueOf(value));
        return fournisseur;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Fournisseur fournisseur = (Fournisseur)value;
        return String.valueOf(fournisseur.getAdresse().getTelephone());
    }
    
}

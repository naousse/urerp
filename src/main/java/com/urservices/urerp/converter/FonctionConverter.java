/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.converter;

import com.urservices.urerp.entities.Fonction;
import com.urservices.urerp.metier.IFonctionEJBMetierLocal;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author samuel
 */
@FacesConverter(value = "fonctionConverter")
public class FonctionConverter implements Converter{

    @EJB
    private IFonctionEJBMetierLocal iFonctionEJBMetierLocal;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Fonction fonction = iFonctionEJBMetierLocal.findById(Long.valueOf(value));
        System.out.println(value);
        System.out.println(fonction.getId());
        return fonction;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Fonction fonction = (Fonction)value;
        System.out.println(value);
        return String.valueOf(fonction.getId());
    }
    
}

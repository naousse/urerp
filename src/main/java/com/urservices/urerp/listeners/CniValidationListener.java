/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.listeners;

import com.urservices.urerp.entities.Employe;
import com.urservices.urerp.metier.IEmployeEJBMetierLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author samuel
 */
public class CniValidationListener implements ActionListener{

    
    private IEmployeEJBMetierLocal iEmployeEJBMetierLocal;
    
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        
        String cni = (String)app.evaluateExpressionGet(context, "#{employeBean.employe.cni}", String.class);
        String idemploye = (String)app.evaluateExpressionGet(context, "#{employeBean.employe.id}", String.class);
        try {
            Context ctx = new InitialContext();
            iEmployeEJBMetierLocal = (IEmployeEJBMetierLocal)ctx.lookup("java:global/urerp/EmployeEJBMetier!com.urservices.urerp.metier.IEmployeEJBMetierLocal");
        } catch (NamingException ex) {
            Logger.getLogger(CniValidationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Employe employe = iEmployeEJBMetierLocal.findByCni(cni);
        
        long employeGetId = employe.getId();
        long employeid = Long.valueOf(idemploye);
        if ((employe!=null)&&(employeGetId != employeid)) {
            context.addMessage("employe", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous ne pouvez modifier la Cni", null));
            throw new AbortProcessingException();
        }
        
    }
}

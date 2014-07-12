/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.metier;

import com.urservices.urerp.dao.ICPhysiqueEJBDaoLocal;
import com.urservices.urerp.entities.CPhysique;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author samuel
 */
@Stateless
public class CPhysiqueEJBMetier implements ICPhysiqueEJBMetierLocal, ICPhysiqueEJBMetierRemote, Serializable{

    //Injection d'une référence vers l'EJB ICPhysiqueEJBDaoLocal
    @EJB
    private ICPhysiqueEJBDaoLocal iCPhysiqueEJBDaoLocal;

    @Override
    public CPhysique create(CPhysique cPhysique) {
        return iCPhysiqueEJBDaoLocal.create(cPhysique);
    }

    @Override
    public CPhysique update(CPhysique cPhysique) {
        return iCPhysiqueEJBDaoLocal.update(cPhysique);
    }

    @Override
    public int delete(CPhysique cPhysique) {
        return iCPhysiqueEJBDaoLocal.delete(cPhysique);
    }

    @Override
    public CPhysique findById(Long id) {
        return iCPhysiqueEJBDaoLocal.findById(id);
    }

    @Override
    public List<CPhysique> findAll() {
        return iCPhysiqueEJBDaoLocal.findAll();
    }

    @Override
    public CPhysique findClientPhysiqueByCni(String cni) {
        return iCPhysiqueEJBDaoLocal.findClientPhysiqueByCni(cni);
    }

}

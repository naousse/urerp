/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.urservices.urerp.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author samuel
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Adresse implements Serializable {
    
    protected Long telephone;
    protected String email;
    protected String boitePostal;

    public Adresse() {
    }

    public Adresse(Long telephone, String email, String boitePostal) {
        this.telephone = telephone;
        this.email = email;
        this.boitePostal = boitePostal;
    }

    public Long getTelephone() {
        return telephone;
    }

    @NotNull(message = "{urerp.entity.required}")
    public String getEmail() {
        return email;
    }

    @NotNull(message = "{urerp.entity.required}")
    public String getBoitePostal() {
        return boitePostal;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBoitePostal(String boitePostal) {
        this.boitePostal = boitePostal;
    }
}

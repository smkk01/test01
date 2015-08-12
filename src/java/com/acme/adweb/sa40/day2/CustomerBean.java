/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.adweb.sa40.day2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerBean {
    
    @PersistenceContext private EntityManager em;
    
    public Customer find(Integer custId) {
        return (em.find(Customer.class, custId));
    }
}

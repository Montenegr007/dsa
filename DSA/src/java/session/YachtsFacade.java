/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Yachts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anton
 */
@Stateless
public class YachtsFacade extends AbstractFacade<Yachts> {

    @PersistenceContext(unitName = "DSAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public YachtsFacade() {
        super(Yachts.class);
    }
    
}

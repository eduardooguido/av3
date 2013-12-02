/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av3.util;


import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

public class PhaseListener implements javax.faces.event.PhaseListener {

    //Antes da Fase
    //Inicia a transação, obtem a sessao do hibernate, abre a sessao, 
    //iniciaa a transação e coloca no mapa da requisição a session do hibernate
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Antes da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);            
        }
    }
    
    //Depois da Fase
    //comitar a transação, caso ocorra erro, faz rollback
    // fecha a sessão
    @Override
    
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally{
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}

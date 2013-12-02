/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av3.util;

/**
 *
 * @author casa
 */
import javax.faces.context.FacesContext;
import org.hibernate.Session;

public class FacesContextUtil {

    private static final String HIBERNATE_SESSION = "hibernate_session";

    public static void setRequestSession(Session session){ // Seta na requisição a sessao do hibernate
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }
    
    public static Session getRequestSession() { // Recebe a sessão de volta e remove do mapa da sessão do usuario
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
    
}

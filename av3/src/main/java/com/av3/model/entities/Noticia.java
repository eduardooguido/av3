/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av3.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Noticia")
public class Noticia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "idNoticia", nullable = false)
    private Integer idNoticia;
    @Column(name = "Data", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name = "Usuario", length = 40)
    private String usuarioNoticia;
    @Column(name = "Categoria", length = 40)
    private String categoria;
    @Column(name = "Titulo", nullable = false, length = 80)
    private String titulo;
    @Column(name = "Noticia", nullable = false, length = 80)
    private String noticia;
    @Column(name = "Status", length = 36)
    private String status;
    
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "NoticiaUsuario")
    private Noticia noticias;

    
    public Noticia() {
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsuarioNoticia() {
        return usuarioNoticia;
    }

    public void setUsuarioNoticia(String usuarioNoticia) {
        this.usuarioNoticia = usuarioNoticia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.idNoticia != null ? this.idNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Noticia other = (Noticia) obj;
        if (this.idNoticia != other.idNoticia && (this.idNoticia == null || !this.idNoticia.equals(other.idNoticia))) {
            return false;
        }
        return true;
    }
}

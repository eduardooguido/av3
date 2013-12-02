/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av3.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author casa
 */

@Entity
@Table (name = "categoria")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue
    @Column (name = "IdCategoria", nullable = false)
    private Integer IdCategoria;
    @Column (name ="Nome", length=80, nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @ForeignKey (name="CategoriaNoticia")
    private List<Noticia> noticias;
    
    public Categoria() {
        
    }

    public Integer getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(Integer IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.IdCategoria != null ? this.IdCategoria.hashCode() : 0);
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
        final Categoria other = (Categoria) obj;
        if (this.IdCategoria != other.IdCategoria && (this.IdCategoria == null || !this.IdCategoria.equals(other.IdCategoria))) {
            return false;
        }
        return true;
    }
    
    
    
    }

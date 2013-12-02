/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av3.model.entities;

/**
 *
 * @author casa
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noticia")
public class Noticia implements Serializable {
    //interface serializable para agilizar o transporte pela rede

    private static final long serialVersionUID = 1L;
    @Id // id da tabela do hibernate ( chave primaria )
    @GeneratedValue // informa pro hibernate que o campo sera gerado pelo banco ( MySQL )e sera auto incremento 
    @Column(name = "IdNoticia", nullable = false) //nome na tabela que nao aceita nulo 
    private Integer idNoticia;
    @Column(name = "Name", nullable = false, length = 80) // define nome e regras ( nullable não aceita nulo) ( length tamanho )
    private String nome;
    @Column(name = "Login", unique = true, length = 25)
    private String login;
    @Column(name = "Senha", length = 40)
    private String senha;
    @Column(name = "Permissao", length = 36)
    private String permissao;

    public Noticia() {
    }

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idNoticia != null ? this.idNoticia.hashCode() : 0);
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

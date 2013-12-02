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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    //interface serializable para agilizar o transporte pela rede

    private static final long serialVersionUID = 1L;
    @Id // id da tabela do hibernate ( chave primaria )
    @GeneratedValue // informa pro hibernate que o campo sera gerado pelo banco ( MySQL )e sera auto incremento 
    @Column(name = "IdUsuario", nullable = false) //nome na tabela que nao aceita nulo 
    private Integer iDUsuario;
    @Column(name = "Nome", nullable = false, length = 80) // define nome e regras ( nullable não aceita nulo) ( length tamanho )
    private String nome;
    @Column(name = "Login", unique = true, length = 25)
    private String login;
    @Column(name = "Senha", length = 40)
    private String senha;
    @Column(name = "Permissao", length = 36)
    private String permissao;
    
@OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY)
@ForeignKey (name = "UsuarioNotica")

private List<Noticia> noticias;


    public Usuario() {
        
    }

    public Integer getIDUsuario() {
        return iDUsuario;
    }

    public void setIDUsuario(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
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

    public Integer getiDUsuario() {
        return iDUsuario;
    }

    public void setiDUsuario(Integer iDUsuario) {
        this.iDUsuario = iDUsuario;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.iDUsuario != null ? this.iDUsuario.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.iDUsuario != other.iDUsuario && (this.iDUsuario == null || !this.iDUsuario.equals(other.iDUsuario))) {
            return false;
        }
        return true;
    }
}

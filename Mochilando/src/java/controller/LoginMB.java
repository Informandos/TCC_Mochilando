package controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@Named
public class LoginMB implements Serializable{
    
    private String email;
    private String senha;

    public String getUsuario() {
        return email;
    }

    public void setUsuario(String usuario) {
        this.email = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String fowardToRecuperacaoSenha(){
        return "recuperacaoSenha.jsf";
    }
    
}

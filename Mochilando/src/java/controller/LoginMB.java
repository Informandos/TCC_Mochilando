



package controller;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.domain.Usuario;
import model.service.implementacao.ManterUsuario;

@ManagedBean
@SessionScoped
public class LoginMB {
    private String email = "";
    private String senha = "";
    
    /**
     *
     * @return
     */
    
    private Usuario usuario;
    private Boolean usuarioLogado;
    private static LoginMB instance;
    
    @PostConstruct
    public void inicializa()
    {
        usuario = new Usuario();
        usuarioLogado = Boolean.FALSE;
        instance = this;
    }
    public static LoginMB getInstance() throws Exception
    {
        if(instance == null)
        {
            throw new Exception("Não há usuario logado no sistema, Oh my god!");
        }
        return instance;
    }
    public void logout()
    {
        this.usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    public void fazerLogin()
    {
        try {
            ManterUsuario manterU = new ManterUsuario();
            Usuario u = manterU.getUserLogin(email, senha);
            
            if(u == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario não encontrado ou senha incorreta, tente novamente."));
            }
            else
            {
                usuarioLogado = Boolean.TRUE;
                usuario = u;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao efetuar login, tente novamente."));
        }
    }
    
    public Usuario getUser() {
        return usuario;
    }
    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String logar(){
        if(email.equals("admin") && senha.equals("admin")){
            return "indexLogado.jsf";
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
        ctx.addMessage(null, msg);
        return "";              
    }
    
    
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
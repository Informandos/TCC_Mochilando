/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Aluno
 */
public class UsuarioLogado {
    private Usuario user;
    private Boolean usuarioLogado;
    private static UsuarioLogadoController instance;
    @PostConstruct
    public void inicializa()
    {
        user = new Usuario();
        usuarioLogado = Boolean.FALSE;
        instance = this;
    }
    public static UsuarioLogadoController getInstance() throws Exception
    {
        if(instance == null)
        {
            throw new Exception("Não há usuario logado no sistema, Oh my god!");
        }
        return instance;
    }
    public void logout()
    {
        this.user = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    public void fazerLogin()
    {
        try {
            Usuario u = new UsuarioBO().efetuarLogin(user);
            if(u == null)
            {
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuario não encontrado ou senha incorreta, tente novamente."));
            }
            else
            {
                usuarioLogado = Boolean.TRUE;
                user = u;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao efetuar login, tente novamente."));
        }
    }
    public String getNomeUsuario() throws IOException
    {
        if(usuarioLogado)
        {
            return user.getFuncionario().getNmFuncionario();
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("/projetoEstagio/faces/paginas/login.xhtml");
        return "";
    }
    public Usuario getUser() {
        return user;
    }
    public void setUser(Usuario user) {
        this.user = user;
    }
}

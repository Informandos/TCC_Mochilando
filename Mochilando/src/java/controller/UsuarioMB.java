/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Juliana 
 * Usando Panel View JSF
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.domain.Usuario;
import model.service.implementacao.ManterUsuario;
import model.service.interfaces.InterfaceManterUsuario;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

 
@ManagedBean
@SessionScoped
public class UsuarioMB {
    
    private Usuario usuario;
    private InterfaceManterUsuario manterUsuario;
    
 
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        manterUsuario = new ManterUsuario();
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
     
    public Usuario getUsuario() {
        return usuario;
    }
    
    public boolean updateUsuario() throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente{
        boolean result = manterUsuario.alterar(usuario);
        return result;
    }
     
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Aba mudada", "Aba ativa: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Aba fechada", "Aba anterior: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

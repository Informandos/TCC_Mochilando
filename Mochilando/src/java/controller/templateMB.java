package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import controller.LoginMB;

@ManagedBean
@SessionScoped
public class templateMB implements Serializable {
    
    LoginMB login;
    
    public String fowardToPerfil(){
        if (login.getInstance() != null) {
            return "peril.jsf";
        }else{
            return "index.jsf";
        }
    } 
    public String fowardToCrarDiaio(){
        if (login.getInstance() != null) {
            return "criarDiario.jsf";
        }else{
            return "index.jsf";
        }
    }
    public String fowardToIndex(){
        if (login.getInstance() != null) {
            return "indexLogado.jsf";
        }else{
            return "index.jsf";
        }
    } 
}

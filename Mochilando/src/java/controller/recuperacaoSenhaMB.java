package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lucca
 */
@ManagedBean
@SessionScoped
public class recuperacaoSenhaMB implements Serializable{
    private String txtSenha;

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }
    
}

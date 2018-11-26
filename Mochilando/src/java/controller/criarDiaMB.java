package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author lucca
 */
@SessionScoped
@Named
public class criarDiaMB implements Serializable{
    private String detalhesDia;
    private UploadedFile midia;

    public String getDetalhesDia() {
        return detalhesDia;
    }

    public void setDetalhesDia(String detalhesDia) {
        this.detalhesDia = detalhesDia;
    }

    public UploadedFile getMidia() {
        return midia;
    }

    public void setMidia(UploadedFile midia) {
        this.midia = midia;
    }
}

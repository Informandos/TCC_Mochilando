package controller;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.UploadedFile;

@SessionScoped
@Named
public class CriarDiarioMB implements Serializable {
    private String titulo;
    private String tipoDiario;
    private Date dataInicio;
    private Date dataFim;
    private String detalhesViagem;
    private String detalhesDia;
    private UploadedFile midia;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoDiario() {
        return tipoDiario;
    }

    public void setTipoDiario(String tipoDiario) {
        this.tipoDiario = tipoDiario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDetalhesViagem() {
        return detalhesViagem;
    }

    public void setDetalhesViagem(String detalhesViagem) {
        this.detalhesViagem = detalhesViagem;
    }

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

package controller;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@SessionScoped
@Named
public class EditarTagsUsuarioMB implements Serializable{

    private boolean valueMontanha;
    private boolean valueCidade;
    private boolean valueInterior;
    private boolean valuePraca;
    private boolean valueMuseu;
    private boolean value7Maravilhas;
    private boolean valueParque;
    private boolean valuePraia;

    public boolean isValueMontanha() {
        return valueMontanha;
    }

    public void setValueMontanha(boolean valueMontanha) {
        this.valueMontanha = valueMontanha;
    }

    public boolean isValueCidade() {
        return valueCidade;
    }

    public void setValueCidade(boolean valueCidade) {
        this.valueCidade = valueCidade;
    }

    public boolean isValueInterior() {
        return valueInterior;
    }

    public void setValueInterior(boolean valueInterior) {
        this.valueInterior = valueInterior;
    }

    public boolean isValuePraca() {
        return valuePraca;
    }

    public void setValuePraca(boolean valuePraca) {
        this.valuePraca = valuePraca;
    }

    public boolean isValueMuseu() {
        return valueMuseu;
    }

    public void setValueMuseu(boolean valueMuseu) {
        this.valueMuseu = valueMuseu;
    }

    public boolean isValue7Maravilhas() {
        return value7Maravilhas;
    }

    public void setValue7Maravilhas(boolean value7Maravilhas) {
        this.value7Maravilhas = value7Maravilhas;
    }

    public boolean isValueParque() {
        return valueParque;
    }

    public void setValueParque(boolean valueParque) {
        this.valueParque = valueParque;
    }

    public boolean isValuePraia() {
        return valuePraia;
    }

    public void setValuePraia(boolean valuePraia) {
        this.valuePraia = valuePraia;
    }

    

}


package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.domain.Dia;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="foto", schema="public")
public class Foto implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long seqFoto;
    
    @OneToMany
    @JoinColumn(name = "seq_Dia")
    private Dia dia;
    @Column(name = "foto")
    private Byte Foto;

    public Long getSeqFoto() {
        return seqFoto;
    }

    public void setSeqFoto(Long seqFoto) {
        this.seqFoto = seqFoto;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Byte getFoto() {
        return Foto;
    }

    public void setFoto(Byte Foto) {
        this.Foto = Foto;
    }
    
}

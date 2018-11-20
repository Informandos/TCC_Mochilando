package model.domainJPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="tipo_atracao", schema="public")
public class TipoAtracao implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long codTipoAtracao;
    
    @Column(name = "desc_tipo_atracao")
    private String descTipoAtracao;

    public Long getCodTipoAtracao() {
        return codTipoAtracao;
    }

    public void setCodTipoAtracao(Long codTipoAtracao) {
        this.codTipoAtracao = codTipoAtracao;
    }
    
}

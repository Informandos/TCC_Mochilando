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
@Table(name="tag")
public class Tag implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long codTag;
    
    @Column(name = "desc_tag")
    private String descTag;

    public Long getCodTag() {
        return codTag;
    }

    public void setCodTag(Long codTag) {
        this.codTag = codTag;
    }
    
}

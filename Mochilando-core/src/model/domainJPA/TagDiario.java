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
import model.domain.Tag;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="tag_diario", schema="public")
public class TagDiario implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long seqTagDiario;
    
    @Column(name = "tag_diario")
    private Long tagDiario;
    @OneToMany
    @JoinColumn(name = "cod_tag")
    private Tag tag;

    public Long getSeqTagDiario() {
        return seqTagDiario;
    }

    public void setSeqTagDiario(Long seqTagDiario) {
        this.seqTagDiario = seqTagDiario;
    }

    public Long getTagDiario() {
        return tagDiario;
    }

    public void setTagDiario(Long tagDiario) {
        this.tagDiario = tagDiario;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}

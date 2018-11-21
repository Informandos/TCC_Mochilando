package model.serviceJPAImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.interfaces.InterfaceTagDAO;
import model.domain.Tag;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterTag implements InterfaceTagDAO{

    protected EntityManager em;

    public ManterTag(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Long inserir(Tag tag) throws ExcecaoPersistencia {
        if((tag.getCodTag() == null))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o cod teg.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
         if((tag.getDescTag()== null) || (tag.getDescTag().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o desc tag.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(tag);
        return tag.getCodTag();
    }

    @Override
    public boolean atualizar(Tag tag) throws ExcecaoPersistencia {
        if((tag.getCodTag() == null))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o cod teg.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
         if((tag.getDescTag()== null) || (tag.getDescTag().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o desc tag.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tag tagAux = consultarPorId(tag.getCodTag());
        
        if(tagAux != null){
            tagAux.setCodTag(tag.getCodTag());
            tagAux.setDescTag(tag.getDescTag());
        }
        return true;
        
    }

    @Override
    public boolean deletar(Tag tag) throws ExcecaoPersistencia {
        if(tag != null){
            em.remove(tag);
        }
        return true;
    }

    @Override
    public Tag consultarPorId(Long codTag) throws ExcecaoPersistencia {
        return em.find(Tag.class, codTag);
    }

    @Override
    public Tag consultarPorNome(String descTag) throws ExcecaoPersistencia {
        Query query = em.createQuery("SELECT * FROM tag WHERE desc_tag = "+descTag);
        Tag result = (Tag) query.getSingleResult();
        return result;
    }

    @Override
    public List<Tag> listarTudo() throws ExcecaoPersistencia {
        Query query = em.createQuery("SELECT * FROM tag ORDER BY cod_tag");
        List<Tag> result = query.getResultList();
        return result;
    }
    
}

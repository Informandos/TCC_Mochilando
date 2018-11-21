package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.TagDiario;
import model.service.interfaces.InterfaceManterTagDiario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterTagDiario implements InterfaceManterTagDiario {
    
    protected EntityManager em;
    
    @Override
    public Long cadastrar(TagDiario tagDiario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(tagDiario.getSeqTagDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da Tag do diário");
        }
        if(tagDiario.getDiario().getCodDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diário");
        }
        if(tagDiario.getTag().getCodTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag");
        }
        
        em.persist(tagDiario);
        return tagDiario.getSeqTagDiario();
    }

    @Override
    public boolean alterar(TagDiario tagDiario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(tagDiario.getSeqTagDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da Tag do diário");
        }
        if(tagDiario.getDiario().getCodDiario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do diário");
        }
        if(tagDiario.getTag().getCodTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag");
        }
        TagDiario tagDiarioAux = pesquisarPorId(tagDiario.getSeqTagDiario());
        if(tagDiarioAux != null){
            tagDiarioAux.setSeqTagDiario(tagDiario.getSeqTagDiario());
            tagDiarioAux.setDiario(tagDiario.getDiario());
            tagDiarioAux.setTag(tagDiario.getTag());
        }
        return true;
    }

    @Override
    public boolean excluir(TagDiario tagDiario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(tagDiario != null){
            em.remove(tagDiario);
        }
        return true;
    }

    @Override
    public TagDiario pesquisarPorId(Long seqTagDiario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(TagDiario.class, seqTagDiario);
    }

    @Override
    public List<TagDiario> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tag_diario ORDER BY nom_estado");
        List<TagDiario> result = query.getResultList();
        return result;
    }

    @Override
    public List<TagDiario> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tag_diario WHERE cod_diario = "+codDiario);
        List<TagDiario> result = query.getResultList();
        return result;
    }

    @Override
    public List<TagDiario> pesquisarPorCodTag(Long codTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        /*Tá errado, não sei como fazer*/
        Query query = em.createQuery("SELECT * FROM tag_diario WHERE cod_tag = "+codTag);
        List<TagDiario> result = query.getResultList();
        return result;
    }
    
}

package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import model.dao.interfaces.InterfaceTagDiarioDAO;
import model.domain.TagDiario;
import model.service.interfaces.InterfaceManterTagDiario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class MaterTagDiario implements InterfaceManterTagDiario {
    
    protected InterfaceTagDiarioDAO tagDiarioDAO;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TagDiario pesquisarPorId(Long seqTagDiario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TagDiario> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TagDiario> pesquisarPorCodDiario(Long codDiario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TagDiario> pesquisarPorCodTag(Long codTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

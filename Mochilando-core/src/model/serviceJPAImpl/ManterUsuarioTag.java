package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.UsuarioTag;
import model.service.interfaces.InterfaceManterUsuarioTag;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterUsuarioTag implements InterfaceManterUsuarioTag {
    
    protected EntityManager em;

    public ManterUsuarioTag(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Long cadastrar(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(usuarioTag.getSeqUsuarioTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag do usuario");
        }
        if(usuarioTag.getTag().getCodTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag");
        }
        if(usuarioTag.getUsuario().getCodUsuario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        em.persist(usuarioTag);
        return usuarioTag.getSeqUsuarioTag();
    }

    @Override
    public boolean alterar(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(usuarioTag.getSeqUsuarioTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag do usuario");
        }
        if(usuarioTag.getTag().getCodTag() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código da tag");
        }
        if(usuarioTag.getUsuario().getCodUsuario() == null){
            throw new ExcecaoNegocio("Obrigatório informar o código do usuário");
        }
        UsuarioTag usuarioTagAux = pesquisarPorId(usuarioTag.getSeqUsuarioTag());
        if(usuarioTagAux != null){
            usuarioTagAux.setSeqUsuarioTag(usuarioTag.getSeqUsuarioTag());
            usuarioTagAux.setTag(usuarioTag.getTag());
            usuarioTagAux.setUsuario(usuarioTag.getUsuario());
        }
        return true;
    }

    @Override
    public boolean excluir(UsuarioTag usuarioTag) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(usuarioTag != null){
            em.remove(usuarioTag);
        }
        return true;
    }

    @Override
    public UsuarioTag pesquisarPorId(Long seqUsuarioTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(UsuarioTag.class, seqUsuarioTag);
    }

    @Override
    public List<UsuarioTag> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tag_diario ORDER BY seq_usuario_tag");
        List<UsuarioTag> result = query.getResultList();
        return result;
    }

    @Override
    public List<UsuarioTag> pesquisarPorCodUsuario(Long codUsuario) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tag_diario WHERE cod_usuario = "+codUsuario);
        List<UsuarioTag> result = query.getResultList();
        return result;
    }

    @Override
    public List<UsuarioTag> pesquisarPorCodTag(Long codTag) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tag_diario WHERE cod_tag = "+codTag);
        List<UsuarioTag> result = query.getResultList();
        return result;
    }
    
}

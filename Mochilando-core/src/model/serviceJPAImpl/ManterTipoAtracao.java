package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.TipoAtracao;
import model.service.interfaces.InterfaceManterTipoAtracao;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterTipoAtracao implements InterfaceManterTipoAtracao {
    
    protected EntityManager em;

    public ManterTipoAtracao(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Long cadastrar(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if ((tipoAtracao.getDescTipoAtracao() == null) || (tipoAtracao.getDescTipoAtracao().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar a descricao do tipo Atracao.");
        }
        em.persist(tipoAtracao);
        return tipoAtracao.getCodTipoAtracao();
    }

    @Override
    public boolean alterar(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if ((tipoAtracao.getDescTipoAtracao() == null) || (tipoAtracao.getDescTipoAtracao().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar a descricao do tipo Atracao.");
        }
        TipoAtracao tipoAtracaoAux = pesquisarPorId(tipoAtracao.getCodTipoAtracao());
        if(tipoAtracao != null){
            tipoAtracaoAux.setCodTipoAtracao(tipoAtracao.getCodTipoAtracao());
            tipoAtracaoAux.setDescTipoAtracao(tipoAtracao.getDescTipoAtracao());
        }
        return true;
    }

    @Override
    public boolean excluir(TipoAtracao tipoAtracao) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(tipoAtracao != null){
            em.remove(tipoAtracao);
        }
        return true;
    }

    @Override
    public TipoAtracao pesquisarPorId(Long codTipoAtracao) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(TipoAtracao.class, codTipoAtracao);
    }

    @Override
    public TipoAtracao pesquisarPorNome(String descTipoAtracao) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tipo_atrcao WHERE desc_tipo_atrcao = "+descTipoAtracao);
        TipoAtracao result = (TipoAtracao) query.getSingleResult();
        return result;
    }

    @Override
    public List<TipoAtracao> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM tipo_atracao ORDER BY cod_tipo_atracao");
        List<TipoAtracao> result = query.getResultList();
        return result;
    }
    
}

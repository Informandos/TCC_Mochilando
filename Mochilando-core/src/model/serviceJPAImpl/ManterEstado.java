package model.serviceJPAImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.dao.interfaces.InterfaceEstadoDAO;
import model.domain.Estado;
import model.service.interfaces.InterfaceManterEstado;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterEstado implements InterfaceManterEstado{
    
    protected InterfaceEstadoDAO estadoDAO;
    protected EntityManager em;

    public ManterEstado(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Long cadastrar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            try {
                throw new ExcecaoNegocio("Obrigatório informar a sigla.");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(ManterEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
        Long result = estadoDAO.inserir(estado);
        return result;
    }

    @Override
    public boolean alterar(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if((estado.getNomEstado() == null) || (estado.getNomEstado().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar o nome do estado.");
        
        if((estado.getSigla() == null) || (estado.getSigla().isEmpty()))
            throw new ExcecaoNegocio("Obrigatório informar a sigla.");
                  
        boolean result = estadoDAO.atualizar(estado);
        return result;
    }

    @Override
    public boolean excluir(Estado estado) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(estado != null){
            em.remove(estado);
        }
        return true;
    }

    @Override
    public Estado pesquisarPorId(Long codEstado) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(Estado.class, codEstado);
    }

    @Override
    public Estado pesquisarPorSigla(String sigla) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(Estado.class, sigla);
    }

    @Override
    public List<Estado> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM estado ORDER BY nom_estado");
        List<Estado> result = query.getResultList();
        return result;
    }
      
}

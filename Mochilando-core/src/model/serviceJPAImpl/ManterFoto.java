package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Foto;
import model.service.interfaces.InterfaceManterFoto;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterFoto implements InterfaceManterFoto {

    protected EntityManager em;

    public ManterFoto(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long cadastrar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if ((foto.getDia().getSeqDia() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar o codigo do dia ao qual a foto pertence");
        }

        if ((foto.getSeqFoto() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar o codigo da foto");
        }

        if (foto.getByteFoto() == null) {
            throw new ExcecaoNegocio("Obrigatório informar a foto");
        }
        em.persist(foto);
        return foto.getSeqFoto();
    }

    @Override
    public boolean alterar(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if( (foto.getDia().getSeqDia()== null))
            throw new   ExcecaoNegocio("Obrigatório informar o codigo do dia ao qual a foto pertence");
        
        if( (foto.getSeqFoto()== null) )
            throw new   ExcecaoNegocio("Obrigatório informar o codigo da foto");
        
        if( foto.getByteFoto()==null)
            throw new ExcecaoNegocio("Obrigatório informar a foto");
        
        Foto fotoAux = pesquisarPorId(foto.getSeqFoto());
        
        if(fotoAux != null){
            fotoAux.setByteFoto(foto.getByteFoto());
            fotoAux.setDia(foto.getDia());
            fotoAux.setSeqFoto(foto.getSeqFoto());
        }
        return true;
    }

    @Override
    public boolean excluir(Foto foto) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente {
        if(foto != null){
            em.remove(foto);
        }
        return true;
    }

    @Override
    public Foto pesquisarPorId(Long seqFoto) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        return em.find(Foto.class, seqFoto);
    }

    @Override
    public List<Foto> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM foto ORDER BY seq_foto");
        List<Foto> result = query.getResultList();
        return result;
    }

    @Override
    public List<Foto> pesquisarPorDia(Long seqDia) throws ExcecaoPersistencia, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM foto WHERE seq_dia = "+ seqDia);
        List<Foto> result = query.getResultList();
        return result;
    }

}

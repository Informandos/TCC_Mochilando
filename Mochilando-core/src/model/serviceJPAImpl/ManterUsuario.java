package model.serviceJPAImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Usuario;
import model.service.interfaces.InterfaceManterUsuario;
import util.db.exception.ExcecaoConexaoCliente;
import util.db.exception.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author lucca
 */
public class ManterUsuario implements InterfaceManterUsuario {

    EntityManager em;

    public ManterUsuario(EntityManager em) {
        this.em = em;
    }

    @Override
    public Long cadastrar(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        if ((usuario.getNomUsuario() == null) || (usuario.getNomUsuario().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o nome.");
        }
        if ((usuario.getTxtSenha() == null) || (usuario.getTxtSenha().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar a senha.");
        }
        if ((usuario.getTxtEmail() == null) || (usuario.getTxtEmail().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o E-mail.");
        }
        if ((usuario.getDatNascimento() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar a data de nascimento.");
        }
        if ((usuario.getSobrenomeUsuario() == null) || (usuario.getSobrenomeUsuario().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o sobrenome");
        }
        if ((usuario.getSexo() == null) || (usuario.getSexo().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o sexo");
        }
        em.persist(usuario);
        return usuario.getCodUsuario();
    }

    @Override
    public boolean alterar(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        if ((usuario.getNomUsuario() == null) || (usuario.getNomUsuario().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o nome.");
        }
        if ((usuario.getTxtSenha() == null) || (usuario.getTxtSenha().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar a senha.");
        }
        if ((usuario.getTxtEmail() == null) || (usuario.getTxtEmail().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o E-mail.");
        }
        if ((usuario.getDatNascimento() == null)) {
            throw new ExcecaoNegocio("Obrigatório informar a data de nascimento.");
        }
        if ((usuario.getSobrenomeUsuario() == null) || (usuario.getSobrenomeUsuario().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o sobrenome");
        }
        if ((usuario.getSexo() == null) || (usuario.getSexo().isEmpty())) {
            throw new ExcecaoNegocio("Obrigatório informar o sexo");
        }
        Usuario usuarioAux = pesquisarPorId(usuario.getCodUsuario());
        if (usuarioAux != null) {
            usuarioAux.setCidade(usuario.getCidade());
            usuarioAux.setCodUsuario(usuario.getCodUsuario());
            usuarioAux.setDatNascimento(usuario.getDatNascimento());
            usuarioAux.setImgPerfil(usuario.getImgPerfil());
            usuarioAux.setNomUsuario(usuario.getNomUsuario());
            usuarioAux.setSexo(usuario.getSexo());
            usuarioAux.setSobrenomeUsuario(usuario.getSobrenomeUsuario());
            usuarioAux.setTxtEmail(usuario.getSobrenomeUsuario());
            usuarioAux.setTxtSenha(usuario.getTxtSenha());
        }
        return true;
    }

    @Override
    public boolean excluir(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        if(usuario != null){
            em.remove(usuario);
        }
        return true;
    }

    @Override
    public List<Usuario> pesquisarTodos() throws ExcecaoPersistencia, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM usuario ORDER BY nom_usuario");
        List<Usuario> result = query.getResultList();
        return result;
    }

    @Override
    public Usuario pesquisarPorId(Long id) throws ExcecaoPersistencia, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        return em.find(Usuario.class, id);
    }

    @Override
    public Usuario getUserLogin(String email, String senha) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM usuario WHERE txt_email = "+email+" AND txt_senha = "+senha);
        Usuario result = (Usuario) query.getSingleResult();
        return result;
    }

    @Override
    public Usuario getUserEmail(String email) throws ExcecaoPersistencia, ExcecaoNegocio, ExcecaoConexaoCliente, ExcecaoConexaoCliente {
        Query query = em.createQuery("SELECT * FROM usuario WHERE txt_email = "+email);
        Usuario result = (Usuario) query.getSingleResult();
        return result;
    }

}

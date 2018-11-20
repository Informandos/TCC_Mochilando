package model.domainJPA;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import model.domain.Cidade;

/**
 *
 * @author lucca
 */

@Entity
@Table(name="usuario", schema="public")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long codUsuario;
    
    @Column(name = "nom_usuario")
    private String nomeUsuario;
    @Column(name = "sobrenome_usuario")
    private String sobrenomeUsuario;
    @Column(name = "txt_email")
    private String txtEmail;
    @Column(name = "txt_senha")
    private String txtSenha;
    @Column(name = "img_perfil")
    private Byte imgPerfil;
    @Column(name = "sexo")
    private String sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dat_nascimento")
    private Date datNascimento;
    @ManyToOne
    @JoinColumn(name = "cod_cidade")
    private Cidade cidade;

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }

    public Byte getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(Byte imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(Date datNascimento) {
        this.datNascimento = datNascimento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
   
}

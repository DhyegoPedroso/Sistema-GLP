package br.com.glp.controller;

import br.com.glp.dao.FuncionarioDao;
import br.com.glp.dao.FuncionarioDaoImpl;
import br.com.glp.dao.HibernateUtil;
import br.com.glp.model.Contato;
import br.com.glp.model.Endereco;
import br.com.glp.model.Funcionario;
import br.com.glp.model.Perfil;
import br.com.glp.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Leo
 */
@ManagedBean(name = "funcionarioC")
@ViewScoped
public class FuncionarioControl implements Serializable {

    private Session session;
    private boolean mostrar_toolbar;

    private Funcionario funcionario;
    private Endereco endereco;
    private Contato contato;
    private Usuario usuario;
    private Perfil perfil;

    private FuncionarioDao funcionarioDao;

    private DataModel<Funcionario> modelFuncionarios;
    private List<Funcionario> funcionarios;
    private List<Endereco> enderecos;
    private List<SelectItem> perfils;

    public FuncionarioControl() {
        funcionarioDao = new FuncionarioDaoImpl();
    }

    private void abreSessao() {
        if (session == null) {
            session = HibernateUtil.abreSessao();
        } else if (!session.isOpen()) {
            session = HibernateUtil.abreSessao();
        }
    }

    public void novo() {
        mostrar_toolbar = !mostrar_toolbar;
    }

    public void novaPesquisa() {
        mostrar_toolbar = !mostrar_toolbar;
    }

    public void preparaAlterar() {
        mostrar_toolbar = !mostrar_toolbar;
    }

    public void pesquisar() {
        try {
            abreSessao();
            funcionarios = funcionarioDao.pesquisaPorNome(funcionario.getNome(), session);
            modelFuncionarios = new ListDataModel(funcionarios);
            funcionario.setNome(null);
        } catch (Exception e) {
            System.out.println("erro ao pesquisar funcionario por nome: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void limpar() {
        funcionario = new Funcionario();
    }

    public void carregarParaAlterar() {
        mostrar_toolbar = !mostrar_toolbar;
        funcionario = modelFuncionarios.getRowData();
        endereco = funcionario.getEndereco();
    }

    public void excluir() {
        funcionario = modelFuncionarios.getRowData();
        abreSessao();
        try {
            funcionarioDao.remover(funcionario, session);
            funcionarios.remove(funcionario);
            modelFuncionarios = new ListDataModel(funcionarios);
            Mensagem.excluir("Funcionario");
            limpar();
        } catch (Exception e) {
            System.out.println("erro ao excluir: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void salvar() {
        abreSessao();
        try {
            funcionario.setEndereco(endereco);
            endereco.setPessoa(funcionario);
            funcionarioDao.salvarOuAlterar(funcionario, session);
            Mensagem.salvar("Funcionario: " + funcionario.getNome());
            funcionario = null;
            endereco = null;
        } catch (HibernateException e) {
            System.out.println("Erro ao salvar funcionario" + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro no salvar funcionarioDao Controle "
                    + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void limparTela() {
        limpar();
    }

    public Funcionario getFuncionario() {
        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }

        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public DataModel<Funcionario> getModelFuncionarios() {
        return modelFuncionarios;
    }

    public void setModelFuncionarios(DataModel<Funcionario> modelFuncionarios) {
        this.modelFuncionarios = modelFuncionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<SelectItem> getPerfils() {
        return perfils;
    }

    public void setPerfils(List<SelectItem> perfils) {
        this.perfils = perfils;
    }

    public boolean isMostrar_toolbar() {
        return mostrar_toolbar;
    }

    public void setMostrar_toolbar(boolean mostrar_toolbar) {
        this.mostrar_toolbar = mostrar_toolbar;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Contato getContato() {
        if (contato == null) {
            contato = new Contato();
        }
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        if (perfil == null) {
            perfil = new Perfil();
        }
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public FuncionarioDao getFuncionarioDao() {
        return funcionarioDao;
    }

    public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }

}

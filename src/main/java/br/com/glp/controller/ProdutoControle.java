package br.com.glp.controller;

import br.com.glp.dao.HibernateUtil;
import br.com.glp.dao.ProdutoDao;
import br.com.glp.dao.ProdutoDaoImpl;
import br.com.glp.model.Marca;
import br.com.glp.model.Produto;
import br.com.glp.model.Situacao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Pedrão Master
 */
@ManagedBean(name = "produtoC")
@ViewScoped
public class ProdutoControle implements Serializable {

    private boolean mostrar_Toolbar;
    private Session session;

    private ProdutoDao produtoDao;

    private Produto produto;
    private Marca marca;
    private Situacao situacao;

    private List<Produto> produtos;
    private DataModel<Produto> modelProduto;

    public ProdutoControle() {
        produtoDao = new ProdutoDaoImpl();
    }

    private void abreSessao() {
        if (session == null || !session.isOpen()) {
            session = HibernateUtil.abreSessao();
        } else if (!session.isOpen()) {
            session = HibernateUtil.abreSessao();
        }
    }

    public void novo() {
        mostrar_Toolbar = !mostrar_Toolbar;
        limpar();
    }

    public void novaPesquisa() {
        mostrar_Toolbar = !mostrar_Toolbar;
        limpar();
    }

    public void preparaAlterar() {
        mostrar_Toolbar = !mostrar_Toolbar;
        limpar();
    }

    public void carregarParaAlterar() {
        mostrar_Toolbar = !mostrar_Toolbar;
        produto = modelProduto.getRowData();
        marca.getProduto();
        situacao.getProduto();

    }

    public void pesquisar() {
        try {

            abreSessao();

            if (!produto.getNomeProduto().equals("")) {
                produtos = produtoDao.pesquisaPorNome(produto.getNomeProduto(), session);
            } else {
                produtos = produtoDao.listaTodos(session);
            }
            modelProduto = new ListDataModel(produtos);

//            produto.setNomeProduto(null);
        } catch (Exception e) {
            System.out.println("erro ao pesquisar produto por tipo: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void salvar() {
        try {
            abreSessao();
            produtoDao.salvarOuAlterar(produto, session);

            Mensagem.salvar("Produto ");
        } catch (HibernateException ex) {
            Mensagem.mensagemError("Erro ao salvar\nTente novamente");
            System.err.println("Erro ao pesquisar Produto:\n" + ex.getMessage());
        } finally {
            produto = new Produto();

            session.close();
        }
    }

    public void limpar() {
        produto = new Produto();
        marca = new Marca();
        situacao = new Situacao();
    }

    public void excluir() {
        produto = modelProduto.getRowData();
        try {
            abreSessao();
            produtoDao.remover(produto, session);
            Mensagem.excluir("Equipamento ");
        } catch (Exception ex) {
            System.err.println("Erro ao excluir equipamento\n" + ex.getMessage());
        } finally {
            session.close();
        }
    }

    public Produto getProduto() {
        if (produto == null) {
            produto = new Produto();

        }
        return produto;
    }

    public Marca getMarca() {
        if (marca == null) {
            marca = new Marca();
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Situacao getSituacao() {
        if (situacao == null) {
            situacao = new Situacao();

        }
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public boolean isMostrar_Toolbar() {
        return mostrar_Toolbar;
    }

    public void setMostrar_Toolbar(boolean mostrar_Toolbar) {
        this.mostrar_Toolbar = mostrar_Toolbar;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public DataModel<Produto> getModelProduto() {
        return modelProduto;
    }

    public void setModelProduto(DataModel<Produto> modelProduto) {
        this.modelProduto = modelProduto;
    }

}

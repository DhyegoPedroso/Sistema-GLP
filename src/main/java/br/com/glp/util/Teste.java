package br.com.glp.util;

import br.com.glp.dao.FuncionarioDao;
import br.com.glp.dao.FuncionarioDaoImpl;
import br.com.glp.dao.HibernateUtil;
import br.com.glp.dao.ProdutoDao;
import br.com.glp.dao.ProdutoDaoImpl;
import br.com.glp.model.Funcionario;
import br.com.glp.model.Produto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Dhyego Pedroso
 */
public class Teste {

    private Session session;

    private Funcionario funcionario;
    private FuncionarioDao funcionarioDao;

    private Produto produto;
    private ProdutoDao produtoDao;

    public Teste() {

        funcionarioDao = new FuncionarioDaoImpl();
        produtoDao = new ProdutoDaoImpl();
    }

    public void listarTodos() {

        session = HibernateUtil.abreSessao();

        List<Produto> produtos = produtoDao.listaTodos(session);

        for (Produto produto1 : produtos) {
            System.out.println("\n");
            System.out.println("---------------------------------------");
            System.out.println("Produto: " + produto1.getNomeProduto());
            System.out.println("Situação: " + produto1.getSituacao().getNomeSituacao());
            System.out.println("Marca: " + produto1.getMarca().getNomeMarca());
        }

    }

    public void listarPorId() {
        session = HibernateUtil.abreSessao();

        produto = produtoDao.pesquisaEntidadeId(3L, session);

        System.out.println("\n");
        System.out.println("--------------------------------");
        System.out.println("Produto: " + produto.getNomeProduto());
        System.out.println("Situação: " + produto.getSituacao().getNomeSituacao());
        System.out.println("Marca: " + produto.getMarca().getNomeMarca());

    }

    public static void main(String[] args) {

        Teste teste = new Teste();

        teste.listarTodos();
//        teste.listarPorId();

    }

}

package br.com.glp.dao;

import br.com.glp.model.Produto;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;

/**
 *
 * @author Dhyego Pedroso
 */
public class ProdutoDaoImplTest {

    private Session session;

    ProdutoDao produtoDao;
    Produto produto;

    public ProdutoDaoImplTest() {
        produtoDao = new ProdutoDaoImpl();
    }

    @Test
    public void testPesquisaEntidadeId() {
        
        session = HibernateUtil.abreSessao();
        
        produto = produtoDao.pesquisaEntidadeId(1L, session);
        
        System.out.println("Produto: "+produto.getNomeProduto());
    }

//    @Test
    public void testListaTodos() {
        
        session = HibernateUtil.abreSessao();

        List<Produto> produtos = produtoDao.listaTodos(session);

        for (Produto produto1 : produtos) {
            System.out.println("Funcionario: " + produto1.getNomeProduto());
            System.out.println("Login: " + produto1.getSituacao());
            System.out.println("\n");
            System.out.println("---------------------------------------");
            System.out.println("\n");
        }
    }

//    @Test
    public void testPesquisaPorNome() {
    }

//    @Test
    public void testListarPorTipo() {
    }

//    @Test
    public void testListarPorMarca() {
    }

}

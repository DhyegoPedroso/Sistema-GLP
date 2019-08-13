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
    }

    @Test
    public void testListaTodos() {
        
        session = HibernateUtil.abreSessao();

        List<Produto> produtos = produtoDao.listaTodos(session);

        for (Produto produto1 : produtos) {
            System.out.println("Id: " + produto1.getId());
            System.out.println("Produto: " + produto1.getNomeProduto());
            System.out.println("marca: " + produto1.getMarca().getNomeMarca());
            System.out.println("Quantidade: " + produto1.getSituacao().getNomeSituacao());
            System.out.println("Situação: " + produto1.getQuantidade());
            System.out.println("\n");
            System.out.println("------------------------------------------------");
            System.out.println("\n");
        }
    }

    @Test
    public void testPesquisaPorNome() {
    }

    @Test
    public void testListarPorTipo() {
    }

    @Test
    public void testListarPorMarca() {
    }

}

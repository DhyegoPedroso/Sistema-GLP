package br.com.glp.dao;

import br.com.glp.model.Funcionario;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;

/**
 *
 * @author Dhyego Pedroso
 */
public class FuncionarioDaoImplTest {

    private Session session;

    Funcionario funcionario;
    FuncionarioDao funcionarioDao;

    public FuncionarioDaoImplTest() {
        funcionarioDao = new FuncionarioDaoImpl();
    }

//    @Test
    public void testPesquisaEntidadeId() {
    }

//    @Test
    public void testListaTodos() {

        session = HibernateUtil.abreSessao();

        List<Funcionario> funcionarios = funcionarioDao.listaTodos(session);

        for (Funcionario funcionario1 : funcionarios) {
            System.out.println("Funcionario: " + funcionario1.getNome());
            System.out.println("Login: " + funcionario1.getUsuario().getLogin());
            System.out.println("\n");
            System.out.println("---------------------------------------");
            System.out.println("\n");
        }

    }

//    @Test
    public void testPesquisaPorNome() {
    }

//    @Test
    public void testListarPorUnidade() {
    }

//    @Test
    public void testBuscarPorCpf() {
    }

//    @Test
    public void testBuscarPorMatricula() {
    }

//    @Test
    public void testListarPorFuncao() {
    }

}

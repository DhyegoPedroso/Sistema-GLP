package br.com.glp.util;

import br.com.glp.dao.FuncionarioDao;
import br.com.glp.dao.FuncionarioDaoImpl;
import br.com.glp.dao.HibernateUtil;
import br.com.glp.dao.PerfilDao;
import br.com.glp.dao.PerfilDaoImpl;
import br.com.glp.model.Contato;
import br.com.glp.model.Endereco;
import br.com.glp.model.Funcionario;
import br.com.glp.model.Perfil;
import br.com.glp.model.Usuario;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Dhyego Pedroso
 */
public class InicializarPerfils {

    public void iniciarPerfils() {

        Session sessao = HibernateUtil.abreSessao();

        PerfilDao perfilDao = new PerfilDaoImpl();
        FuncionarioDao funcionarioDao = new FuncionarioDaoImpl();

        //Cadastrar Funcionario Administrador
        Perfil perfilAdmin = new Perfil("ROLE_ADMIN", "usuario como permissão de administrador", "Administrador");
        Contato contatoAdmin = new Contato("(48) 3030-3030", "(48) 99999-9999", "Admin@Admin.com", true);
        Endereco enderecoAdmin = new Endereco("Admin", 100, "Admin", "Admin", "Admin", "Admin", "Admin", "Admin");
        Usuario usuarioAdmin = new Usuario("admin", "admin", true, perfilAdmin);
        Funcionario funcionarioAdmin = new Funcionario("3.652.652-9", "333.333.333-33", "123456789", "Masculino", usuarioAdmin, "Admin Admin", enderecoAdmin, contatoAdmin, new Date());

        contatoAdmin.setPessoa(funcionarioAdmin);

        enderecoAdmin.setPessoa(funcionarioAdmin);

        usuarioAdmin.setFuncionario(funcionarioAdmin);

        perfilDao.salvarOuAlterar(perfilAdmin, sessao);

        funcionarioDao.salvarOuAlterar(funcionarioAdmin, sessao);

        //Cadastrar Funcionario Conferente
        Perfil perfilConferente = new Perfil("ROLE_CONFERENTE", "usuario logado com perfil básico", "Conferente");
        Contato contatoConferente = new Contato("(48) 3030-3030", "(48) 99999-9999", "Conferente@Conferente.com", true);
        Endereco enderecoConferrente = new Endereco("Conferente", 100, "Conferente", "Conferente", "Conferente", "Conferente", "Conferente", "Conferente");
        Usuario usuarioConferente = new Usuario("conferente", "conferente", true, perfilConferente);
        Funcionario funcionarioConferente = new Funcionario("3.652.652-9", "333.333.333-33", "123456789", "Masculino", usuarioConferente, "Conferente Conferente", enderecoConferrente, contatoConferente, new Date());

        contatoConferente.setPessoa(funcionarioConferente);

        enderecoConferrente.setPessoa(funcionarioConferente);

        usuarioConferente.setFuncionario(funcionarioConferente);

        perfilDao.salvarOuAlterar(perfilConferente, sessao);

        funcionarioDao.salvarOuAlterar(funcionarioConferente, sessao);

    }
}

package br.com.glp.dao;

import br.com.glp.model.Movimentacao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Dhyego Pedroso
 */
public class MovimentacaoDaoImpl extends BaseDaoImpl<Movimentacao, Long> implements MovimentacaoDao {

    @Override
    public Movimentacao pesquisaEntidadeId(Long id, Session session) throws HibernateException {
        return (Movimentacao) session.get(Movimentacao.class, id);
    }

    @Override
    public List<Movimentacao> listaTodos(Session session) throws HibernateException {
        return session.createQuery("from Movimentacao").list();
    }

    @Override
    public List<Movimentacao> pesquisaPorNome(String nome, Session session) throws HibernateException {
        return null;
    }

}

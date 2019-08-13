package br.com.glp.controller;

import br.com.glp.dao.MovimentacaoDao;
import br.com.glp.model.Movimentacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

/**
 *
 * @author Dhyego Pedroso
 */

@ManagedBean(name = "movimentacaoC")
@ViewScoped
public class MovimentacaoController {
    
    private Movimentacao movimentacao;
    
    private MovimentacaoDao movimentacaoDao;
    
    private Session session;
    private boolean mostrar_toolbar; 
    
}

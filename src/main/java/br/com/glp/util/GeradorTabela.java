package br.com.glp.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pedrão
 */
public class GeradorTabela {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("glpPU");
        emf.close();
        
        InicializarPerfils ip = new InicializarPerfils();
        ip.iniciarPerfils();
        
    }
}

package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {
	
	public static void main(String[] args) {
		
	
	EntityManager man = new JPAUtil().getEntityManager();
	
	man.getTransaction().begin();
	
	Conta conta = man.find(Conta.class,1);
	conta.setTitular("Luiz Ferreira");
	
	System.out.println(conta.getTitular());	
	man.getTransaction().commit();
	man.close();
	
	}

}

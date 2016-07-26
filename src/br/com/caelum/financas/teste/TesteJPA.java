package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Marcelo Garcia");
		conta.setBanco("Caixa");
		conta.setNumero("115");
		conta.setAgencia("325");
		
		EntityManager manager = new JPAUtil().getEntityManager();
				
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();		
		manager.close();
				
	}
}

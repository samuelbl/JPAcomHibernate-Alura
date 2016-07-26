package br.com.caelum.financas.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {
public static void main(String[] args) {
	
	EntityManager manager = new JPAUtil().getEntityManager();
	Conta conta = new Conta();
	conta.setId(2);
	
	
	Query query = manager.createQuery("select m from Movimentacao m where m.conta = :pconta ");
	
	query.setParameter("pconta", conta);
	
	@SuppressWarnings("unchecked")
	List<Movimentacao> movimentacoes = query.getResultList();
	
	for(Movimentacao m: movimentacoes){
		System.out.println("\nDescricao ..: " + m.getDescricao());
		System.out.println("Valor ......: R$ " + m.getValor());
	}
	
	
	
	manager.close();
	
	
}
}

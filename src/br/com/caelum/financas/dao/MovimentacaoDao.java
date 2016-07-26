package br.com.caelum.financas.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
		
	}

	public BigDecimal getSomaMovimentacaoConta(Conta conta) {
		TypedQuery<BigDecimal> query = manager.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pconta ", BigDecimal.class);
		query.setParameter("pconta", conta);
		return query.getSingleResult();
	}

}



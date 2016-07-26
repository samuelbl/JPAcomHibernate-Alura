package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Romero Abobora");
		conta.setBanco("Caixa");
		conta.setNumero("654");
		conta.setAgencia("987");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
				
		manager.getTransaction().begin();
		manager.persist(conta);
		
		manager.persist(movimentacao);
		manager.getTransaction().commit();		
		manager.close();
				
	}
}

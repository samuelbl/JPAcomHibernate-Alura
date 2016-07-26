package br.com.caelum.financas.teste;


import java.math.BigDecimal;


import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncoes {
public static void main(String[] args) {
	
	EntityManager manager = new JPAUtil().getEntityManager();
	Conta conta = new Conta();
	conta.setId(2);
	
	MovimentacaoDao dao = new MovimentacaoDao(manager);
	BigDecimal soma = dao.getSomaMovimentacaoConta(conta);
	
	System.out.println(soma);
	
	
	manager.close();
	
	
}
}

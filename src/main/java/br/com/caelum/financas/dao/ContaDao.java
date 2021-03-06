package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {
	private EntityManager entityManager;
	
	public ContaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Conta busca(Integer id) {
		return this.entityManager.find(Conta.class, id);
	}
	
	public List<Conta> lista() {
		return this.entityManager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}
	
	public void adiciona(Conta conta) {
		entityManager.persist(conta);
	}
	
	public void remove(Conta conta) {
		entityManager.remove(entityManager.merge(conta));
	}
}	

package max.desafio.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import max.desafio.dao.PartidaDao;
import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;

/**
 * Implementa��o do PartidaDao em mem�ria
 */
public class PartidaDaoEmMemoriaImpl implements PartidaDao {
	
	private static Set<Partida> partidas = new LinkedHashSet<Partida>();

	/**
	 * Implementa��o de inserir em mem�ria
	 */
	public void inserir(Partida novaPartida) throws DesafioExcecao {
		if (partidas.contains(novaPartida)) {
			throw new DesafioExcecao("A partida j� foi inserida.");
		}
		partidas.add(novaPartida);
	}

	/**
	 * Implementa��o de buscarTodas em mem�ria
	 */
	public Collection<Partida> buscarTodas() throws DesafioExcecao {
		// retorna uma cole��o
		return Collections.unmodifiableCollection(partidas);
	}
	
	/**
	 * Implementa��o de limpar em mem�ria
	 */
	public void limpar() {
		partidas.clear();
	}
	
}

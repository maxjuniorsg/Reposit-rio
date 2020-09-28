package max.desafio.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import max.desafio.dao.PartidaDao;
import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;

/**
 * Implementação do PartidaDao em memória
 */
public class PartidaDaoEmMemoriaImpl implements PartidaDao {
	
	private static Set<Partida> partidas = new LinkedHashSet<Partida>();

	/**
	 * Implementação de inserir em memória
	 */
	public void inserir(Partida novaPartida) throws DesafioExcecao {
		if (partidas.contains(novaPartida)) {
			throw new DesafioExcecao("A partida já foi inserida.");
		}
		partidas.add(novaPartida);
	}

	/**
	 * Implementação de buscarTodas em memória
	 */
	public Collection<Partida> buscarTodas() throws DesafioExcecao {
		// retorna uma coleção
		return Collections.unmodifiableCollection(partidas);
	}
	
	/**
	 * Implementação de limpar em memória
	 */
	public void limpar() {
		partidas.clear();
	}
	
}

package max.desafio.dao;

import java.util.Collection;

import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;

/**
 * Interface do DAO para persistência das partidas
 */
public interface PartidaDao {

	/**
	 * Insere uma nova partida
	 * @param novaPartida a partida a ser inserida
	 * @throws DesafioExcecao caso já exista uma partida
	 */
	void inserir(Partida novaPartida) throws DesafioExcecao;

	/**
	 * @return todas as partidas inseridas
	 * @throws DesafioExcecao em caso de erro
	 */
	Collection<Partida> buscarTodas() throws DesafioExcecao;

	/**
	 * Limpa todas as partidas gravadas
	 */
	void limpar();

}
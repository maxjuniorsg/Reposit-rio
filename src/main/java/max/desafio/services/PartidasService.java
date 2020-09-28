package max.desafio.services;

import java.util.List;

import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;
import max.desafio.model.PartidaResultado;

public interface PartidasService {

	void inserir(Partida novaPartida) throws DesafioExcecao;

	List<PartidaResultado> buscarTodas() throws DesafioExcecao;

	void limpar();

}
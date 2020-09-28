package max.desafio.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import max.desafio.dao.PartidaDao;
import max.desafio.dao.impl.PartidaDaoEmMemoriaImpl;
import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;
import max.desafio.model.PartidaResultado;
import max.desafio.services.PartidasService;

public class PartidasServiceImpl implements PartidasService {
	
	private PartidaDao partidaDao = new PartidaDaoEmMemoriaImpl();
	
	public void inserir(Partida novaPartida) throws DesafioExcecao {
		partidaDao.inserir(novaPartida);
	}

	public List<PartidaResultado> buscarTodas() throws DesafioExcecao {
		Collection<Partida> todas = partidaDao.buscarTodas();
		List<PartidaResultado> resultado = new ArrayList<PartidaResultado>();
		int minimo = Integer.MAX_VALUE;
		int maximo = -1;
		int quebrasMin = -1;
		int quebrasMax = -1;
		for (Partida partida : todas) {
			if (partida.getPlacar() < minimo) {
				quebrasMin++;
				minimo = partida.getPlacar();
			}
			if (partida.getPlacar() > maximo) {
				quebrasMax++;
				maximo = partida.getPlacar();
			}
			resultado.add(new PartidaResultado(partida, minimo, maximo, quebrasMin, quebrasMax));
		}
		return resultado;
	}
	
	public void limpar() {
		partidaDao.limpar();
	}

}

package max.desafio;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import max.desafio.exceptions.DesafioExcecao;
import max.desafio.model.Partida;
import max.desafio.model.PartidaResultado;
import max.desafio.services.PartidasService;
import max.desafio.services.impl.PartidasServiceImpl;

public class PartidasTest {

	PartidasService service;

	@Before
	public void setup() {
		service = new PartidasServiceImpl();
	}

	@Test
	public void testInserir() throws DesafioExcecao {
		service.limpar();
		Partida novaPartida = new Partida(1, 2);
		service.inserir(novaPartida);
		List<PartidaResultado> todas = service.buscarTodas();
		Assert.assertEquals(todas.size(), 1);
	}

	@Test
	public void testConsultar() throws DesafioExcecao {
		service.limpar();
		service.inserir(new Partida(1, 12));
		service.inserir(new Partida(2, 24));
		service.inserir(new Partida(3, 10));
		service.inserir(new Partida(4, 24));
		List<PartidaResultado> todas = service.buscarTodas();
		PartidaResultado resultado1 = todas.get(0);
		PartidaResultado resultado2 = todas.get(1);
		PartidaResultado resultado3 = todas.get(2);
		PartidaResultado resultado4 = todas.get(3);
		Assert.assertEquals(resultado1.getMinimoTemporada(), 12);
		Assert.assertEquals(resultado1.getMaximoTemporada(), 12);
		Assert.assertEquals(resultado1.getQuebraRecordeMin(), 0);
		Assert.assertEquals(resultado1.getQuebraRecordeMax(), 0);
		Assert.assertEquals(resultado2.getMinimoTemporada(), 12);
		Assert.assertEquals(resultado2.getMaximoTemporada(), 24);
		Assert.assertEquals(resultado2.getQuebraRecordeMin(), 0);
		Assert.assertEquals(resultado2.getQuebraRecordeMax(), 1);
		Assert.assertEquals(resultado3.getMinimoTemporada(), 10);
		Assert.assertEquals(resultado3.getMaximoTemporada(), 24);
		Assert.assertEquals(resultado3.getQuebraRecordeMin(), 1);
		Assert.assertEquals(resultado3.getQuebraRecordeMax(), 1);
		Assert.assertEquals(resultado4.getMinimoTemporada(), 10);
		Assert.assertEquals(resultado4.getMaximoTemporada(), 24);
		Assert.assertEquals(resultado4.getQuebraRecordeMin(), 1);
		Assert.assertEquals(resultado4.getQuebraRecordeMax(), 1);
	}

}

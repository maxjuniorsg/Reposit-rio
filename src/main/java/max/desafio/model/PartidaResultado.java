package max.desafio.model;

public class PartidaResultado {

	private Partida partida;

	private int minimoTemporada;

	private int maximoTemporada;

	private int quebraRecordeMin;

	private int quebraRecordeMax;

	public PartidaResultado(Partida partida, int minimoTemporada, int maximoTemporada, int quebraRecordeMin,
			int quebraRecordeMax) {
		this.partida = partida;
		this.minimoTemporada = minimoTemporada;
		this.maximoTemporada = maximoTemporada;
		this.quebraRecordeMin = quebraRecordeMin;
		this.quebraRecordeMax = quebraRecordeMax;
	}
	
	public PartidaResultado() {
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public int getMinimoTemporada() {
		return minimoTemporada;
	}

	public void setMinimoTemporada(int minimoTemporada) {
		this.minimoTemporada = minimoTemporada;
	}

	public int getMaximoTemporada() {
		return maximoTemporada;
	}

	public void setMaximoTemporada(int maximoTemporada) {
		this.maximoTemporada = maximoTemporada;
	}

	public int getQuebraRecordeMin() {
		return quebraRecordeMin;
	}

	public void setQuebraRecordeMin(int quebraRecordeMin) {
		this.quebraRecordeMin = quebraRecordeMin;
	}

	public int getQuebraRecordeMax() {
		return quebraRecordeMax;
	}

	public void setQuebraRecordeMax(int quebraRecordeMax) {
		this.quebraRecordeMax = quebraRecordeMax;
	}

}

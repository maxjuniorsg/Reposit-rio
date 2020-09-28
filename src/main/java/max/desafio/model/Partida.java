package max.desafio.model;

public class Partida {
	
	private int numero;
	
	private int placar;

	
	public Partida() {
	}

	public Partida(int numero, int placar) {
		this.numero = numero;
		this.placar = placar;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPlacar(int placar) {
		this.placar = placar;
	}

	@Override
	public int hashCode() {
		return numero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

}

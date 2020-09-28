package max.desafio.exceptions;

public class DesafioExcecao extends Exception {

	private static final long serialVersionUID = 7950952818768053408L;

	public DesafioExcecao() {
		super();
	}

	public DesafioExcecao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DesafioExcecao(String message, Throwable cause) {
		super(message, cause);
	}

	public DesafioExcecao(String message) {
		super(message);
	}

	public DesafioExcecao(Throwable cause) {
		super(cause);
	}

}

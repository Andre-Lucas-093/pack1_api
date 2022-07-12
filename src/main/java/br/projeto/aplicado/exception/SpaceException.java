package br.projeto.aplicado.exception;

public class SpaceException extends Exception{

	private static final long serialVersionUID = 1L;

	public SpaceException() {
		super();
	}

	public SpaceException(String message) {
		super(message);
	}

	public SpaceException(String message, Exception cause) {
		super(message, cause);
	}

	public SpaceException(Exception e) {
		super(e);
	}
}

package br.projeto.aplicado.exception;

public class ReservationException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public ReservationException() {
		super();
	}

	public ReservationException(String message) {
		super(message);
	}

	public ReservationException(String message, Exception cause) {
		super(message, cause);
	}

	public ReservationException(Exception e) {
		super(e);
	}
}

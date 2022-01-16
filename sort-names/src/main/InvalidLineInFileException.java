package main;

public class InvalidLineInFileException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidLineInFileException(String message) {
		super(message);
	}
}

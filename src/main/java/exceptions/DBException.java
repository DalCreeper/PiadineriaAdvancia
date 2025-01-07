package exceptions;

public class DBException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DBException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public DBException(String msg) {
		super(msg);
	}
}


package utn.frba.disenio.tp.prenda.constructores.excepciones;

public class TramaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TramaInvalidaException(String descripcion) {
		super(String.format("La trama %s no es válida", descripcion));
	}
	
	
}
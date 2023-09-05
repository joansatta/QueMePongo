package utn.frba.disenio.tp.prenda.constructores.excepciones;

public class PrendaNoInstanciadaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrendaNoInstanciadaException() {
		super("Operación no permitida. No hay prenda para modificar ni retornar.");
	}
	
	
}
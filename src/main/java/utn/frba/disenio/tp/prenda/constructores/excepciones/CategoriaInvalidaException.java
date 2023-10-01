package utn.frba.disenio.tp.prenda.constructores.excepciones;

public class CategoriaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoriaInvalidaException(String descripcion) {
		super(String.format("La categoría %s no es válida", descripcion));
	}
	
	
}
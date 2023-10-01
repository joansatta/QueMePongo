package utn.frba.disenio.tp.prenda.constructores.excepciones;

public class GuardarropasNoValidoExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GuardarropasNoValidoExcepcion(String username) {
		super(String.format("El guardarropas no pertenece al usuario %s",username));
	}
	
	
}
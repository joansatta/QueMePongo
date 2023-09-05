package utn.frba.disenio.tp.prenda.constructores.excepciones;

public class MaterialInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MaterialInvalidoException(String material) {
		super(String.format("El material %s no es válido", material));
	}

	public MaterialInvalidoException(String material,String tipo) {
		super(String.format(
				"El material %s no es compatible con el tipo de prenda %s", 
				material,tipo));
	}

}

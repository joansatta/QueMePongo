package utn.frba.disenio.tp.prenda.constructores.excepciones;

import utn.frba.disenio.tp.prenda.CategoriaEnum;

public class TipoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TipoInvalidoException(String tipo,CategoriaEnum categoria) {
		super(String.format(
				"El tipo %s no es compatible con la categoria %s", 
				tipo,categoria.toString()));
	}

}

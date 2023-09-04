package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Tipo;

public interface TipoPrendaFactory {

	public Tipo getInstance(String descripcion,CategoriaEnum categoria) throws TipoInvalidoException;

}

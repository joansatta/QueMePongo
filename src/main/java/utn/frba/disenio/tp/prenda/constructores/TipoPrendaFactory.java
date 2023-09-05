package utn.frba.disenio.tp.prenda.constructores;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.Trama;

public interface TipoPrendaFactory {

	public Tipo getInstance(String descripcion,CategoriaEnum categoria,Trama trama);

}

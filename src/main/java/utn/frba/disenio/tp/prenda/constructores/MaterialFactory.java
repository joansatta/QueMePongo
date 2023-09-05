package utn.frba.disenio.tp.prenda.constructores;

import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Trama;

public interface MaterialFactory {

	public Material getInstance(String descripcion,Trama trama);

}

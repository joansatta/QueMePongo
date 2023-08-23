package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;

public interface PrendaMaterialFactory {

	public Prenda crearPrenda(Material material, Tipo tipo,Color colorPrimario);
	public Prenda crearPrenda(Material material, Tipo tipo,Color colorPrimario,Color colorSecundario);

}

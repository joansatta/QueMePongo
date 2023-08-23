package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;

public class AccesorioFactory implements PrendaMaterialFactory {

	public Prenda crearPrenda(Material material, Tipo tipo, Color colorPrimario) {
		return new Prenda(CategoriaEnum.Accesorio,material,tipo,colorPrimario,null);
	}

	public Prenda crearPrenda(Material material, Tipo tipo, Color colorPrimario, Color colorSecundario) {
		return new Prenda(CategoriaEnum.Accesorio,material,tipo,colorPrimario,colorSecundario);
	}

}

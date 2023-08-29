package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;

public class PrendaInferiorFactory implements PrendaFactory {

	public Prenda crearPrenda(Material material, Tipo tipo, Color colorPrimario) {
		return new Prenda(CategoriaEnum.ParteInferior,material,tipo,colorPrimario,null);
	}

	public Prenda crearPrenda(Material material, Tipo tipo, Color colorPrimario, Color colorSecundario) {
		return new Prenda(CategoriaEnum.ParteInferior,material,tipo,colorPrimario,colorSecundario);
	}

}

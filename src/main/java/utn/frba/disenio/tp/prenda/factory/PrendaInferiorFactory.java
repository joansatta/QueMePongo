package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tela;
import utn.frba.disenio.tp.prenda.Tipo;

public class PrendaInferiorFactory implements PrendaTelaFactory {

	public Prenda crearPrenda(Tela tela, Tipo tipo, Color colorPrimario) {
		return new Prenda(CategoriaEnum.ParteInferior,tela,tipo,colorPrimario,null);
	}

	public Prenda crearPrenda(Tela tela, Tipo tipo, Color colorPrimario, Color colorSecundario) {
		return new Prenda(CategoriaEnum.ParteInferior,tela,tipo,colorPrimario,colorSecundario);
	}

}

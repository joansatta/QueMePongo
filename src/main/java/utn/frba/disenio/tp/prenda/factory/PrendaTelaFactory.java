package utn.frba.disenio.tp.prenda.factory;

import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tela;
import utn.frba.disenio.tp.prenda.Tipo;

public interface PrendaTelaFactory {

	public Prenda crearPrenda(Tela tela, Tipo tipo,Color colorPrimario);
	public Prenda crearPrenda(Tela tela, Tipo tipo,Color colorPrimario,Color colorSecundario);

}

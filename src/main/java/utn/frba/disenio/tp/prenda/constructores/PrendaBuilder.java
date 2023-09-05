package utn.frba.disenio.tp.prenda.constructores;

import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;

public interface PrendaBuilder {

	public PrendaBuilder start(Tipo tipo);
	public PrendaBuilder setMaterial(Material material);
	public PrendaBuilder setColorPrimario(Color color);
	public PrendaBuilder setColorSecundario(Color color);
	public Prenda build();
	public void reset();

}

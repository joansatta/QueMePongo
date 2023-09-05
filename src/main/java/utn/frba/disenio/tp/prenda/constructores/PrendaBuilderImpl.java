package utn.frba.disenio.tp.prenda.constructores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utn.frba.disenio.tp.prenda.Color;
import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Prenda;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.constructores.excepciones.MaterialInvalidoException;
import utn.frba.disenio.tp.prenda.constructores.excepciones.PrendaNoInstanciadaException;

public class PrendaBuilderImpl implements PrendaBuilder {
	
	private Prenda prendaBorrador;
	private Map<String,List<String>> materialesValidos;
	
	{
		materialesValidos = new HashMap<String,List<String>>();
		materialesValidos.put("Almidón",Arrays.asList(new String[] {"Remera"}));
		materialesValidos.put("Jean",Arrays.asList(new String[] {"Pantalón"}));
		materialesValidos.put("Cuero",Arrays.asList(new String[] {"Pulcera","Zapatilla"}));
	}

	@Override
	public PrendaBuilder start(Tipo tipo) {
		prendaBorrador = new Prenda(tipo);
		return this;
	}

	@Override
	public PrendaBuilder setMaterial(Material material) {
		validarPrendaNotNull();
		if(!materialesValidos.get(material.getDescripcion())
				.contains(prendaBorrador.getTipo())) {
			throw new MaterialInvalidoException(material.getDescripcion(), prendaBorrador.getTipo());
		}
		prendaBorrador.setMaterial(material);
		return this;
	}

	@Override
	public PrendaBuilder setColorPrimario(Color color) {
		validarPrendaNotNull();
		prendaBorrador.setColorPrimario(color);
		return this;
	}
	
	@Override
	public PrendaBuilder setColorSecundario(Color color) {
		validarPrendaNotNull();
		prendaBorrador.setColorSecundario(color);
		return this;
	}

	@Override
	public Prenda build() {
		validarPrendaNotNull();
		Prenda prendaRet = prendaBorrador.clone();
		prendaBorrador = null;
		return prendaRet;
	}
	
	@Override
	public void reset() {
		prendaBorrador=null;
	}
	

	private void validarPrendaNotNull() {
		if(prendaBorrador==null) {
			throw new PrendaNoInstanciadaException();
		}
	}


}

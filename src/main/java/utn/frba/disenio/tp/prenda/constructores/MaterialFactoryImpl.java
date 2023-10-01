package utn.frba.disenio.tp.prenda.constructores;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import utn.frba.disenio.tp.prenda.Material;
import utn.frba.disenio.tp.prenda.Trama;
import utn.frba.disenio.tp.prenda.constructores.excepciones.MaterialInvalidoException;

@Component
public class MaterialFactoryImpl implements MaterialFactory {

	private List<String> materialesValidos;
	
	//Initializer
	{
		materialesValidos = Arrays.asList(new String[]
				{"Almidón", "Cuero"});
	}
	
	@Override
	public Material getInstance(String descripcion,Trama trama) {
		if(materialesValidos.contains(descripcion)) {
			return new Material(descripcion,trama);
		} else {
			throw new MaterialInvalidoException(descripcion);
		}
	}
	
	

}

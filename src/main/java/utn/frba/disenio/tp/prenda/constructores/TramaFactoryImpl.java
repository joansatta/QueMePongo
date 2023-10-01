package utn.frba.disenio.tp.prenda.constructores;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import utn.frba.disenio.tp.prenda.Trama;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TramaInvalidaException;
@Component
public class TramaFactoryImpl implements TramaFactory {

	private List<String> tramasValidas;
	
	//Initializer
	{
		tramasValidas = Arrays.asList(new String[]
				{"lisa", "rayada", "con lunares", "a cuadros", "estampado"});
	}
	
	@Override
	public Trama getInstance(String descripcion) {
		if(tramasValidas.contains(descripcion)) {
			return new Trama(descripcion);
		} else {
			throw new TramaInvalidaException(descripcion);
		}
	}
	
	

}

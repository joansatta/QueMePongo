package utn.frba.disenio.tp.prenda.constructores;

import java.util.HashMap;
import java.util.Map;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Tipo;
import utn.frba.disenio.tp.prenda.constructores.excepciones.TipoInvalidoException;

public class TipoPrendaFactoryImpl implements TipoPrendaFactory {

	private Map<String,CategoriaEnum> prendasValidas;
	
	//Initializer
	{
		prendasValidas = new HashMap<String,CategoriaEnum>();
		prendasValidas.put("Remera",CategoriaEnum.ParteSuperior);
		prendasValidas.put("Pantalon",CategoriaEnum.ParteInferior);
		prendasValidas.put("Zapatilla",CategoriaEnum.Calzado);
		prendasValidas.put("Pulcera",CategoriaEnum.Accesorio);
	}
	
	@Override
	public Tipo getInstance(String descripcion, CategoriaEnum categoria) {
		if(prendasValidas.get(descripcion)!=null) {
			return new Tipo(descripcion,categoria);
		} else {
			throw new TipoInvalidoException(descripcion,categoria);
		}
	}
	
	

}

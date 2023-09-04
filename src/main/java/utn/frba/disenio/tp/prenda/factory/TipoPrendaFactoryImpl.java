package utn.frba.disenio.tp.prenda.factory;

import java.util.HashMap;
import java.util.Map;

import utn.frba.disenio.tp.prenda.CategoriaEnum;
import utn.frba.disenio.tp.prenda.Tipo;

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
	public Tipo getInstance(String descripcion, CategoriaEnum categoria) throws TipoInvalidoException {
		if(prendasValidas.get(descripcion)!=null) {
			return new Tipo(descripcion,categoria);
		} else {
			throw new TipoInvalidoException(String.format(
					"El tipo %s no es compatible con la categoria %s", 
					descripcion,categoria.toString()));
		}
		
	}
	
	

}

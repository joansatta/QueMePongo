package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Tipo {

	@NonNull private String descripcion;
	@NonNull private CategoriaEnum categoria;

}

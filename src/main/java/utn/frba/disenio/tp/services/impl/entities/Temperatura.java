package utn.frba.disenio.tp.services.impl.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Temperatura {

	@NonNull private Integer valor;
	@NonNull private String unidad;
	@NonNull private Integer tipoUnidad;

	public Temperatura clonar() {
		return new Temperatura(valor,unidad,tipoUnidad);
	}
}

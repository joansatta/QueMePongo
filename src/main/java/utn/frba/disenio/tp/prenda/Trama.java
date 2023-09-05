package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trama {

	private String descripcion;
	
	public Trama clonar() {
		return new Trama(descripcion);
	}
	
}

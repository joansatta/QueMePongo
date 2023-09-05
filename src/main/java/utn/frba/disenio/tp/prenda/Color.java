package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Color {

	private String descripcion;
	
	public Color clonar() {
		return new Color(descripcion);
	}
}

package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Color implements Cloneable {

	private String descripcion;
	
	public Color clone() {
		try {
			return (Color) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}

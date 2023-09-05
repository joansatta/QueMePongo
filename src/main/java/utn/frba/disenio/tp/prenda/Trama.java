package utn.frba.disenio.tp.prenda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trama implements Cloneable {

	private String descripcion;
	
	public Trama clone() {
		try {
			return (Trama)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
	
}
